package utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;
import basics.Runway;

public class RunwayParser {

	/**
	 * Property used in order to store all the runways existing in the file parsed
	 */
	List<Runway> runwayList ;
	
	/**
	 * Public constructor of RunwayParser object. Reads a file containing information of runways and stores them in a List.
	 * @param filename The path to the file that will be read
	 */
	public RunwayParser(String filename){
		try {
			runwayList = new ArrayList<Runway>();
			CSVReader reader = new CSVReader(new FileReader(filename), ',');
			String[] runwayRecord=null;
			reader.readNext();
			while ((runwayRecord = reader.readNext()) != null){
				Runway runway = new Runway();
				runway.setId(Integer.parseInt(runwayRecord[0]));
				runway.setAirport_ref(Integer.parseInt(runwayRecord[1]));
				runway.setAirport_ident(runwayRecord[2]);
				runwayList.add(runway);
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
	 * Returns the list of runways
	 * @return
	 */
	public List<Runway> getRunwayList(){
		return this.runwayList;
	}
}
