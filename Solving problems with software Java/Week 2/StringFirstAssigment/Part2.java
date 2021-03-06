
/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.lang.Character;

public class Part2 {
    public String findSimpleGene(String dna, String startCodon, String stopCodon ){
        
	String result = "";
	String complete = "";
	int startIndex = dna.indexOf(startCodon);
	int stopIndex = dna.indexOf(stopCodon, startIndex + 3);
	if (startIndex == -1 || stopIndex == -1){
	    result =  "not found";
	   }
	   
	if ((startIndex - stopIndex) % 3 == 0){
	    complete = dna.substring(startIndex, stopIndex + 3);
	    result = complete;
	   	
	   }else{
	       result = "not found or malformed";
	   }
	   
	   if(isUpper(dna)){
	       result =  result.toUpperCase();
	   }else{
	       result =  result.toLowerCase();
	   }
	   return result;
     }
     
     public void testFindGeneSimple(){
	String dna = "AATGCGTAATATGGT";
	System.out.println("DNA strand is " + dna);
	String gene = findSimpleGene(dna,"ATG","TAA");
	System.out.println("Gene is " + gene);
	
	String dna1 = "AATGCGGTGCGGCTAATATGGT";
	System.out.println("DNA strand is " + dna1);
	String gene1 = findSimpleGene(dna1, "ATG","TAA");
	System.out.println("Gene is " + gene1);
	
	String dna2 = "aatgcgtaatatggt ";
	System.out.println("DNA strand is " + dna2);
	String gene2 = findSimpleGene(dna2, "ATG","TAA");
	System.out.println("Gene is " + gene2);
	
     }
     
     
     public static boolean isUpper(String s){
	        for(char c : s.toCharArray())
                {
                    if(!Character.isUpperCase(c))
                        return false;
                }
                return true;
	   }
}
