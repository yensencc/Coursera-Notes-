
/**
 * Write a description of CSVMax here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class CSVMax {
    public void testHottestInDay(){
        FileResource fr = new FileResource();
        CSVRecord largest = hottestHourInFile(fr.getCSVParser());
        System.out.println("hottest temperature was " + largest.get("TemperatureF") + " at " + largest.get("TimeEST"));
    }
    
    public void testHottestInManyDays(){
        CSVRecord largest = hottestInManyDays();
        System.out.println("hottest temperature was " + largest.get("TemperatureF") + " at " + largest.get("DateUTC"));
    }
    
    public CSVRecord hottestHourInFile(CSVParser parser){
    
    //Start with largestSoFar as nothing
        CSVRecord largestSoFar = null;
    //For each row(currentRow) in the CSV File
        for(CSVRecord currentRow : parser){
                //if largestSoFar is nothing
            if(largestSoFar == null){
                largestSoFar = currentRow;
            }else{
                double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
                double largestTemp = Double.parseDouble(largestSoFar.get("TemperatureF"));
                //update largestSoFar to be currentRow
                //otherwise
                //Check if currentRow's temperature > largestSoFar's\
                if(currentTemp > largestTemp){
                    //if so update largestSoFar to currentRow
                    largestSoFar = currentRow;
                }
                
            }
    
        }
    
    //The largestSofar is the answer
    return largestSoFar;
    
    }
    
    
    
    public CSVRecord coldestHourInFile (CSVParser parser){
        CSVRecord smallestSoFar = null;
        //For each row(currentRow) in the CSV File
        for(CSVRecord currentRow : parser){
                //if largestSoFar is nothing
            if(smallestSoFar == null){
                smallestSoFar = currentRow;
            }else{
                double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
                double smallestTemp = Double.parseDouble(smallestSoFar.get("TemperatureF"));
                //update largestSoFar to be currentRow
                //otherwise
                //Check if currentRow's temperature > largestSoFar's\
                if(currentTemp < smallestTemp && currentTemp != -9999){
                    //if so update largestSoFar to currentRow
                    smallestSoFar = currentRow;
                }
                
            }
    
        }
        
        return smallestSoFar;
    }
    
    public String fileWithColdestTemperature(){
        CSVRecord smallestSoFar = null;
        DirectoryResource dr = new DirectoryResource();
        String fileName = "";
        // iterate over files
        for(File f : dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            // use method to get largest in file.
            CSVRecord currentRow = coldestHourInFile(fr.getCSVParser());
            if(smallestSoFar == null){
                smallestSoFar = currentRow;
            }else{
                double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
            double smallestTemp = Double.parseDouble(smallestSoFar.get("TemperatureF"));
            //update largestSoFar to be currentRow
            //otherwise
            //Check if currentRow's temperature > largestSoFar's\
            if(currentTemp < smallestTemp){
                    //if so update largestSoFar to currentRow
                    smallestSoFar = currentRow;
                    fileName = f.toString();
                      }
            
                 }
        
        
        }
            
            return fileName;
    }
    
    public void testFileWithColdestTemperature(){
        String fileName = fileWithColdestTemperature();
        int startIndex = fileName.indexOf("data");
        fileName = fileName.substring(startIndex,fileName.length());     
        FileResource fr = new FileResource(fileName);
        CSVParser parser = fr.getCSVParser();
        CSVRecord ColdestTemperatureRecord  = coldestHourInFile(parser);
        System.out.println("File with coldest temperature is : " + fileName + " with a temperature of "  + ColdestTemperatureRecord.get("TemperatureF"));
        allTempsonFile(fileName);
    }
    
    public void testColdestHourInFile(){
        FileResource fr = new FileResource();
        CSVRecord smallest = coldestHourInFile(fr.getCSVParser());
        System.out.println("coldest temperature was " + smallest.get("TemperatureF") + " at " + smallest.get("DateUTC"));
    }
    
    
    public CSVRecord hottestInManyDays() {
        CSVRecord largestSoFar = null;
        DirectoryResource dr = new DirectoryResource();
        // iterate over files
        for(File f : dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            // use method to get largest in file.
            CSVRecord currentRow = hottestHourInFile(fr.getCSVParser());
            if(largestSoFar == null){
                largestSoFar = currentRow;
            }else{
                    double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
            double largestTemp = Double.parseDouble(largestSoFar.get("TemperatureF"));
            //update largestSoFar to be currentRow
            //otherwise
            //Check if currentRow's temperature > largestSoFar's\
            if(currentTemp > largestTemp){
                    //if so update largestSoFar to currentRow
                    largestSoFar = currentRow;
                      }
            
                 }
        
        
        }
            return largestSoFar;
    }
    
    public void allTempsonFile(String file){
        FileResource fr = new FileResource(file);
        CSVParser parser = fr.getCSVParser();
        System.out.println("All temps from the coldest day are : ");
        
        for(CSVRecord current : parser){
           System.out.println( current.get("DateUTC") +  " " +  current.get("TemperatureF"));
        }
        
        
        
    }
    
    public CSVRecord lowestHumidityInFile(CSVParser parser){
        CSVRecord smallestSoFar = null;
        //For each row(currentRow) in the CSV File
        for(CSVRecord currentRow : parser){
                //if largestSoFar is nothing
            if(smallestSoFar == null){
                smallestSoFar = currentRow;
            }else{
                
                String currentTempString = currentRow.get("Humidity");
                if(currentTempString.contains("N") == false){
                    double currentTemp = Double.parseDouble(currentRow.get("Humidity"));
                    double smallestTemp = Double.parseDouble(smallestSoFar.get("Humidity"));
                    //update largestSoFar to be currentRow
                    //otherwise
                    //Check if currentRow's temperature > largestSoFar's\
                    if(currentTemp < smallestTemp && currentTemp != -9999){
                        //if so update largestSoFar to currentRow
                        smallestSoFar = currentRow;
                    }
                    
                }
            }
    
        }
        
        return smallestSoFar;
        
    }
    
    public void testLowestHumidityInFile(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        CSVRecord csvR = lowestHumidityInFile(parser);
        System.out.println("Lowest Huminity was " + csvR.get("Humidity") + " at " + csvR.get("DateUTC"));
    }
    
    
    public CSVRecord lowestHumidityInManyFiles(){
        CSVRecord smallestSoFar = null;
        DirectoryResource dr = new DirectoryResource();
        // iterate over files
        for(File f : dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            // use method to get largest in file.
            CSVRecord currentRow = lowestHumidityInFile(fr.getCSVParser());
            if(smallestSoFar == null){
                smallestSoFar = currentRow;
            }else{
            double currentTemp = Double.parseDouble(currentRow.get("Humidity"));
            double smallestTemp = Double.parseDouble(smallestSoFar.get("Humidity"));
            //update largestSoFar to be currentRow
            //otherwise
            //Check if currentRow's temperature > largestSoFar's\
            if(currentTemp < smallestTemp){
                    //if so update largestSoFar to currentRow
                    smallestSoFar = currentRow;
                      }
            
                 }
        
        
        }
            return smallestSoFar;
    
    }
    public double averageTemperatureInFile(CSVParser parser){
        double average = 0;
        double sum = 0;
        int numberOfRecords = 0;
        CSVRecord tempRecord = null;
        for(CSVRecord currentRecord : parser){
            String currentString = currentRecord.get("TemperatureF");
            if(!currentString.contains("N")){
                numberOfRecords += 1;
                sum = sum + Double.parseDouble(currentRecord.get("TemperatureF"));
            }
            
        }
        average = sum / numberOfRecords;
        return average;
    }
    
    public void testLowestHumidityInManyFiles(){
        CSVRecord lowestHuminityRecord = lowestHumidityInManyFiles();
        System.out.println("Lowest Huminity was " + lowestHuminityRecord.get("Humidity") + " at " + lowestHuminityRecord.get("DateUTC"));
    }
    
    public void testAverageTemperatureInFile(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        double average = averageTemperatureInFile(parser);
        System.out.println("Average temperature in file is " + average);
    }

     public double averageTemperatureWithHighHumidityInFile(CSVParser parser , int value){
        double averageTemperature = 0;
        double sum = 0;
        int numberOfRecords = 0;
        for(CSVRecord currentRecord : parser){
            String currentString = currentRecord.get("Humidity");
            double currentHumi = Double.parseDouble(currentRecord.get("Humidity"));
            if(currentString  != "N/A" && currentHumi >= value){
               numberOfRecords += 1;
               sum = sum + Double.parseDouble(currentRecord.get("TemperatureF"));
            }
            
        }
        averageTemperature = sum / numberOfRecords;
        if(numberOfRecords < 1){
            return 0;
        }else{
            return averageTemperature;
        }
        
     }
     
     public void testAverageTemperatureWithHighHumidityInFile() {
            FileResource fr = new FileResource();
            CSVParser parser = fr.getCSVParser();
            double result = averageTemperatureWithHighHumidityInFile(parser ,80);
            if(result < 1){
                 System.out.println("No temperatures with that humidity");
            }else{
                 System.out.println("Average temp when high Huminity is " + result);
            }
            
         
     }
     
     public void getLowestValue(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        CSVRecord smallestSoFar = null;
        //For each row(currentRow) in the CSV File
        for(CSVRecord currentRow : parser){
                //if largestSoFar is nothing
            if(smallestSoFar == null){
                smallestSoFar = currentRow;
            }else{
                double currentTemp = Double.parseDouble(currentRow.get("Value"));
                double smallestTemp = Double.parseDouble(smallestSoFar.get("Value"));
                //update largestSoFar to be currentRow
                //otherwise
                //Check if currentRow's temperature > largestSoFar's\
                if(currentTemp < smallestTemp && currentTemp != -9999){
                    //if so update largestSoFar to currentRow
                    smallestSoFar = currentRow;
                }
                
            }
    
        }
        
        System.out.println(smallestSoFar.get("Value"));
        
     }
      
}



