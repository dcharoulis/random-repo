package utils;

import au.com.bytecode.opencsv.CSVReader;
import basics.Country;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class CountryParser {

	/**
	 * Property used in order to map the country code with the corresponding Country object
	 */
	private HashMap<String,Country> countryMap ;
	
	/**
	 * Public constructor of CountryParser object. Reads a filename passed as a parameter and fills the countryMap property with the 
	 * mapping information between country codes and Country objects
	 * @param filename The name of the file to read from
	 */
	public CountryParser(String filename){
		try {
			 countryMap  = new HashMap<String,Country>();
			 CSVReader reader = new CSVReader(new FileReader(filename), ',');
			 String[] countryRecord=null;
			 reader.readNext();
			 while ((countryRecord = reader.readNext()) != null){
				Country country = new Country();
				country.setId(Integer.parseInt(countryRecord[0]));
				country.setCode(countryRecord[1]);
				country.setName(countryRecord[2]);
				country.setContinent(countryRecord[3]);
				country.setKeywords(countryRecord[5]);
				country.setWikipedia_link(countryRecord[4]);
				//countryMap.put(country.getCode(), new Country(country));
				countryMap.put(country.getCode(),country);
			}
			

			reader.close();
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Returns the HashMap property
	 * @return
	 */
	public HashMap<String,Country> getCountryMap(){
		return this.countryMap;
	}
}
