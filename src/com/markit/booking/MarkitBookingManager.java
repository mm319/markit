package com.markit.booking;

import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;

import com.markit.booking.dto.Booking;
import com.markit.booking.dto.Guest;

public class MarkitBookingManager implements BookingManager {

	private ConcurrentHashMap<Booking,Guest> bookingMap = new ConcurrentHashMap<Booking,Guest>();
	
	@Override
	public boolean isRoomAvailable(Integer room, Date date) {
		
		boolean available;
		
		Booking b = new Booking(room, date);
		
		available = bookingMap.containsKey(b) ? false : true;
		
		return available;
	}

	@Override
	public void addBooking(String guest, Integer room, Date date) {
		
		Booking b = new Booking(room, date);
		Guest g = new Guest(guest);
		
		if (! bookingMap.containsKey(b)) {
			bookingMap.put(b, g);
		} else {
			System.out.println(guest +" cannot have the room as it is already booked by another guest");
		}
	}

}
