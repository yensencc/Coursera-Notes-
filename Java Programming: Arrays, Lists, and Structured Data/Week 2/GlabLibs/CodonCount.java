
/**
 * Write a description of CodonCount here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
import java.lang.*;
import java.util.List;
import edu.duke.*;


public class CodonCount {
    
    private HashMap<String, Integer> builtCodons ;
   
    public CodonCount(){
    builtCodons = new HashMap<String, Integer>();
    }

    public void buildCodonMap( int start, String dna){
        
    String DNA =  dna;
    
    
    builtCodons.clear();
    
    for(int i = start; i < DNA.length(); i+= 3){ // CGTTCAAGTTCAA
        if((i + 2) < DNA.length()){
            String codon = DNA.substring(i, i + 3);
        if(!builtCodons.containsKey(codon)){
            builtCodons.put(codon,1);
        }
        else{
          builtCodons.put(codon,builtCodons.get(codon) + 1);
        }
        }
        
}
        
      
   
    
    
    
 }
   

 public void printCodonCounts(int start, int end){
    for(String item : builtCodons.keySet()){
         if(builtCodons.get(item) >= start && builtCodons.get(item) <= end){
            System.out.println(item);
           }
    }
   
    System.out.println();
 }

  public String getMostCommonCodon(){
       int largest = 0;
       String largestItem = "";
       int currentValue = 0;
       for(String item : builtCodons.keySet()){
           currentValue = builtCodons.get(item);
           String currentItem = item;
           if(currentValue > largest){
               largest = currentValue;
               largestItem = item;
            }
       }
          
       return largestItem;
    }
    
    
    public void tester (){
        FileResource ressource = new FileResource();
        String DNA = ressource.asString();
        DNA = DNA.toUpperCase();
        DNA = DNA.trim();
    for(int i = 0 ;  i < 3 ; i++){

        buildCodonMap(i, DNA);
        System.out.println("Reading frame starting with " + i  + " results in " 
        + builtCodons.size() + " unique codons");
        System.out.println(" and the most common codon is " 
        + getMostCommonCodon() + " with count " +  builtCodons.get(getMostCommonCodon()));
        System.out.println("Counts of codons between 6 and 6 inclusive are: " );
        printCodonCounts(6,6);
      
    }
    
}

}



