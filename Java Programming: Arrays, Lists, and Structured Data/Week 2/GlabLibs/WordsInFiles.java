
/**
 * Write a description of WordsInFiles here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;
import java.io.*;
import java.util.*;
public class WordsInFiles {
    
    private HashMap <String, ArrayList<String>> numberOfFiles ;

    
    public WordsInFiles(){
        numberOfFiles = new  HashMap<String, ArrayList<String>>();
     
    }
    
    
    public void addWordsFromFile(File file){
         
         FileResource fr = new FileResource(file);
         String fileName = file.getName().toString();
         for(String word : fr.words()){
            if(!numberOfFiles.containsKey(word)){
                ArrayList<String> fileList = new ArrayList<String>();
                fileList.add(fileName);
                numberOfFiles.put(word, fileList);
            }else if(numberOfFiles.containsKey(word) && !numberOfFiles.get(word).contains(fileName)){
                ArrayList<String> currentList = numberOfFiles.get(word);
                currentList.add(fileName);
                numberOfFiles.put(word, currentList);
            }
            
            
         }
           
    
    }
    
     // private void addWordsFromFile(File file) {
        // FileResource fileResource = new FileResource(file);
        // String fileName = file.getName();
        // for (String word : fileResource.words()) {
            // if (!numberOfFiles.containsKey(word)) {
                // ArrayList<String> newList = new ArrayList<String>();
                // newList.add(fileName);
                // numberOfFiles.put(word, newList);
            // } else if (numberOfFiles.containsKey(word)
                    // && !numberOfFiles.get(word).contains(fileName)) {
                // ArrayList<String> currentList = numberOfFiles.get(word);
                // currentList.add(fileName);
                // numberOfFiles.put(word, currentList);
            // }
        // }
    // }
    
    public void buildWordFileMap(){
       numberOfFiles.clear();
       DirectoryResource dr = new DirectoryResource();
       for(File file : dr.selectedFiles()){
           addWordsFromFile(file);
        }
       
    
    }
    
    public int  maxNumber(){
        int maximumNumberOfFiles = 0;
        buildWordFileMap();     
        for(String word : numberOfFiles.keySet()){
            ArrayList<String> currentFiles = numberOfFiles.get(word);
            if (maximumNumberOfFiles < currentFiles.size()){
                maximumNumberOfFiles = currentFiles.size();
                 
            } 
           
        }
       
       return maximumNumberOfFiles;
        
    
    }
    
    public ArrayList<String> wordsInNumFiles (int number){
        ArrayList<String> wordsInNumFiles = new ArrayList<String>();
        for(String word: numberOfFiles.keySet()){
            if(numberOfFiles.get(word).size() ==  number){
                wordsInNumFiles.add(word);
            }
        }
        
        return wordsInNumFiles;
    }
  
    public void tester(){
         buildWordFileMap();
         int numOfFiles = 4;
         ArrayList<String> words = wordsInNumFiles(numOfFiles);
         
         for(String word : words){
            System.out.println(word);
         }
         
         
         String word = "red";
         System.out.println("Number of files where " + word);
         printFilesIn(word);  
         //System.out.println("Words that appear in more than " + numOfFiles + " files " + " is " + words.size());
         
    }
    
    
    public void  printFilesIn(String word){
      for(String w : numberOfFiles.keySet()){
          if(word.equals(w)){
              for(String file : numberOfFiles.get(w)){
                  System.out.println(file);
                }
            }
        }
        
    
    }
}
