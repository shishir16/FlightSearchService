package org.dummy.flightsearch.spring.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.dummy.flightsearch.spring.model.Flight;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


@Component
public class FlightDao {
	
private static List<Flight> flights = new ArrayList<Flight>();

@PostConstruct
private void init(){
	
		try {
			ObjectMapper mapper = new ObjectMapper();

			TypeReference<List<Flight>> typeReference = new TypeReference<List<Flight>>() {
			};

			//InputStream inputStream = new FileInputStream("src/main/resources/flight-docs/flight-sample.json");
			//InputStream inputStream = new FileInputStream("flight-docs/flight-sample.json");
			InputStream inputStream = getClass()
					.getClassLoader().getResourceAsStream("flight-docs/flight-sample.json");
			flights = mapper.readValue(inputStream, typeReference);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
}


public List<Flight> get() {
	return flights;
}


public static List<Flight> get(String flightNumber ) {
	List<Flight> result = new ArrayList<Flight>();
	for(Flight f: flights){
			if (f.getFlightNumber().equalsIgnoreCase(flightNumber))
				result.add(f);
	}
	return result;
}

public static List<Flight> get(String flightNumber, Date dt ) {
	Calendar cal1 = Calendar.getInstance();
	Calendar cal2 = Calendar.getInstance();
	cal1.setTime(dt);
	
	List<Flight> result = new ArrayList<Flight>();
	for(Flight f: flights){
		cal2.setTime(f.getDeparture());
			if (f.getFlightNumber().equalsIgnoreCase(flightNumber)
					&& cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR)
					&& cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR))
				result.add(f);
	}
	return result;
}

public static List<Flight> get(String origin,String destination, Date dt ) {
	Calendar cal1 = Calendar.getInstance();
	Calendar cal2 = Calendar.getInstance();
	cal1.setTime(dt);
	
	List<Flight> result = new ArrayList<Flight>();
	for(Flight f: flights){
		cal2.setTime(f.getDeparture());
			if (f.getOrigin().equalsIgnoreCase(origin) && f.getDestination().equalsIgnoreCase(destination)
					&& cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR)
					&& cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR))
				result.add(f);
	}
	return result;
 }




}
