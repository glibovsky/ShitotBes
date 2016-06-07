package com.shitot.dao;

import java.util.*;
import javax.persistence.*;

@Entity
@Table(name="slot")
public class SlotDAO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="slot_id")
	private int id;
	
	//private int dayOfWeek;
	@Temporal(TemporalType.DATE)
	private Date date;
	
	@OneToMany
	List<IntervalDAO> intervals;
	
	public SlotDAO() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	/*public int getDayOfWeek() {
		return dayOfWeek;
	}

	public void setDayOfWeek(int dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}
*/
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<IntervalDAO> getIntervals() {
		return intervals;
	}

	public void setIntervals(List<IntervalDAO> intervals) {
		this.intervals = intervals;
	}
	

}
