
/**
 * Write a description of CaesarBreaker here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.FileResource;
public class CaesarBreaker {
    
    
    public int[] countLetters(String message){
        String alph = "abcdefghijklmnopqrstuvwxyz";
        int[] counts = new int[26];
        
        for(int k=0; k<message.length(); k++){
            char ch = Character.toLowerCase(message.charAt(k));
            int dex = alph.indexOf(ch);
            if (dex != -1){
                counts[dex] +=1;
            }
        }
          return counts;
    }

    public int maxIndex(int[] vals){
    int maxDex = 0;
        
     for(int k=0 ; k < vals.length; k++){
         if(vals[k] > vals[maxDex]){
            maxDex = k;
            }
     }
     
     return maxDex;
    }
    
    public int getKey(String s){
       
        int[] freqs = countLetters(s);
        int maxDex = maxIndex(freqs);
        int dkey = 0;
        if(maxDex < 4){
            dkey = 26 - ( 4 - maxDex );
        }else{
            dkey = maxDex - 4;
        }
 
        return dkey  ;
    }
    
    public String decryptTwoKeys (String encrypted){
        CaesarCipher cc = new CaesarCipher();
        String descryptedString = "";
        String firstHalf = halfOfString(encrypted, 0);
        String secHalf = halfOfString(encrypted, 1);
        int ke1 = getKey(firstHalf);
        System.out.println("key1 = " + ke1);
        int ke2 = getKey(secHalf);
        System.out.println("key2 = " + ke2 );
        descryptedString = cc.encryptTwoKeys(encrypted, 26-ke1, 26-ke2);
        return descryptedString;
    }
    public String decrypt(String encrypted){
        
        // instanciate a ceaser cipher object
        CaesarCipher cc = new CaesarCipher();
        int key = getKey(encrypted);
        
        // riverse the encryption using the found ramdom key
        return cc.encrypt(encrypted, 26-key);
    }
    
    public String halfOfString (String message, int start){
    
    StringBuilder newString = new StringBuilder();
    for(int x = start ; x < message.length(); x ++){
        
            if(x % 2 != 0 && start ==  1){
                    newString.append(message.charAt(x));
            }
            else if(x % 2 == 0 && start == 0){
                    newString.append(message.charAt(x));
             }
            
        
        
    }
    
        return newString.toString();

    }
    
    public void tesDecrypt(){
       //CaesarCipher cc = new CaesarCipher();
       // String e_message = cc.encrypt(message, 20);
       // System.out.println("Encrypted message is " + e_message);
       String e_message = "qbylyypyl uhinbyl ufjbuvyn cm chpyhnyx sio zchx nby wuvfy gixylh jfyumy uhx uuuffyyffosuuu uhx qbs hin";
       String d_message = decrypt(e_message);
       System.out.println("Decrypted message is " + d_message );
    }
    
   
    
    
    public void test_getKey(){
       //FileResource resource = new FileResource("data/smallHamlet.txt");
       //FileResource resource = new FileResource("data/wordsLotsOfEs.txt");
       String message = "whereever another alphabet is invented you find the cable modern please and aaalleelluyaaa and why not";
       CaesarCipher cc = new CaesarCipher();
       String e_message = cc.encrypt(message, 20);
       int key = getKey(e_message);
       System.out.println( "key of encrypted message is " + key  );

        
    }
    
    
    public void testDecryptTwoKeys(){
          
          FileResource fr = new FileResource("mysteryTwoKeysPractice.txt");
          String s  =  fr.asString();
          String d_message = decryptTwoKeys(s);
          System.out.println("Decrypted message is " + d_message);
         
          


     
    
    }
    
    
    


    public void testhalfOfString(){
    String message = "Qbkm Zgis";
    int start = 0;
    System.out.println(halfOfString(message,start ));
    }
    
    

}
