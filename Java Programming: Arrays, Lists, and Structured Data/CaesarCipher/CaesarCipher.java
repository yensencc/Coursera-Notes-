
/**
 * Write a description of CaesarCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;
import java.lang.StringBuilder;
public class CaesarCipher {
    

        private String alphabet = "";
        private String lowerAlphabet = "";
        private String shiftedAlphabet = "";
        private String lshiftedAlphabet = "";
        private  int mainKey = 0;
    
      public CaesarCipher(int key){
        // Write down the alphabet
            alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            lowerAlphabet = alphabet.toLowerCase();
            // compute the shifted alphabet
            shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0, key);
            lshiftedAlphabet = lowerAlphabet.substring(key) + lowerAlphabet.substring(0, key);
            mainKey = key;
      }
    
      public String encrypt (String input ) {
      
            // make a StringBuilder with message (encrypted)
   
            StringBuilder encrypted = new StringBuilder (input);
            
            
            
            // count from 0 to  < length of encrupted, (call it i)
            for(int i = 0; i < encrypted.length(); i ++ ){
            // look at the ith character of encrypted  (call it currchar)
            char currChar = encrypted.charAt(i);
            // find the index of currchar in the alphabet (call it idx)
            int idx = alphabet.indexOf(currChar);
            int lidx = lowerAlphabet.indexOf(currChar);
            // if currChar is in the alphabet
            
            char newChar = '-';
            if (idx != -1 ){
                // get the idx character of shifted alphabet (newChar)
                newChar = shiftedAlphabet.charAt(idx);
                // replace the ith character on encrypted with newChar
                encrypted.setCharAt(i, newChar);
            }
            if(lidx != -1){
               newChar = lshiftedAlphabet.charAt(lidx);
               encrypted.setCharAt(i,newChar);
            }
        }
        
            // Your answer is the String inside of encrypted
                return encrypted.toString();
   }
   
     public void testCaesar(){
            // FileResource fr = new FileResource();
            // String message = fr.asString();
            String message = "Can you imagine life WITHOUT the internet AND computers in your pocket?";
            String encrypted = encrypt(message);
            System.out.println(encrypted);
             String decrypted = decrypt(encrypted);
             System.out.println(decrypted);
   }
   
   
   public String decrypt(String input){
        
         // instanciate a ceaser cipher object
        CaesarCipher cc = new CaesarCipher(26-mainKey);
        // riverse the encryption using the found ramdom key
        return cc.encrypt(input);
    }
    
    
    // public int getKey(String s){
       
        // int[] freqs = countLetters(s);
        // int maxDex = maxIndex(freqs);
        // int dkey = 0;
        // if(maxDex < 4){
            // dkey = 26 - ( 4 - maxDex );
        // }else{
            // dkey = maxDex - 4;
        // }
 
        // return dkey  ;
    // }
    
    
    // public int maxIndex(int[] vals){
    // int maxDex = 0;
        
     // for(int k=0 ; k < vals.length; k++){
         // if(vals[k] > vals[maxDex]){
            // maxDex = k;
            // }
     // }
     
     // return maxDex;
    // }
    
    
    // public int[] countLetters(String message){
        // String alph = "abcdefghijklmnopqrstuvwxyz";
        // int[] counts = new int[26];
        
        // for(int k=0; k<message.length(); k++){
            // char ch = Character.toLowerCase(message.charAt(k));
            // int dex = alph.indexOf(ch);
            // if (dex != -1){
                // counts[dex] +=1;
            // }
        // }
          // return counts;
    // }
    
    
   
   
  
   
   
   public String encryptTwoKeys (String input, int key1, int key2){
        StringBuilder encrypted = new StringBuilder(input);
        
         // Write down the alphabet
            String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            String lowerAlphabet = alphabet.toLowerCase();
            // compute the shifted alphabet with key 1
            String shiftedAlphabet = alphabet.substring(key1) + alphabet.substring(0, key1);
            String lshiftedAlphabet = lowerAlphabet.substring(key1) + lowerAlphabet.substring(0, key1);
         // Write down the alphabet
            String lowerAlphabetTwo = alphabet.toLowerCase();
            // compute the shifted alphabet with key 2
            String shiftedAlphabetTwo = alphabet.substring(key2) + alphabet.substring(0, key2);
            String lshiftedAlphabetTwo = lowerAlphabet.substring(key2) + lowerAlphabet.substring(0, key2);
          
            char newChar = '-';
            
        for(int i = 0; i < encrypted.length(); i++ ){
            
            char currChar = encrypted.charAt(i);
            // find the index of currchar in the alphabet (call it idx)
            int idx = alphabet.indexOf(currChar);
            int lidx = lowerAlphabet.indexOf(currChar);
            
                if(i % 2 == 0){
                    // even numbers
                    // when uppercase
                    if (idx != -1 ){
                    // get the idx character of shifted alphabet (newChar)
                    newChar = shiftedAlphabet.charAt(idx);
                    // replace the ith character on encrypted with newChar
                    encrypted.setCharAt(i, newChar);
                    }
                    // when lowercase
                    if(lidx != -1){
                       newChar = lshiftedAlphabet.charAt(lidx);
                       encrypted.setCharAt(i,newChar);
                    }
                }else{
                    // odd numbers
                    // when uppercase
                    if (idx != -1 ){
                    // get the idx character of shifted alphabet (newChar)
                    newChar = shiftedAlphabetTwo.charAt(idx);
                    // replace the ith character on encrypted with newChar
                    encrypted.setCharAt(i, newChar);
                    }
                    // when lowercase
                    if(lidx != -1){
                    newChar = lshiftedAlphabetTwo.charAt(lidx);
                    encrypted.setCharAt(i,newChar);
                    }
                }
            
        }
            return encrypted.toString();
    }
    
    
    public void  testEncryptTwoKeys(){
        System.out.println(encryptTwoKeys("At noon be in the conference room with your hat on for a surprise party. YELL LOUD!", 8, 21));
    }
}
