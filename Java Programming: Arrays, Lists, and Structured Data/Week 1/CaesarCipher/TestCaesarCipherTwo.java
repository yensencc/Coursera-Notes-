
/**
 * Write a description of TestCaesarCipherTwo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.FileResource;

public class TestCaesarCipherTwo {
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
    
    public void simpleTests(){
         // FileResource fr = new FileResource("smallHamlet.txt");
         // String s  =  fr.asString();
          String s = "Can you imagine life WITHOUT the internet AND computers in your pocket?";
          System.out.println("Original message is " + s);
          CaesarCipherTwo ccTwo = new CaesarCipherTwo(14, 24);
          String e_message = ccTwo.encrypt(s);
          System.out.println("Encrypted message  is " + e_message);
          String d_message = ccTwo.decrypt(e_message);
          System.out.println("Decrypted message is " + d_message);
          System.out.println("Testing the breakCaesarCipher method ");
          breakCaesarCipher(e_message);
    }
    
    public void breakCaesarCipher(String input){
        
        String descryptedString = "";
        String firstHalf = halfOfString(input, 0);
        String secHalf = halfOfString(input, 1);
        int ke1 = getKey(firstHalf);
        System.out.println("key1 = " + ke1);
        int ke2 = getKey(secHalf);
        System.out.println("key2 = " + ke2 );
        CaesarCipherTwo ccTwo = new CaesarCipherTwo(ke1,ke2);
        descryptedString = ccTwo.decrypt(input);
        System.out.println("Decripted message is " + descryptedString);
    }
}
