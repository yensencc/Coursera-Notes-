package VigenereProgram;

import edu.duke.*;

public class CaesarCracker {
    char mostCommon;
    
    public CaesarCracker() {
        mostCommon = 'e';
    }
    
    public CaesarCracker(char c) {
        mostCommon = c;
    }
    
    public int[] countLetters(String message){
        String alph = "abcdefghijklmnopqrstuvwxyz";
        int[] counts = new int[26];
        for(int k=0; k < message.length(); k++){
            int dex = alph.indexOf(Character.toLowerCase(message.charAt(k)));
            if (dex != -1){
                counts[dex] += 1;
            }
        }
        return counts;
    }
    
    public int maxIndex(int[] vals){
        int maxDex = 0;
        for(int k=0; k < vals.length; k++){
            if (vals[k] > vals[maxDex]){
                maxDex = k;
            }
        }
        return maxDex;
    }

    public int getKey(String encrypted){
        int[] freqs = countLetters(encrypted);
        int maxDex = maxIndex(freqs);
        int mostCommonPos = mostCommon - 'a';
        int dkey = maxDex - mostCommonPos;
        if (maxDex < mostCommonPos) {
            dkey = 26 - (mostCommonPos-maxDex);
        }
        return dkey;
    }
    
    public String decrypt(String encrypted){
        int key = getKey(encrypted);
        CaesarCipher cc = new CaesarCipher(key);
        return cc.decrypt(encrypted);
        
    }
    
    public void test(){
        CaesarCipher cc = new CaesarCipher(17);
        FileResource fr = new FileResource();
         String message = fr.asString();
        System.out.println("Encrypting message");
        // System.out.println(message);
        // System.out.println("////************////");
        // System.out.println("Encrypted message");
        // String e_message = cc.encrypt(message);
         System.out.println(message);
        // System.out.println("////************////");
        System.out.println("Dencrypted message");
        String d_message = cc.decrypt(message);
        System.out.println(d_message);
         // System.out.println("Decrypting already excrypted message");
         // System.out.println("////************////");
         
       
    }
   
}
