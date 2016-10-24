package com.markit.booking;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;

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
		Room room5 = new Room(567);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		BookingManager bm = MarkitBookingManager.getInstance();
		BookingManager bm1 = MarkitBookingManager.getInstance();
		
		bm.addBooking(guest1.getLastName(), room1.getRoomNumber(), sdf.parse("2016-10-25"));
		bm.addBooking(guest2.getLastName(), room1.getRoomNumber(), sdf.parse("2016-10-25"));
		bm.addBooking(guest3.getLastName(), room1.getRoomNumber(), sdf.parse("2016-10-25"));
		bm.addBooking(guest4.getLastName(), room1.getRoomNumber(), sdf.parse("2016-10-25"));
		bm.addBooking(guest4.getLastName(), room5.getRoomNumber(), sdf.parse("2016-10-25"));
		
		bm1.addBooking(guest3.getLastName(), room1.getRoomNumber(), sdf.parse("2016-10-25"));
		

		Assert.assertFalse(bm.isRoomAvailable(room1.getRoomNumber(), sdf.parse("2016-10-25")));
		Assert.assertTrue(bm.isRoomAvailable(room1.getRoomNumber(), sdf.parse("2016-10-26")));
		Assert.assertTrue(bm.isRoomAvailable(room2.getRoomNumber(), sdf.parse("2016-10-26")));
		Assert.assertTrue(bm.isRoomAvailable(room3.getRoomNumber(), sdf.parse("2016-10-25")));
		Assert.assertTrue(bm.isRoomAvailable(room4.getRoomNumber(), sdf.parse("2016-10-25")));
		Assert.assertTrue(bm1.isRoomAvailable(room4.getRoomNumber(), sdf.parse("2016-10-25")));
		
		Iterable<Integer> availableRooms = bm.getAvailableRooms(sdf.parse("2016-10-25"));
		ArrayList<Integer> roomList = new ArrayList<Integer>();
		Iterator<Integer> i = availableRooms.iterator();
		
		while(i.hasNext()) {
			roomList.add(i.next());
		}
		
		Assert.assertEquals(3, roomList.size());
		
		availableRooms = bm.getAvailableRooms(sdf.parse("2016-10-26"));
		roomList = new ArrayList<Integer>();
		i = availableRooms.iterator();
		
		while(i.hasNext()) {
			roomList.add(i.next());
		}
		
		Assert.assertEquals(4, roomList.size());
	}
}
