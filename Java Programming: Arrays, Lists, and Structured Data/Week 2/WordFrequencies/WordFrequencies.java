
/**
 * Write a description of WordFrequencies here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;
import java.util.ArrayList;

public class WordFrequencies {
    
    private ArrayList<String> myWords;
    private ArrayList<Integer> myFreqs;

    
    public WordFrequencies(){
      myWords = new ArrayList<String>();
      myFreqs = new ArrayList<Integer>();

    }

    public void findUnique(){
      myWords.clear();
      myFreqs.clear();
      FileResource resource = new FileResource("likeit.txt");
      for(String word : resource.words()){
        word = word.toLowerCase();
        int index = myWords.indexOf(word);
        if(index == -1){
            myWords.add(word);
            myFreqs.add(1);
        }else{
            int value = myFreqs.get(index);
            myFreqs.set(index, value + 1);
        }
      }

    }

    public void tester(){
      findUnique();
      // System.out.println("# unique words: " + myWords.size());
       for(int k=0 ; k < myWords.size(); k++){
           System.out.println(myFreqs.get(k) + "\t" +myWords.get(k));
       }
       System.out.println(" The most freq word is " + myWords.get(findIndexOfMax()) + " and it occurs " + myFreqs.get(findIndexOfMax())); 
    }

    public int findIndexOfMax (){
         int indexOfLargest = 0;
         int largestValue = myFreqs.get(0);
         
         // get largest value from myFreq
         for(int k = 0; k < myFreqs.size(); k ++){
            if(largestValue < myFreqs.get(k)){
               largestValue = myFreqs.get(k);
            }
            else{
                largestValue = largestValue;
            }
         
            }
           indexOfLargest = myFreqs.indexOf(largestValue);
         // then get index of largest value with
         // method indexOf(largestValue)
         return indexOfLargest;  
    }


}
