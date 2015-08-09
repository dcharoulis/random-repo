package utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;
import basics.Airport;
import basics.Country;

public class AirportParser {
	
	/**
	 * Property used in order to map an airport id with the corresponding Airport object.
	 */
	HashMap<String,Airport> airportMap;
	
	/**
	 * Public constructor of an AirportParser object. Reads a .csv file with airport information and fills the airportMap with the mapping 
	 * information. 
	 * @param filename The path to the file to read from.
	 */
	public AirportParser ( String filename){
		try {
			airportMap= new HashMap<String,Airport>();
			CSVReader reader = new CSVReader(new FileReader(filename), ',');
			String[] airportRecord=null;
			reader.readNext();
			while ((airportRecord = reader.readNext()) != null){
				Airport airport = new Airport();
				airport.setId( Integer.parseInt(airportRecord[0]));
				airport.setIdent(airportRecord[1]);
				airport.setType(airportRecord[2]);
				airport.setName(airportRecord[3]);
				airport.setIso_country(airportRecord[8]);
				airportMap.put(airport.getIdent(), airport);
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
	 * Returns the airportMap property
	 * @return
	 */
	public HashMap<String,Airport> getAirportMap(){
		return this.airportMap;
	}

}
