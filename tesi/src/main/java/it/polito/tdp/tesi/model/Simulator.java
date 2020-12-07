package it.polito.tdp.tesi.model;

import java.util.PriorityQueue;

import it.polito.tdp.tesi.model.Event.EventType;

public class Simulator {
	
	int libririm; //libri rimasti in magazzino
	int closerim; //close-up rimasti in magazzino
	int collezionabilirim; //collezionabili rimasti in magazzino
	int scenarim; //scena rimasti in magazzino
	
	private PriorityQueue<Event> queue = new PriorityQueue<>();
	private int soddisfatti;
	
	public void run(int libri, int close, int collezionabili, int scena) {
		//all'inizio le rimanenze per ogni reparto sono uguali alla loro capienza massima (scelta dall'utente) 
		libririm = libri; 
		closerim = close;
		collezionabilirim = collezionabili;
		scenarim = scena;
		int i=0;
	
		for (int j=0; j<4; j++) {  //ipotesi di 4 settimane
			i=0;
			while (i<120) { //ipotesi di 20 clienti al giorno * 6 giorni lavorativi
				
				 double p = Math.random();
				 
				 if(i<120) {
					 if (p<0.7) {
						Event e = new Event (j, EventType.ACQUISTO, "libri");
						this.queue.add(e);
						i++;
					 }
				 	}
				 if(i<120) {
					 if (p<0.5) {
						Event e = new Event (j, EventType.ACQUISTO, "collezionabili");
						this.queue.add(e);
						i++;
					 }
				 	}
				 if(i<120) {
					 if (p<0.4) {
						 Event e = new Event (j, EventType.ACQUISTO, "close");
						 this.queue.add(e);
						 i++;
					 }
				 	}
				 if(i<120) {
					 if (p<0.1) {
						Event e = new Event (j, EventType.ACQUISTO, "scena");
						this.queue.add(e);
						i++;
					 }
				 }
			}
		}
		
		while(!this.queue.isEmpty()) {
			Event e = this.queue.poll();
			processEvent(e);
			System.out.println(e);
	}
	}
	
	private void processEvent(Event e) {
		
		switch(e.getType()) {
		
		case ACQUISTO:
			
			switch (e.getTipologia()) {
			
			case "libri":
				break;
				
			case "collezionabili":
				break;
				
			case "close":
				break;
				
			case "scena":
				break;	
				
			}
	
			break;
			
		case ORDINE:
			
			switch (e.getTipologia()) {
			
				case "libri":
					break;
				
				case "collezionabili":
					break;
				
				case "close":
					break;
				
				case "scena":
					break;	
				
			}

			break;
}
	}
}
