package it.polito.tdp.tesi.model;

import java.time.LocalTime;

public class Event implements Comparable <Event> {
	
	
	public enum EventType {
		ACQUISTO; }
	
	private int week;
	private String tipologia; //tipologia di prodotto da acquistare
	

	public Event(int week, EventType type, String tipologia) {
		super();
		this.week = week;
		this.tipologia = tipologia;
	}

	


	public int getWeek() {
		return week;
	}




	public String getTipologia() {
		return tipologia;
	}




	@Override
	public int compareTo(Event o) {
		// TODO Auto-generated method stub
		return this.week-o.week;
	}




	@Override
	public String toString() {
		return week + " " + tipologia;
	}
	
	

}
