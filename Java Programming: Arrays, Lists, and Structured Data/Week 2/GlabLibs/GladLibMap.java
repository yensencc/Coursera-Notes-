
/**
 * Write a description of GladLib here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;
import java.util.*;

public class GladLibMap {
    HashMap <String, ArrayList<String>> myMap;
    private Random myRandom;
    private ArrayList<String> wordsFound; 
    private int numberOfWordReplaced  ;
    
    private String dataSourceURL = "http://dulelearntoprogram.edu.com/course3/data";
    private String dataSourceDirectory =  System.getProperty("user.dir");
    
    public GladLibMap(){
        myMap = new HashMap<String,ArrayList<String>>(); 
        initializeFromSource(dataSourceDirectory);
        myRandom = new Random();
        numberOfWordReplaced = 0;
       
    }
    
    public GladLibMap(String source){
         myMap = new HashMap<String,ArrayList<String>>(); 
         initializeFromSource(source);
         myRandom = new Random();
         numberOfWordReplaced = 0;
    }
    
    public void initializeFromSource(String source){
         wordsFound = new  ArrayList<String>();
     String[] labels = {"adjective", "noun", "color", "country", "name", "animal", "timeframe", "verb", "fruit"};
     for(String label : labels){
         ArrayList<String> categories =  readIt(label + ".txt");
         myMap.put(label, categories);
     }
     
     
    }
    private void printOut(String s, int lineWidth){
        int charsWritten = 0;
        for(String w : s.split("\\s+")){
            if(charsWritten + w.length() > lineWidth){
                System.out.println();
                charsWritten = 0;
            }
            System.out.println(w+" ");
            charsWritten += w.length() + 1;
        }
    }
    private String fromTemplate(String source){
        String story = "";
        if(source.startsWith("http")){
            URLResource resource = new URLResource(source);
            for(String word : resource.words()){
                story = story + processWord(word) + " ";
                
            }
        }else{
            FileResource resource = new FileResource(source);
            for(String word : resource.words()){
                story = story + processWord(word) + " ";
            }
        }
        
        return story;
    }
    
    private ArrayList<String> readIt(String source){
        ArrayList<String> list = new ArrayList<String>();
        if(source.startsWith("http")){
            URLResource resource = new URLResource(source);
            for(String line :resource.lines()){
                list.add(line);
            }
        }else{
            FileResource resource = new FileResource(source);
            for(String line : resource.lines()){
                list.add(line);
                
            }
        }
        return list;
    }
    private String randomFrom(ArrayList<String> source){
        int index = myRandom.nextInt(source.size());
        return source.get(index);
    }
    
    private String processWord(String w){
        
        int first = w.indexOf("<");
        int last = w.indexOf(">",first);
        if (first == -1 || last == -1){
            return w;
        }
        
        String prefix = w.substring(0,first);
        String suffix = w.substring(last+1);
        String sub = getSubstitute(w.substring(first+1,last));
        
        if(wordsFound.indexOf(sub) == -1){
            wordsFound.add(sub);
            
            
        }else{
            sub = getSubstitute(w.substring(first+1,last));
            
        }
        
        return prefix+sub+suffix;
        
    }
    
    private String getSubstitute(String label){
            if (label.equals("number")){
                numberOfWordReplaced += 1;
            return "" + myRandom.nextInt(50) + 5;
        }else if(!label.equals("number")){
            numberOfWordReplaced += 1;
         return randomFrom(myMap.get(label)); 
        }
       
         return "**UNKNOWN**";
    }
    
    
        
        public int totalWordsInMap(){
        int totalInMap =0;
        for(String file : myMap.keySet()  ){
            int amount = myMap.get(file).size();
            totalInMap = totalInMap + amount;
        }
        
        return totalInMap;
        
        }
        
        public int totalWordsConsidered (){
        makeStory();
        return numberOfWordReplaced;
        
        }
        public void makeStory(){
            
        System.out.println("\n");
        String story = fromTemplate("madtemplate.txt");
        wordsFound.clear();
        printOut(story, 1);
        System.out.println("Number of words replaced are " + numberOfWordReplaced);
        
    }
 
   
}
