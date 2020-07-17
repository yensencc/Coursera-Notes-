
/**
 * Write a description of TestCaesarCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.FileResource;

public class TestCaesarCipher {
    
    
    
    public int maxIndex(int[] vals){
    int maxDex = 0;
        
     for(int k=0 ; k < vals.length; k++){
         if(vals[k] > vals[maxDex]){
            maxDex = k;
            }
     }
     
     return maxDex;
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
    
    
    public void simpleTests(){
        FileResource fr = new FileResource ();
        String message = fr.asString();
        System.out.println("Original message is :" + message);
        CaesarCipher cc = new CaesarCipher(18);
        String e_message = cc.encrypt(message);
        System.out.println("Encrypted is :" + e_message);
        
        String d_message = cc.decrypt(e_message);
        
        System.out.println("Decrypted is :" + d_message);
        
        
        System.out.println("\n");
        
        System.out.println("Testing the brakCaesarCipher");
        breakCaesarCipher(e_message);
        
        
    }
    
    public void breakCaesarCipher(String input){
        int[] freqs = countLetters(input);
        int maxDex = maxIndex(freqs);
        int dkey = 0;
        if(maxDex < 4){
            dkey = 26 - ( 4 - maxDex );
        }else{
            dkey = maxDex - 4;
        }
 
        CaesarCipher cc = new CaesarCipher(dkey);
        // prints decrypted message
        System.out.println(cc.decrypt(input));
        
    }
}
