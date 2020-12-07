package it.polito.tdp.tesi.model;

import java.time.LocalTime;

public class Event implements Comparable <Event> {
	
	
	public enum EventType {
		ACQUISTO, ORDINE; //semplice acquisto oppure 'ordine' nel caso si fosse già tentato un acquisto la settimana precedente e si decide di tornare la settimana eseguente essendo il prodotto momentaneamente terminato
	}
	
	private int week;
	private EventType type;
	private String tipologia; //tipologia di prodotto da acquistare
	

	public Event(int week, EventType type, String tipologia) {
		super();
		this.week = week;
		this.type = type;
		this.tipologia = tipologia;
	}

	


	public int getWeek() {
		return week;
	}




	public EventType getType() {
		return type;
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
		return week + " " + type + " " + tipologia;
	}
	
	

}
