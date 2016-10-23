package com.markit.booking;

import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;


public class TestBooking {

	@Test
	public void tetsRoomAvailablity() {
		
		Guest guest = new Guest();
		guest.setLastName("Bloggs");
		guest.setFirstName("Joe");
		
		Room room = new Room();
		room.setNumber(201);
		
		BookingManager bm = new MarkitBookingManager();
		bm.addBooking(guest.getName(), room.getNumber(), Calendar.getInstance().getTime());
	}
	
}
