
/**
 * Write a description of BabyBirths here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;
public class BabyBirths {
    public void printNames(){
        FileResource fr = new FileResource();
        for(CSVRecord rec : fr.getCSVParser(false)){
            int numBorn = Integer.parseInt(rec.get(2));
            if(numBorn <= 100){
                System.out.println("Name " + rec.get(0) + " Gender " + rec.get(1) + " Num Born " + rec.get(2));
            }
    
        }
    }
    
    public void totalBirths (FileResource fr){
        int totalBirths = 0;
        int totalBoys = 0;
        int totalGirls = 0;
        for(CSVRecord rec : fr.getCSVParser(false)){
                int numBorn = Integer.parseInt(rec.get(2));
                totalBirths += numBorn;
                if(rec.get(1).equals("M")){
                    totalBoys += numBorn;
                }else{
                    totalGirls += numBorn;
                }
        }
        System.out.println("total births = " + totalBirths);
        System.out.println("total girls = " + totalGirls );
        System.out.println("total boys = " + totalBoys );
    }
    
    public void testTotalBirths () {
        FileResource fr = new FileResource();
        totalBirths(fr);
    }
    
    public int getRank(int year, String name, String gender){
        int rank = 1;
        FileResource fr = new FileResource("us_babynames_by_year/yob" + year + ".csv");
        for(CSVRecord rec : fr.getCSVParser(false)){
            String nam = rec.get(0);
            String gen = rec.get(1);
            if(gen.equals(gender)){
               
                if(nam.equals(name)){
                    return rank;
                }
                else{
                    rank += 1;
                }
                
                
            }
            
        }
            
        return -1;
    }
    
    public String getName(int year, int rank, String gender){
        String name = "";
        int ranking = 0;
        FileResource fr = new FileResource("us_babynames_by_year/yob" + year + ".csv");
        for(CSVRecord rec : fr.getCSVParser(false)){
            String nam = rec.get(0);
            String gen = rec.get(1);
            if(gen.equals(gender)){
                if(gen.equals(gender)){
                    ranking += 1;
                    
                    if(ranking == rank){
                        return nam;
                    }
                    
                }
            }
           
        }
         return "NO NAME FOUND"; 
        
    }
    
    public void whatIsNameInYear(String name, int year, int newYear, String gender){
        //determine rank of name in year
        int nameRank = getRank(year , name , gender);
        System.out.println("Rank of " + name + " is " + nameRank );
        System.out.println("\n");
        // get name from with rank in the newYear
        String newName = getName(newYear, nameRank, gender);
        System.out.println("New name in year " + newYear + " is " + newName);
    }
    
    public int  yearOfHighestRank(String gender, String name){
       int currentYear = 0;
       String fileName = "";
       DirectoryResource dr = new DirectoryResource();
       int lowestValue = 0;
       int prevValue = 99;
       int Year = 0;
       int startRank = 0;
       
       for(File file : dr.selectedFiles()){
           FileResource fr = new FileResource(file);
           fileName  = file.getName();
           int startIndex = fileName.indexOf("b");
           fileName = fileName.substring(startIndex + 1, startIndex + 5);
           currentYear = Integer.parseInt(fileName);
           CSVParser fileParser = fr.getCSVParser(false);
           int normalRank =  getRank(currentYear, name, gender);
           int currRank = getRank(currentYear, name, gender);
           
        if (Year == 0){ 
            Year = currentYear;
            startRank = currRank;
        }
        
        if (currRank != -1) {
            if (currRank < startRank) {
                Year = currentYear;
                startRank = currRank;
            }
        }
         
           
           
           
        }
       
        return Year ;
    }
    
    public double getAverageRank(String name, String gender){
        double average = 0;
        String fileName = "";
        int currentYear = 0;
        int numberOfFiles = 0;
        int sumOfRanks = 0;
        DirectoryResource dr = new DirectoryResource();
        for(File file : dr.selectedFiles()){
            numberOfFiles += 1;
            FileResource fr = new FileResource(file);
           fileName  = file.getName();
           int startIndex = fileName.indexOf("b");
           fileName = fileName.substring(startIndex + 1, startIndex + 5);
           currentYear = Integer.parseInt(fileName);
           CSVParser fileParser = fr.getCSVParser(false);
           int normalRank =  getRank(currentYear, name, gender);
           sumOfRanks += normalRank;
        
        }
        
        average = sumOfRanks / numberOfFiles;
        
        return average;
    }
    
    // public int getTotalBirthsRankedHigher(int year, String name, String gender){
        // int totalNumberOfBirths = 0;
        // // get given name rank from year file.
        // int givenNameRank = getRank(year,name,gender);
      
         // // iterate over year file.
             // FileResource fr = new FileResource("us_babynames_by_year/yob" + year + ".csv");
             // CSVParser fileParser = fr.getCSVParser(false);
             
            // for(CSVRecord rec : fr.getCSVParser(false)){
                
                
                // if(rec.get(1).equals("M")){
                // String currentRecordName = rec.get(0);
                // int currentRank = getRank(year, currentRecordName, gender);
                // if(currentRank < givenNameRank){
                    // int numBorn = Integer.parseInt(rec.get(2));
                    // totalNumberOfBirths += numBorn;
                  // }
                // }
                   
            // }
            // return totalNumberOfBirths ; 
      // }
        
        
      
      private int getTotalBirthsRankedHigher(int year, String name, String gender){
        //total number of births of those names with the same gender and same year who 
        //are ranked higher than name
        //get FileName 
        String fileName = "us_babynames_by_year/yob"+year+".csv";
        FileResource excelFile = new FileResource(fileName);
        int rankOfName = getRank(year, name, gender);
        int tempRank = 0;
        int totalBirths = 0;
        CSVParser parser = excelFile.getCSVParser(false);
        for(CSVRecord currentRow: parser){
            if(currentRow.get(1).equals(gender)){
                tempRank+=1;
                if(tempRank < rankOfName){
                    totalBirths += Integer.parseInt(currentRow.get(2));
                }
            }   
        }
        
        return totalBirths;
    }
    
    
    
    public void testGetTotalBirthsRankedHigher(){
        // What is the total number of girls born in 1990 with names ranked higher than the girl's name "Emily" in 1990?
        System.out.println(getTotalBirthsRankedHigher(1990, "Emily", "F"));
    }
    public void testGetRank(){
        System.out.println(getRank(1971 , "Frank", "M"));
    }
    public void testGetName(){
        System.out.println(getName(1982, 450, "M"));
    }
    
    public void testWhatIsNameInYear(){
        whatIsNameInYear("Abi",2011, 2014, "F");
    }
    
    public void testYearOfHighestRank(){

        System.out.println(yearOfHighestRank("M", "Mich"));
    }
    
    public void testGetAverageRank(){
        System.out.println(getAverageRank("Robert", "M"));
    }
}
