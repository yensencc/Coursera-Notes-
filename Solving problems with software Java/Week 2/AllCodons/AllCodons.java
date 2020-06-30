
/**
 * Write a description of AllCodons here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AllCodons {
    
    public int findStopCodon(String dnaStr, int startIndex, String stopCodon){
        int currIndex = dnaStr.indexOf(stopCodon, startIndex + 3);
        while (currIndex != -1){

            if ((currIndex - startIndex) % 3 == 0){
                return currIndex;
            }else{
                currIndex = dnaStr.indexOf(stopCodon, currIndex + 1);
            }
            
        }
            
        return -1;
            
    }
    
    
    public void testFindStop(){
        //            01234567890123456789012345
        String dna = "xxxyyyzzzTAAxxxyyyzzzTAAxx";
        int dex = findStopCodon(dna,0,"TAA");
        if (dex != 9 )System.out.println("error on 9");
        dex = findStopCodon(dna,9,"TAA");
        if (dex != 21)System.out.println("error on 21");
        dex = findStopCodon(dna,1,"TAA");
        if(dex != -1)System.out.println("error on 26");
        dex = findStopCodon(dna,0,"TAG");
        if(dex != -1 ) System.out.println("error on 26 TAG");
        System.out.println("text finished");
        
    }
    
    public void testFindGene(){
        String dna = "ATGCCCGGGAAATAACCC";
        String gene = findGene(dna, 0);
        if(! gene.equals("ATGCCCGGAAATAA")){
            System.out.println("error");
        }
        System.out.println("tests finished");
    }
    
    public String findGene(String dna, int where){
        // find first occurrence of "ATG", startIndex
        int startIndex = dna.indexOf("ATG", where);
        if(startIndex == -1){
            return"";
        }
        int taaIndex = findStopCodon(dna,startIndex,"TAA");
        int tagIndex = findStopCodon(dna,startIndex, "TAG");
        int tgaIndex = findStopCodon(dna,startIndex, "TGA");
        // int temp = Math.min(taaIndex, tagIndex);
        // int minIndex = Math.min(temp, tgaIndex);
        
        int minIndex = 0;
        if (taaIndex == -1 || (tgaIndex != -1 && tgaIndex < taaIndex)){
            minIndex = tgaIndex;
        }else{
            minIndex = taaIndex;
        }
        
        if (minIndex == -1 || (tagIndex != -1 && tagIndex < minIndex)){
            minIndex = tagIndex;
        }
        
        return dna.substring(startIndex, minIndex + 3);
    
    }
    
    public void printAllGenes(String dna){
        // Set startIndex to 0
        int startIndex = 0;
        // Repeat the following steps
        while (true){
            String currentGene = findGene(dna, startIndex);
            if(currentGene.isEmpty()){
                break;
            }
            
            System.out.println(currentGene);
            startIndex = dna.indexOf(currentGene, startIndex) + currentGene.length();
        }
            // find the next gene after startIndex
            
            // if not gene was found, leave this loop
            
            // print that gene out
            
            // Set startIndex to just past the end of the gene
    }
    
    public void testOn(String dna){
        System.out.println("Testing printAllGenes on " + dna);
        printAllGenes(dna);
    }
    
    public void test(){
        testOn("ATGATCTAATTTATGCTGCAACGGTGAAGA");
        testOn("");
    }

}
