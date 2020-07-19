
/**
 * Write a description of CaesarCipherTwo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CaesarCipherTwo {
    
    
        private String alphabet = "";
        private String lowerAlphabetTwo = "";
        private String lowerAlphabet = "";
        private String shiftedAlphabet = "";
        private String shiftedAlphabetTwo = "";
        private String lshiftedAlphabet = "";
        private String lshiftedAlphabetTwo = "";
        private  int key1 = 0;
        private int key2 = 0;
        
        
        
        // write constructor
        
        public CaesarCipherTwo(int ke1, int ke2){
            // Write down the alphabet
            alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            lowerAlphabet = alphabet.toLowerCase();
            // compute the shifted alphabet with key 1
            shiftedAlphabet = alphabet.substring(ke1) + alphabet.substring(0, ke1);
            lshiftedAlphabet = lowerAlphabet.substring(ke1) + lowerAlphabet.substring(0, ke1);
            // Write down the alphabet
            lowerAlphabetTwo = alphabet.toLowerCase();
            // compute the shifted alphabet with key 2
            shiftedAlphabetTwo = alphabet.substring(ke2) + alphabet.substring(0, ke2);
            lshiftedAlphabetTwo = lowerAlphabet.substring(ke2) + lowerAlphabet.substring(0, ke2);
            key1 = ke1;
            key2 = ke2;
            
        
        }
        
        
        
        public String encrypt(String input){
        StringBuilder encrypted = new StringBuilder(input);
        
            
        for(int i = 0; i < encrypted.length(); i++ ){
            char newChar = '-';
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
    
    
    public String decrypt(String encrypted){
        CaesarCipherTwo ccTwo = new CaesarCipherTwo(26-key1,26-key2);
        String descryptedString = "";
        String firstHalf = halfOfString(encrypted, 0);
        String secHalf = halfOfString(encrypted, 1);
        descryptedString = ccTwo.encrypt(encrypted);
        return descryptedString;
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
    
}
