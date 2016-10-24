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
		
		//101 102 201 203
		Guest guest1 = new Guest("Bloggs");
		Guest guest2 = new Guest("Smith");
		Guest guest3 = new Guest("Suzuki");
		Guest guest4 = new Guest("Ali");
		
		Room room1 = new Room(201);
		Room room2 = new Room(101);
		Room room3 = new Room(203);
		Room room4 = new Room(102);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		BookingManager bm = new MarkitBookingManager();
		bm.addBooking(guest1.getLastName(), room1.getRoomNumber(), sdf.parse("2016-10-25"));
		bm.addBooking(guest2.getLastName(), room1.getRoomNumber(), sdf.parse("2016-10-25"));
		bm.addBooking(guest3.getLastName(), room1.getRoomNumber(), sdf.parse("2016-10-25"));
		bm.addBooking(guest4.getLastName(), room1.getRoomNumber(), sdf.parse("2016-10-25"));
		

		Assert.assertFalse(bm.isRoomAvailable(room1.getRoomNumber(), sdf.parse("2016-10-25")));
		Assert.assertTrue(bm.isRoomAvailable(room1.getRoomNumber(), sdf.parse("2016-10-26")));
		Assert.assertTrue(bm.isRoomAvailable(room2.getRoomNumber(), sdf.parse("2016-10-26")));
		Assert.assertTrue(bm.isRoomAvailable(room3.getRoomNumber(), sdf.parse("2016-10-25")));
		Assert.assertTrue(bm.isRoomAvailable(room4.getRoomNumber(), sdf.parse("2016-10-25")));
	}
}
