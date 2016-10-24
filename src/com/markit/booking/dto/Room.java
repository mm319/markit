package com.markit.booking.dto;

public class Room {

	private int roomNumber;
	private String roomType;

	public Room(int roomNumber) {
		this.roomNumber = roomNumber;
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
