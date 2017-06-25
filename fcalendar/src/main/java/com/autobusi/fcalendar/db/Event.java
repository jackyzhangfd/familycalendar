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
	
}