
/**
 * Write a description of WordPlay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WordPlay {
    public boolean isVowel (char ch){
        ch = Character.toLowerCase(ch);
        String vowels = "aeiou";
        int idx = vowels.indexOf(ch);
        if( idx != -1){
            return true;
        }
        return false;
        
    }
    
    public void testIsVowel(){
     char ef =  'i';
     System.out.println(isVowel(ef));
    }
    
    public void testReplaceVowels(){
        System.out.println(replaceVowels("Hello World", '*'));
    }
    
    public void testEmphasize(){
        System.out.println(emphasize("Mary Bella Abracadabra", 'a'));
    }
    
    
    
    
    public String replaceVowels (String phrase, char ch){
        StringBuilder newPhrase = new StringBuilder(phrase);
        for(int i = 0 ; i < phrase.length(); i ++){
            if(isVowel(newPhrase.charAt(i))){
                newPhrase.setCharAt(i, ch);
            }
        }
        return newPhrase.toString();
    }
    
    public String emphasize(String phrase, char ch){
        char even = '+';
        char odd = '*';
        StringBuilder emphazised = new StringBuilder(phrase);
        int idx = 0;
        for(int i = 0; i < emphazised.length(); i++ ){
            
            String charecter = Character.toString(ch);
            String emphazisedChar =  Character.toString(emphazised.charAt(i));
            if(emphazisedChar.equalsIgnoreCase(charecter)){
                if(i % 2 == 0){
                    emphazised.setCharAt(i, odd );
                }else{
                    emphazised.setCharAt(i,even );
                }
            }
        }
        return emphazised.toString();
    }
    
    
    
}
