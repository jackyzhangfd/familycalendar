package com.autobusi.fcalendar.db;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

@Entity
public class Event {
	@Id @GeneratedValue
	private Long id;
	
	private Date startTime;
	private Date endTime;
	private String name;
	private String detail;
	
	@ManyToOne
	private EventSeries eventSeries;
	
	private Event() {
		
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public EventSeries getEventSeries() {
		return eventSeries;
	}

	public void setEventSeries(EventSeries eventSeries) {
		this.eventSeries = eventSeries;
	}
	
}