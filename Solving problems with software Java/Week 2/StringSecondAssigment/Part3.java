
/**
 * Write a description of Part3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part3 {
    public static int countGenes (String dna){
        // Set startIndex to 0
        int startIndex = 0;
        int howMany = 0;
        // Repeat the following steps
        while (true){
            String currentGene = findGene(dna);
            if(currentGene.isEmpty() || startIndex == -1){
                break;
            }
            startIndex = dna.indexOf(currentGene, (startIndex + currentGene.length()));
            howMany += 1;
        }
        
        
        return howMany;
    
    }
    
    public static void testCountGenes (){
        System.out.println(countGenes ("ATGCCCGGGAAATAACCCATGCCCGGGAAATAABBBATGCCCGGGAAATAACCCATGXXXGGGAAATAG"));
    }
    
    public static int  findStopCodon(String dna, int startIndex, String stopCodon){
        int currIndex = dna.indexOf(stopCodon, startIndex + 3);
        while (currIndex != -1){
            if ((currIndex - startIndex) % 3 == 0){
                return currIndex;
            }else{
                currIndex = dna.indexOf(stopCodon, currIndex + 1);
            }
        }  
        return dna.length();
    }
    
    
    public static void testFindGene(){
        String dna = "ATGCCCGGGAAATAACCC";
        
        String gene = findGene(dna);
        System.out.println(gene);
        if(! gene.equals("ATGCCCGGGAAATAA")){
            System.out.println("error");
        }
        
        //            012345678901234
        String dn1 = "CCCGGGAAATAACCC";
        String gene1 = findGene(dn1);
        System.out.println(gene1);
        if(! gene1.equals("")){
            System.out.println("error");
        }
        
        System.out.println("tests finished");
    }
    
    
        
    public static void testFindStopCodon(){
        //                                012345678901234567890123456789012345678
        System.out.println(findStopCodon("zzzaaaTGAdhjkAaaERGTAxxxAGTzzzxxxATThhh", 0 , "GTA"));
    }
    
    public static String findGene(String dna){
        int startIndex = dna.indexOf("ATG");
        if(startIndex == -1){
            return "";
        }
        
        int taaFirstOcurrence = findStopCodon(dna, startIndex + 3, "TAA");
        int tagFirstOcurrence = findStopCodon(dna, startIndex + 3, "TAG");
        int tgaFirstOcurrence = findStopCodon(dna, startIndex + 3, "TGA");
        
        int minIndex = 0;
        if (taaFirstOcurrence == -1 || (tgaFirstOcurrence!= -1 && tgaFirstOcurrence <   taaFirstOcurrence)){
            minIndex = tgaFirstOcurrence;
        }else{
            minIndex = taaFirstOcurrence;
        }
        
        if (minIndex == -1 || (tagFirstOcurrence != -1 && tagFirstOcurrence< minIndex)){
            minIndex = tagFirstOcurrence;
        }
        
        return dna.substring(startIndex , minIndex + 3);
    }
        
    public static void testPrintAllGenes (){
        String dna = "ATGCCCGGGAAATAACCCATGCCCGGGAAATAABBBATGCCCGGGAAATAACCCATGXXXGGGAAATAG";
        printAllGenes(dna);
    }
    
    
    
     public static void printAllGenes(String dna){
        // Set startIndex to 0
        int startIndex = 0;
        // Repeat the following steps
        while (true){
            String currentGene = findGene(dna);
            if(currentGene.isEmpty() || startIndex == -1){
                break;
            }
            startIndex = dna.indexOf(currentGene, (startIndex + currentGene.length()));
            System.out.println(currentGene);
        }
    
    
        
    }
    
}
