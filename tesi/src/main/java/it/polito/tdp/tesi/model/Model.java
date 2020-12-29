package it.polito.tdp.tesi.model;

public class Model {

	Simulator s = new Simulator();
	
	public void run(int libri, int close, int collezionabili, int scena) {
		s.run(libri, close, collezionabili, scena);
	}
	public int getSoddisfatti() {
		return s.getSoddisfatti();
	}
}
