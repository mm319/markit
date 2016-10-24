package com.markit.booking;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

import com.markit.booking.dto.Booking;
import com.markit.booking.dto.Guest;
import com.markit.booking.dto.Room;

public class MarkitBookingManager implements BookingManager {

	private ConcurrentHashMap<Booking,Guest> bookingMap = new ConcurrentHashMap<Booking,Guest>();
	private HashSet<Room> rooms;
	
	public MarkitBookingManager() {
		
		rooms = new HashSet<Room>();
		rooms.add(new Room(201));
		rooms.add(new Room(101));
		rooms.add(new Room(203));
		rooms.add(new Room(102));
	}
	
	public MarkitBookingManager(Room[] rooms) {
		
		this.rooms = new HashSet<Room>();
		
		for (Room r: rooms) {
			this.rooms.add(r);
		}
	}
	
	@Override
	public boolean isRoomAvailable(Integer room, Date date) {
		
		boolean available;
		
		Booking b = new Booking(room, date);
		
		available = bookingMap.containsKey(b) ? false : true;
		
		//System.out.println(room +" availablity: " +available + " for " + b.getfDate());
		return available;
	}

	@Override
	public void addBooking(String guest, Integer room, Date date) {
		
		if (!rooms.contains(new Room(room))) {
			System.out.println("Room number: " +room + " does not exist in the hotel");
			return;
		}
		
		Booking b = new Booking(room, date);
		Guest g = new Guest(guest);
		
		if (! bookingMap.containsKey(b)) {
			bookingMap.put(b, g);
		} else {
			System.out.println(guest +" cannot have the room as it is already booked by another guest");
		}
	}
	
	@Override
	public Iterable<Integer> getAvailableRooms(Date date) {
		
		HashSet<Integer> available = new HashSet<Integer>();
		
		Iterator<Room> i = rooms.iterator();
		while (i.hasNext()) {
			Room room = i.next();
			if (isRoomAvailable(room.getRoomNumber(), date)) {
				available.add(room.getRoomNumber());
				System.out.println(room.getRoomNumber() +" available for " +new SimpleDateFormat("yyyy-MM-dd").format(date));
			}
		}
		return available;
	}

}
