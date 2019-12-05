package org.dummy.flightsearch.spring.model;

import java.util.Date;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({

	"flightNumber" , "carrier", "origin" , "departure", "destination",
	"arrival" , "aircraft" , "distance" , "travelTime"
	
})
public class Flight {

	 String flightNumber;
	 String carrier;
	 String origin;
	 Date departure;
	 String destination;
	 Date arrival ;
	 String aircraft ;
	 Integer distance ;
	 String travelTime ;
     String status ;
	 
	 
	 
	 public Flight() {}
	 
	 public Flight(String flightNumber, String carrier, String origin, Date departure, String destination, Date arrival,
			String aircraft, Integer distance, String travelTime, String status) {
		
	
		
		
		this.flightNumber = flightNumber;
		this.carrier = carrier;
		this.origin = origin;
		this.departure = departure;
		this.destination = destination;
		this.arrival = arrival;
		this.aircraft = aircraft;
		this.distance = distance;
		this.travelTime = travelTime;
		this.status = status;
	}
	 
	 
	 
	public String getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}
	public String getCarrier() {
		return carrier;
	}
	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public Date getDeparture() {
		return departure;
	}
	public void setDeparture(Date departure) {
		this.departure = departure;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public Date getArrival() {
		return arrival;
	}
	public void setArrival(Date arrival) {
		this.arrival = arrival;
	}
	public String getAircraft() {
		return aircraft;
	}
	public void setAircraft(String aircraft) {
		this.aircraft = aircraft;
	}
	public Integer getDistance() {
		return distance;
	}
	public void setDistance(Integer distance) {
		this.distance = distance;
	}
	public String getTravelTime() {
		return travelTime;
	}
	public void setTravelTime(String travelTime) {
		this.travelTime = travelTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}



	
	
	
}
