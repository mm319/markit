package com.markit.booking;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Assert;
import org.junit.Test;

import com.markit.booking.dto.Guest;
import com.markit.booking.dto.Room;


public class TestBooking {

	@Test
	public void tetsRoomAvailablity() throws ParseException {
		
		Guest guest = new Guest();
		guest.setLastName("Bloggs");
		guest.setFirstName("Joe");
		
		Room room = new Room();
		room.setRoomNumber(201);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		BookingManager bm = new MarkitBookingManager();
		bm.addBooking(guest.getLastName(), room.getRoomNumber(), sdf.parse("2016-10-25"));
		
		Assert.assertFalse(bm.isRoomAvailable(201, sdf.parse("2016-10-25")));
		Assert.assertTrue(bm.isRoomAvailable(201, sdf.parse("2016-10-26")));
		
	}
	
}
