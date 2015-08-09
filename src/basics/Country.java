package basics;

import java.util.HashSet;
import java.util.Set;

public class Country {
	
	private int id;
	private String code;	
	private String name;	
	private String continent;	
	private String wikipedia_link;	
	private String keywords;
	
	private Set<Airport> airportSet;
	
	public Country(int id, String code, String name, String continent,
			String wikipedia_link, String keywords) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.continent = continent;
		this.wikipedia_link = wikipedia_link;
		this.keywords = keywords;
		
		 airportSet=new HashSet<Airport>();
	}
	
//	public Country( Country c){
//		super();
//		this.id = c.getId();
//		this.code = new String(c.getCode());
//		this.name = new String(c.getName());
//		this.continent = new String(c.getContinent());
//		this.wikipedia_link = new String(c.getWikipedia_link());
//		this.keywords = new String(c.getKeywords());
//	}
	
	public Country() {
		super();
		airportSet=new HashSet<Airport>();
	}



	public void addAirport (Airport newAirport){
		this.airportSet.add(newAirport);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContinent() {
		return continent;
	}
	public void setContinent(String continent) {
		this.continent = continent;
	}
	public String getWikipedia_link() {
		return wikipedia_link;
	}
	public void setWikipedia_link(String wikipedia_link) {
		this.wikipedia_link = wikipedia_link;
	}
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public void printAll(){
		for (Airport a : airportSet){
			a.printRunways();
			System.out.println("-------------------------------------------");
		}
	}
}
