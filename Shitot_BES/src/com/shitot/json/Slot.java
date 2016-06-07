package com.shitot.json;

import java.util.*;

import javax.persistence.*;

public class Slot {
	
	private int id;
	
	//private int dayOfWeek;
	@Temporal(TemporalType.DATE)
	private Date date;
	
	List<Interval> intervals;
	
	public Slot() {}
	
	

	public Slot(Date date, List<Interval> intervals) {
		this.date = date;
		this.intervals = intervals;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<Interval> getIntervals() {
		return intervals;
	}

	public void setIntervals(List<Interval> intervals) {
		this.intervals = intervals;
	}
	

}
