import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.StringTokenizer;

import utils.*;
import basics.*;

public class Main {
	public static void main(String[] args){
		
		RunwayParser runwayParser = new RunwayParser("resources/runways.csv");
		List<Runway> runwayList = runwayParser.getRunwayList();
		
		AirportParser airportParser = new AirportParser("resources/airports.csv");
		HashMap<String,Airport> airportMap  = airportParser.getAirportMap();
		
		CountryParser countryParser = new CountryParser("resources/countries.csv");
		HashMap<String,Country> countryMap = countryParser.getCountryMap();
		
		// store all runways to the airport they correspond to
		for (Runway r : runwayList){
			airportMap.get(r.getAirport_ident()).addRunway(r);
		}
		
		// store all airports to the country they belong to
		for (Entry<String, Airport> entry : airportMap.entrySet()){
			countryMap.get(entry.getValue().getIso_country()).addAirport(entry.getValue());
		}
		
		// create a maping between country names and country codes
		HashMap<String,String> countryNamesMap = new HashMap<String,String>();
		for (Entry<String,Country> e : countryMap.entrySet()){
			countryNamesMap.put( e.getValue().getName(), e.getKey());
		}
		
		
		System.out.println("Please insert a country code or country name. More than necessary spaces will be ignored :");
		Scanner sc = new Scanner( System.in);
		String country = sc.nextLine();
		StringTokenizer tmp = new StringTokenizer(country);
		
		StringBuffer sb = new StringBuffer();
		while ( tmp.hasMoreTokens()){
			sb.append(tmp.nextToken().trim()+' ');
		}

		System.out.println("You have inserted : "+sb.toString().trim());
		
		if (countryNamesMap.containsKey(sb.toString().trim())){
			countryMap.get(countryNamesMap.get(sb.toString().trim())).printAll();
		}
		else if ( countryMap.containsKey(sb.toString().trim())){
			countryMap.get(sb.toString().trim()).printAll();
		}
		else System.out.println("No matching found ! Please insert a correct country name / code .");
	}
}
