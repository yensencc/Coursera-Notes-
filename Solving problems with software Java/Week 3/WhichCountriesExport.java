
/**
 * Write a description of WhichCountriesExport here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;
import org.apache.commons.csv.*;
   
   
public class WhichCountriesExport {
   // Which Contries Export...? Translating to code
   


public void listExporters(CSVParser parser, String exportOfInterest){
	
	//For each row in the CSV file
	for(CSVRecord record : parser){
		//Look at the "Exports" column of that row
		String export = record.get("Exports");
		//Check if it contains exportOfInterest
		if(export.contains(exportOfInterest)){
			
		
		//if so, write down the "Country" from that row
		String country = record.get("Country");
		System.out.println(country);
		}
	}
	
}

public void countryInfo(CSVParser parser, String country){
    String count = "";
    String value = "";
    // for each country column
    for(CSVRecord record : parser){
        count = record.get("Country");
        // look for coloumn country to check if it contains the country searched.
        // if it does then
        if(count.contains(country)){
            value = record.get("Value (dollars)");
            // return  country, followed by “: “, followed by a list of the countries’ exports, followed by “: “, followed by the countries export value
            System.out.println(country + ": " + record.get("Exports") + ": " + value);
        }
    }
    // if contry does not exit
    if (value.length() < 1){
        // returns “NOT FOUND
        System.out.println("NOT FOUND");
    }
    
    
    
    
    
    
    
}

public void  listExportersTwoProducts(CSVParser parser, String exportItem1, String exportItem2){
    //For each row in the CSV file
	for(CSVRecord record : parser){
		//Look at the "Exports" column of that row
		String export = record.get("Exports");
		//Check if it contains exportItem1 and exportItem2
		if(export.contains(exportItem1) && export.contains(exportItem2) ){
		//if so, write down the "Country" from that row
		String country = record.get("Country");
		System.out.println(country);
		}
	}
}

public void whoExportsCoffee(){
	FileResource fr = new FileResource();
	CSVParser parser = fr.getCSVParser();
	//listExporters(parser, "coffee");
	//countryInfo( parser, "Malawi");
	//listExportersTwoProducts(parser, "cotton", "coffee" );
	//numberOfExporters(parser, "coffee");
	bigExporters(parser, "$999,999,999");
}

public void numberOfExporters(CSVParser parser, String exportItem){
    //returns the number of countries that export exportItem
    int numOfCountries = 0;
    for(CSVRecord record : parser){
		//Look at the "Exports" column of that row
		String export = record.get("Exports");
		//Check if it contains exportItem1 and exportItem2
		if(export.contains(exportItem)  ){
		//if so then add 1 more country that export item1
		 numOfCountries += 1;
		}
	}
	System.out.println(numOfCountries);
	
}

public void  bigExporters(CSVParser parser, String amount){
        String value = "";
        String country = "";
        for(CSVRecord record : parser){
		//Look at the "Value dollar" column of that row
		value = record.get("Value (dollars)");
		//Look at the "Country" column of that row
		country = record.get("Country");
		//Check if it contains exportItem1 and exportItem2
		if(value.length() > amount.length()  ){
		//if so then print country followed by the value
		System.out.println(country + " " + value);
		}
	}
	
}

}
