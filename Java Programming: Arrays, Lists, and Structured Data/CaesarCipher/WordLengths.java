
/**
 * Write a description of WordLengths here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.FileResource;
public class WordLengths {
    public void countWordLengths(FileResource resource,  int [] counts ){
        
        String[] words = new String[counts.length];
	 int index = 0;
         for(String s : resource.words()){
	  words[index] = s;
	  index += 1;
	 }
       
       for(int i = 0; i < words.length; i ++ ){
           String currentWord = words[i];
           if(currentWord != null && !currentWord.isEmpty()){
               int wordLength = getActualLength(words[i]);
               counts[wordLength] += 1;
            }
           
          
            
        }
       
        // print words lenghs that are greater than 0
        for(int k = 0; k < counts.length; k ++ ){
            if(counts[k] != 0){
                System.out.println( (counts[k] ) + " words of length "  +  k);
            }
           
        }
       

    }
    
    public int getActualLength(String currentWord){
        int actualLength = 0;
     for(int k = 0; k < currentWord.length() ; k++){
               char currentChar = currentWord.charAt(k);
               
               if(Character.isLetter(currentChar) || currentChar == '\''){
                   actualLength += 1;
                }
               
            }
            
         return actualLength;   
    }
    
    public void testCountWordLengths(){
        
         FileResource resource = new FileResource("lotsOfWords.txt");
         int numberOfWords = 0;
          for (String s : resource.words()) {
               numberOfWords += 1;
          }
         int[] counts = new int[numberOfWords];
         countWordLengths(resource, counts);
    }
    
    // public boolean testIsLetter(){
        // char simbol = '\"';
        // if(Character.isLetter(simbol)){
            // return true;
        // }
        // return false;
    // }



}



