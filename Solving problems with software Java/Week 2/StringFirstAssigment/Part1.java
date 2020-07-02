
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part1 {

    public String findSimpleGene(String dna){
	String result = "";
	String complete = "";
	int startIndex = dna.indexOf("ATG");
	int stopIndex = dna.indexOf("TAA", startIndex + 3);
	if (startIndex == -1 || stopIndex == -1){
	    result =  "Gene not found";
	   }
	   
	if ((startIndex - stopIndex) % 3 == 0){
	    complete = dna.substring(startIndex, stopIndex + 3);
	    result = complete;
	   	
	   }else{
	       result = "Gene not found or malformed";
	   }
	   return result;
     }
     
     public void testFindGeneSimple(){
	String dna = "AATGCGTAATATGGT";
	System.out.println("DNA strand is " + dna);
	String gene = findSimpleGene(dna);
	System.out.println("Gene is " + gene);
	
	String dna1 = "AATGCGGTGCGGCTAATATGGT";
	System.out.println("DNA strand is " + dna1);
	String gene1 = findSimpleGene(dna1);
	System.out.println("Gene is " + gene1);
     }

}
