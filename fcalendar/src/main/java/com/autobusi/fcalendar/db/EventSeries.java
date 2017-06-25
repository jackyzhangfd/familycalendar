package com.autobusi.fcalendar.db;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

@Entity
public class EventSeries {
	@Id @GeneratedValue
	private Long id;
	
	@OneToMany(mappedBy = "eventSeries")
	private List<Event> events;
	
	private EventSeries() {
		
	}
	
	public List<Event> getEvents() {
		return this.events;
	}
	
	public void setEvents(List<Event> events) {
		this.events = events;
	}
	
}