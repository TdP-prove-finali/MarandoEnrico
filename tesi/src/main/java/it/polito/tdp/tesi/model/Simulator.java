package it.polito.tdp.tesi.model;

import java.util.PriorityQueue;

import it.polito.tdp.tesi.model.Event.EventType;

public class Simulator {
	
	int libriRim; //libri rimasti in magazzino
	int closeRim; //close-up rimasti in magazzino
	int collezionabiliRim; //collezionabili rimasti in magazzino
	int scenaRim; //scena rimasti in magazzino
	
	//quantità massime in magazzino
		int libriMax;
		int closeMax;
		int collezionabiliMax;
		int scenaMax;

	
	private PriorityQueue<Event> queue = new PriorityQueue<>();
	private double soddisfatti; //contatore per i clienti che riescono ad acquistare
	
	private int prenotatiL=0; //libri prenotati per la settimana successiva
	private int prenotatiC=0; //close up prenotati per la settimana successiva
	private int prenotatiCl=0; //collezionabili prenotati per la settimana successiva
	private int prenotatiS=0; //scena prenotati per la settimana successiva
	
	public void run(int libri, int close, int collezionabili, int scena) {
		
		soddisfatti=0;
		
		//all'inizio le rimanenze per ogni reparto sono uguali alla loro capienza massima (scelta dall'utente) 
			libriRim = libriMax = libri; 
			closeRim = closeMax = close;
			collezionabiliRim = collezionabiliMax = collezionabili;
			scenaRim = scenaMax = scena;
			
		int i=0;
	
		for (int j=0; j<4; j++) {  //ipotesi di 4 settimane
			i=0;
			while (i<120) { //ipotesi di 20 clienti al giorno * 6 giorni lavorativi
				
				 double p = Math.random();
				 
				 if(i<120) {
					 if (p<0.01) {
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
					 if (p<0.37) {
						 Event e = new Event (j, EventType.ACQUISTO, "close");
						 this.queue.add(e);
						 i++;
					 }
				 	}
				 if(i<120) {
					 if (p<0.12) {
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
		
		boolean nuovaSettimana = false;
		
		if (this.queue.iterator().hasNext()) {
			if (this.queue.iterator().next().getWeek() != e.getWeek()) {
				nuovaSettimana = true;
			}
		}
		
			switch (e.getTipologia()) {
			
			case "libri":
				if (libriRim>0) {
					libriRim--;
					soddisfatti++;
					
				}
				else {
					if (Math.random()>0.4) //probabilità che il clienti ordini il prodotto per la settimana prossima
						prenotatiL++;
					if (prenotatiL<=libriMax) //in caso contrario le prenotazioni per la settimana seguente hanno già raggiunto il numero massimo che avrò in magazzino ed ho quindi esaurito i prodotti anche per la settimana prossima
						soddisfatti++;
				}
				break;
				
			case "collezionabili":
				if (collezionabiliRim>0) {
					collezionabiliRim--;
					soddisfatti++;
					
				}
				else {
					if (Math.random()>0.4) //probabilità che il clienti ordini il prodotto per la settimana prossima
						prenotatiCl++;
					if (prenotatiCl<=collezionabiliMax) //in caso contrario le prenotazioni per la settimana seguente hanno già raggiunto il numero massimo che avrò in magazzino ed ho quindi esaurito i prodotti anche per la settimana prossima
						soddisfatti++;
				}
				break;
				
			case "close":
				if (closeRim>0) {
					closeRim--;
					soddisfatti++;
					
				}
				else {
					if (Math.random()>0.4) //probabilità che il clienti ordini il prodotto per la settimana prossima
						prenotatiC++;
					if (prenotatiC<=closeMax) //in caso contrario le prenotazioni per la settimana seguente hanno già raggiunto il numero massimo che avrò in magazzino ed ho quindi esaurito i prodotti anche per la settimana prossima
						soddisfatti++;
				}
				break;
				
			case "scena":
				if (scenaRim>0) {
					scenaRim--;
					soddisfatti++;
					
				}
				else {
					if (Math.random()>0.4) //probabilità che il clienti ordini il prodotto per la settimana prossima
						prenotatiS++;
					if (prenotatiS<=scenaMax) //in caso contrario le prenotazioni per la settimana seguente hanno già raggiunto il numero massimo che avrò in magazzino ed ho quindi esaurito i prodotti anche per la settimana prossima
						soddisfatti++;
				}
				break;	
				
			}
			
	//il prossimo evento sarà il primo della prossima settimana perciò il magazzino torna a capienza massima meno i prodotti già prenotati che vengono acquistati ma tenuti da parte per evitare di essere venduti ad altre persone
	if (nuovaSettimana==true) { 
		libriRim=libriMax-prenotatiL;
		prenotatiL=0;
		
		collezionabiliRim=collezionabiliMax-prenotatiCl;
		prenotatiCl=0;
		
		closeRim=closeMax-prenotatiC;
		prenotatiC=0;
		
		scenaRim=scenaMax-prenotatiS;
		prenotatiS=0;
	}
}
	public int getSoddisfatti() {
		int risultato = (int) (soddisfatti/(120*4)*100);
		return risultato;
	}
	
	}

