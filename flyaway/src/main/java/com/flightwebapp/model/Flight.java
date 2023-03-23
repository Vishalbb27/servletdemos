package com.flightwebapp.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Flight {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	public Flight() {
		super();
	}

	public Flight(Airlines airline, Place sourcePlace, Place destinationPlace, LocalDateTime departureTime,
			 List<TicketPrice> ticketPrices) {
		super();
		this.airline = airline;
		this.sourcePlace = sourcePlace;
		this.destinationPlace = destinationPlace;
		this.departureTime = departureTime;
		this.ticketPrices = ticketPrices;
	}

	public Airlines getAirline() {
		return airline;
	}

	public void setAirline(Airlines airline) {
		this.airline = airline;
	}

	public Place getSourcePlace() {
		return sourcePlace;
	}

	public void setSourcePlace(Place sourcePlace) {
		this.sourcePlace = sourcePlace;
	}

	public Place getDestinationPlace() {
		return destinationPlace;
	}

	public void setDestinationPlace(Place destinationPlace) {
		this.destinationPlace = destinationPlace;
	}

	public LocalDateTime getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(LocalDateTime departureTime) {
		this.departureTime = departureTime;
	}

	public List<TicketPrice> getTicketPrices() {
		return ticketPrices;
	}

	public void setTicketPrices(List<TicketPrice> ticketPrices) {
		this.ticketPrices = ticketPrices;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "airline_id")
	private Airlines airline;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "source_place_id")
	private Place sourcePlace;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "destination_place_id")
	private Place destinationPlace;
	
	@Column(name = "departure_time")
	private LocalDateTime departureTime;

	@OneToMany(mappedBy="flight",cascade=CascadeType.ALL,orphanRemoval=true)
	private List<TicketPrice> ticketPrices = new ArrayList<>();
	
	public void addTicketPrice(TicketPrice ticketPrice) {
		ticketPrices.add(ticketPrice);
		ticketPrice.setFlight(this);
	}
	
	public void removeTicketPrice(TicketPrice ticketPrice) {
		ticketPrices.remove(ticketPrice);
		ticketPrice.setFlight(null);
	}
}
