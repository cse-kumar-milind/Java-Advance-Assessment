package com.app.booking.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.app.booking.client.MovieClient;
import com.app.booking.dto.BookingRequest;
import com.app.booking.dto.MovieDto;
import com.app.booking.model.Booking;

@Service
public class BookingService {
	
	private MovieClient movieClient;

	public BookingService(MovieClient movieClient) {
		this.movieClient = movieClient;
	}
	
	private List<Booking> bookings = new ArrayList<>();
	private AtomicLong idGenerator = new AtomicLong(100);
	
	public Booking createBooking(BookingRequest request) {
		
		MovieDto movie = movieClient.getMovieById(request.getMovieId());
		
		if(movie.getName().equals("Service Unavailable")) {
			throw new RuntimeException("Movie Service is currently unavailable. Please try again later.");
		}
		
		Double totalAmount = movie.getPrice()*request.getTickets();
		
		Booking booking = new Booking(idGenerator.incrementAndGet(), request.getMovieId(), movie.getName(),
				request.getCustomerName(), request.getTickets(), totalAmount, "CONFIRMED");
		
		bookings.add(booking);
		
		return booking;
		
	}
	
	public List<Booking> getAllBookings(){
		return bookings;
	}
}
