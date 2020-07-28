package VigenereProgram;

import java.util.*;
import java.io.*;
import edu.duke.*;

public class VigenereBreaker {
    
    
    public String sliceString(String message, int whichSlice, int totalSlices) {
        StringBuilder slicedString = new StringBuilder();
        for(int i = whichSlice; i < message.length() ; i += totalSlices){
            slicedString.append(message.charAt(i));
        }
        return slicedString.toString();
    }

    public int[] tryKeyLength( String encrypted, int klength, char mostCommon) {

        int[] key = new int[klength];
         CaesarCracker ck = new CaesarCracker(mostCommon);
         for(int i = 0 ; i < klength ; i++){
             String slicedString = sliceString(encrypted, i, klength);
             int k = ck.getKey(slicedString);
             key[i] = k;
             
            }
         
        
        return key;
    }

   
    
    
    public HashSet<String> readDictionary(FileResource resource){
        System.out.println("Lines from dictionary");
        HashSet<String> wordsInDictionary = new HashSet<String>();
        for(String line : resource.lines()){
            line = line.toLowerCase();
            wordsInDictionary.add(line);
        }
        
        return wordsInDictionary;
    }
    
    public int countWords(String message, HashSet<String> dictionary){
       String[] sa = message.split("\\W+");
        int i = 0;
        for (String s: sa){
            String slower = s.toLowerCase();
            if (dictionary.contains(slower)){
                i++;
            }
        }
        return i;
    }
    
    
    public String  breakForLanguage(String encrypted, HashSet<String> dictionary){
        
  int max = 0;
        char c = mostCommonCharIn(dictionary);
        for (int i = 1; i <= 100; i++){
            int[] key = tryKeyLength(encrypted, i, c);
            VigenereCipher vc = new VigenereCipher(key);
            String s = vc.decrypt(encrypted);
            int a = countWords(s, dictionary);
            if (a > max){
                max = a;
            }
        }
        System.out.println("file contains " + max  + "valid words " );
        for (int j = 1; j <= 100; j++){
            int[] key = tryKeyLength(encrypted, j, c);
            VigenereCipher vc = new VigenereCipher(key);
            String s = vc.decrypt(encrypted);
            int a = countWords(s, dictionary);
            if (j == 38){
                System.out.println(j + "\n" + a);
            }
            if (a == max){
                //System.out.println(j + "\n" + a);
                
                return s;
            }
        }
        
        
        return null;
    }
    public char mostCommonCharIn(HashSet<String> dictionary){
        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
        for (String s: dictionary){
            String slower = s.toLowerCase();
            for (char c: slower.toCharArray()){
                if (hm.containsKey(c)){
                    hm.put(c, hm.get(c) + 1);
                }
                else{
                    hm.put(c, 1);
                }
            }
        }
        int max = 0;
        for (char c: hm.keySet()){
            if (hm.get(c) > max){
                max = hm.get(c);
            }
        }
        for (char c: hm.keySet()){
            if (hm.get(c) == max){
                return c;
            }
        }
        return 'n';
    }
    
     public void breakVigenere () {
        System.out.println("Select a file to decrypt");
        FileResource fr = new FileResource();
        String message = fr.asString();
         System.out.println("**********************************");
         System.out.println("Select a dictionary");
           DirectoryResource dr = new DirectoryResource();
           
           for( File file : dr.selectedFiles() ){
                System.out.println(" ---------------------From " +  file.getName().toString() + " --------------------------");
               FileResource dictionaryFr = new FileResource(file);
            HashSet<String> wordsFromDict =  readDictionary(dictionaryFr);
            
       int[] foundKey = tryKeyLength(message,5, 'e');
       
       System.out.println("Key found " + Arrays.toString(foundKey));

         VigenereCipher vc = new VigenereCipher(foundKey);
         
         
         String d_message= breakForLanguage(message, wordsFromDict);
         System.out.println(" Out of "  + wordsFromDict.size());
        
       System.out.println(d_message.substring(0,200));
       
      
            
            }
       
        
        
        
    }
    
    
   
    
}
