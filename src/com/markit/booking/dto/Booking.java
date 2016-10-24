package com.markit.booking.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Booking {

	private int room;
	private Date date;
	private String fDate;
	private SimpleDateFormat sdf;
	
	public Booking(int room, Date date) {
		
		this.room = room;
		this.date = date;
		sdf = new SimpleDateFormat("yyyy-MM-dd");
		fDate = sdf.format(this.date);
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if (obj == this)
			return true;
		
		if (!(obj instanceof Booking))
			return false;
				
		Booking b = (Booking)obj;
		
		if(date == null || b.getDate() == null)
			return false;
		
		String dateCompare = sdf.format(b.getDate());
		
		return this.room == b.getRoom() && fDate.equals(dateCompare);
	}
	
	@Override
	public int hashCode() {
	
		int result = 33;
		result = 21 * result + room;
		result = 21 * result +fDate.hashCode();

		return result;
	}
	
	public int getRoom() {
		return room;
	}
	
	public void setRoom(int room) {
		this.room = room;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}

	public String getfDate() {
		return fDate;
	}
}
