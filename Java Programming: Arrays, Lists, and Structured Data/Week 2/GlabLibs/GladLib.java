
/**
 * Write a description of GladLib here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;
import java.util.*;

public class GladLib {
    private ArrayList<String> adjectiveList;
    private ArrayList<String> nounList;
    private ArrayList<String> colorList;
    private ArrayList<String> countryList;
    private ArrayList<String> nameList;
    private ArrayList<String> animalList;
    private ArrayList<String> timeList;
    private ArrayList<String> verbList;
    private ArrayList<String> fruitList;
    private Random myRandom;
    private ArrayList<String> wordsFound; 
    private int numberOfWordReplaced ;
    
    private String dataSourceURL = "http://dulelearntoprogram.edu.com/course3/data";
    private String dataSourceDirectory =  System.getProperty("user.dir");
    
    public GladLib(){
        initializeFromSource(dataSourceDirectory);
        myRandom = new Random();
    }
    
    public GladLib(String source){
         initializeFromSource(source);
         myRandom = new Random();
    }
    
    public void initializeFromSource(String source){
        adjectiveList = readIt("adjective.txt");
	nounList = readIt("noun.txt");
	colorList = readIt("color.txt");
	countryList = readIt("country.txt");
	nameList = readIt("name.txt");
	animalList = readIt("animal.txt");
	timeList = readIt("timeFrame.txt");
	verbList = readIt("verb.txt");
	fruitList = readIt("fruit.txt");
	wordsFound = new ArrayList<String>();
	numberOfWordReplaced = 0;
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
        numberOfWordReplaced += 1;
        return prefix+sub+suffix;
        
    }
    
    private String getSubstitute(String label){
	if(label.equals("country")){
		return randomFrom(countryList);
	}
	if(label.equals("adjective")){
	        return randomFrom(adjectiveList);
	}
        if(label.equals("color")){
        		return randomFrom(colorList);
        	}
        if(label.equals("noun")){
        		return randomFrom(nounList);
        	}
        if(label.equals("name")){
        		return randomFrom(nameList);
        	}
    	if (label.equals("number")){
		return ""+myRandom.nextInt(50)+5;
	}
        if(label.equals("verb")){
        	return randomFrom(verbList);
        }
        if(label.equals("animal")){
                return randomFrom(animalList);
        }
        if(label.equals("timeframe")){
                return randomFrom(timeList);
        }
        if(label.equals("fruit")){
                return randomFrom(fruitList);
        }
        
        return "**UNKNOWN**";
        
    }
    	public void makeStory(){
    	    
	    System.out.println("\n");
		String story = fromTemplate("madtemplate.txt");
		wordsFound.clear();
		printOut(story, 1);
		System.out.println("Number of words replaced are " + numberOfWordReplaced);
		
	}
 
   
}
