
/**
 * Write a description of encrypter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;
import java.lang.StringBuilder;
public class encrypter {
    
   public void testCaesar(){
            int key =  17;
            FileResource fr = new FileResource();
            String message = fr.asString();
            String encrypted = encrypt(message, key);
            System.out.println(encrypted);
            String decrypted = encrypt(encrypted, 26-key);
            System.out.println(decrypted);
   }
   
   public String encrypt (String input , int key) {
            // make a StringBuilder with message (encrypted)
            String lowerCaseInput = input.toLowerCase();
            StringBuilder encrypted = new StringBuilder (lowerCaseInput);
            
            // Write down the alphabet
            String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            alphabet = alphabet.toLowerCase();
            // compute the shifted alphabet
            String shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0, key);
            // count from 0 to  < length of encrupted, (call it i)
            for(int i = 0; i < encrypted.length(); i ++ ){
            // look at the ith character of encrypted  (call it currchar)
            char currChar = encrypted.charAt(i);
            // find the index of currchar in the alphabet (call it idx)
            int idx = alphabet.indexOf(currChar);
            // if currChar is in the alphabet
            if (idx != -1){
                
                // get the idx character of shifted alphabet (newChar)
                char newChar = shiftedAlphabet.charAt(idx);
                // replace the ith character on encrypted with newChar
                encrypted.setCharAt(i, newChar);
            }
              // Otherwise: do nothing
                
            }
        
          
            // Your answer is the String inside of encrypted
                return encrypted.toString();
   }
   
   
   
   public void testingKeys(){
    String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    
    String shiftedOne = alphabet.substring(17) + alphabet.substring(0, 17);
    
    String shiftedTwo = alphabet.substring(23) + alphabet.substring(0, 23);
    System.out.println("Normal alphafet      " + alphabet);
    System.out.println("Shifted  with key 17 " + shiftedOne );
    System.out.println("Shifted  with key 23 " + shiftedTwo );
    
   }
}
