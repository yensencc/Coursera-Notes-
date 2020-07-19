
/**
 *   Write a program to determine the characters in one of Shakespeare’s plays that have the most speaking parts
 */
import java.util.*;
import edu.duke.*;

public class CharactersInPlay {
    //You will need to create two private ArrayLists. One to store the the names of the characters you find and one to store the corresponding counts for each character.
    private ArrayList<String> names = new ArrayList<String>() ;
    private ArrayList<Integer> counts = new ArrayList<Integer>();
    
    public void update(String person){
      
        // this method should update the arraylists adding the character’s name if it is not already there, and counting this line as one speaking part for this person.
                int indexOfWordIfExist = names.indexOf(person);
                if(indexOfWordIfExist == -1 ){
                    names.add(person);
                    counts.add(1);
                }
                else{
                    int value = counts.get(indexOfWordIfExist);
                    counts.set(indexOfWordIfExist, value + 1);
                }
    }
    
    
    public void findAllCharacters(){
        names.clear();
         counts.clear();
        // opens a file, and reads the file line-by-line. For each line, if there is a period on the line, extract the possible name of the speaking part, and call update to count it as an occurrence for this person. Make sure you clear the appropriate instance variables before each new file.
        FileResource resource = new FileResource("likeit.txt");
        String currName = " ";
        for(String line : resource.lines()){
            int index = line.indexOf(".");
            if(index != -1){
                 currName = line.substring(0,index);
                update(currName);
            }else{
            
            }
        }
        
    }
    
    public void tester(){
         // This method should call findAllCharacters, and then for each main character, print out the main character, followed by the number of speaking parts that character has. A main character is one who has more speaking parts than most people. You’ll have to estimate what that number should be. Test your method on the file macbethSmall.txt. and then macbeth.txt.
        System.out.println("Finding all parts");
        findAllCharacters();
        
        for(int k=0 ; k < names.size(); k++){
           System.out.println(counts.get(k) + "\t" +names.get(k));
       }
       // System.out.println("Finding characters with number of parts greater or equal to a number");
       // charactersWithNumParts(2, 4);
    }
    
    public void charactersWithNumParts(int num1, int num2){
       for(int k=0 ; k < names.size(); k++){
           if(counts.get(k) >= num1 && counts.get(k) <= num2){
               System.out.println(counts.get(k) + "\t" +names.get(k));
            }
           
       }
        
        // This method should print out the names of all those characters that have exactly number speaking parts, where number is greater than or equal to num1 and less than or equal to num2. Add code in tester to test this method out.
    }
    
    
}
