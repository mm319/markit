package com.markit.booking.dto;

public class Room {

	private int roomNumber;
	private String roomType;

	public Room(int roomNumber) {
		this.roomNumber = roomNumber;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if (obj == this)
			return true;
		
		if (!(obj instanceof Room))
			return false;
				
		Room r = (Room)obj;
		
		return this.roomNumber == r.roomNumber;
	}
	
	@Override
	public int hashCode() {
	
		int result = 33;
		result = 21 * result + roomNumber;

		return result;
	}
	
	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
}
