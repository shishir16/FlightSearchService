package org.dummy.flightsearch.spring.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.dummy.flightsearch.spring.dao.FlightDao;
import org.dummy.flightsearch.spring.model.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins="http://localhost:4200")
@RestController
public class FlightRestController {

	
	
	@Autowired
	private FlightDao flightDao;

	
	@GetMapping("/flights")
	public List<Flight> getFlights() {
		return flightDao.get();
	}

	@GetMapping("/flights/{flightNumber}")
	public ResponseEntity<?> getFlights(@PathVariable("flightNumber") String flightNumber) {

		List<Flight> flights = FlightDao.get(flightNumber);
		if (flights == null) {
			return new ResponseEntity<String>("No flight found for ID " + flightNumber, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<List<Flight>>(flights, HttpStatus.OK);
	}

	@GetMapping("/flights/{flightNumber}/{dt}")
	public ResponseEntity<?> getFlights1(@PathVariable("flightNumber") String flightNumber ,@PathVariable("dt") String epochString) {

		long epoch = Long.parseLong( epochString );
		List<Flight> flights = new ArrayList<Flight>();
		Date departureDate = new Date(epoch);
		flights = FlightDao.get(flightNumber,departureDate);
		System.out.println(departureDate);
		if (flights == null) {
			return new ResponseEntity<String>("No flight found for ID " + flightNumber, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<List<Flight>>(flights, HttpStatus.OK);
	}	

	@GetMapping("/flights/{origin}/{destination}/{dt}")
	public ResponseEntity<?> getFlights2(
			@PathVariable("origin") String origin,
			@PathVariable("destination") String destination,
			@PathVariable("dt") String epochString) {

		long epoch = Long.parseLong( epochString );
		List<Flight> flights = new ArrayList<Flight>();
		Date departureDate = new Date(epoch);
		flights = FlightDao.get(origin,destination,departureDate);
		System.out.println(departureDate);
		if (flights == null) {
			return new ResponseEntity<String>("No flight found for ID " + origin + " " + destination  , HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<List<Flight>>(flights, HttpStatus.OK);
	}	

}
