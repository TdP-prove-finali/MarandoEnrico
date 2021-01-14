/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

package it.polito.tdp.tesi;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.tesi.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	Model model;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="cmbBox"
    private ComboBox<Integer> cmbBox; // Value injected by FXMLLoader

    @FXML // fx:id="libri"  
    private TextField libri; // Value injected by FXMLLoader

    @FXML // fx:id="stage"
    private TextField stage; // Value injected by FXMLLoader

    @FXML // fx:id="close"
    private TextField close; // Value injected by FXMLLoader

    @FXML // fx:id="collezionabili"
    private TextField collezionabili; // Value injected by FXMLLoader
    
    @FXML // fx:id="btnMagazzino"
    private Button btnMagazzino; // Value injected by FXMLLoader

    @FXML // fx:id="btnSimula"
    private Button btnSimula; // Value injected by FXMLLoader

    @FXML // fx:id="risultato"
    private TextArea risultato; // Value injected by FXMLLoader

    @FXML // fx:id="btnReset"
    private Button btnReset; // Value injected by FXMLLoader
    
    @FXML
    void magazzino(ActionEvent event) {
    	
    	risultato.clear();
    	if(cmbBox.getValue()==null) {
    		risultato.setText("Selezionare un importo");
    		return;
    	}
    	
    	try {
    		double libripc = Double.parseDouble(libri.getText().replace(',', '.').replace('%', ' '));
    		if(libripc>100) {
    			risultato.clear();
    			risultato.appendText("La percentuale non può superare il 100%");
    			btnSimula.setDisable(true);
    			return;
    		}
    		risultato.appendText("Nel magazzino ci sono "+(cmbBox.getValue()/100*(int) Math.round(libripc)/25)+" libri\n");
    	} catch (NumberFormatException e){
    		libri.clear();
    		risultato.setText("Inserire nella casella 'Libri' un numero per poter avviare la simulazione, '0' se non si vuole acquistare il prodotto");
    		btnSimula.setDisable(true);
    		return;
    	}
    	
    	try {
    		double stagepc = Double.parseDouble(stage.getText().replace(',', '.').replace('%', ' '));
    		if(stagepc+Double.parseDouble(libri.getText().replace(',', '.').replace('%', ' '))>100) {
    			risultato.clear();
    			risultato.appendText("La percentuale non può superare il 100%");
    			btnSimula.setDisable(true);
    			return;
    		}
    		risultato.appendText("Nel magazzino ci sono "+(cmbBox.getValue()/100*(int) Math.round(stagepc)/100)+" stage\n");
    	} catch (NumberFormatException e){
    		stage.clear();
    		risultato.appendText("Inserire nella casella 'Stage' un numero per poter avviare la simulazione, '0' se non si vuole acquistare il prodotto");
    		btnSimula.setDisable(true);
    		return;
    	}
    		
    	try {
    		double closepc = Double.parseDouble(close.getText().replace(',', '.').replace('%', ' '));
    		if(closepc+Double.parseDouble(libri.getText().replace(',', '.').replace('%', ' '))+Double.parseDouble(stage.getText().replace(',', '.').replace('%', ' '))>100) {
    			risultato.clear();
    			risultato.appendText("La percentuale non può superare il 100%");
    			btnSimula.setDisable(true);
    			return;
    		}
    		risultato.appendText("Nel magazzino ci sono "+(cmbBox.getValue()/100*(int) Math.round(closepc)/30)+" close-up\n");
    	} catch (NumberFormatException e){
    		close.clear();
    		risultato.appendText("Inserire nella casella 'Close-up' un numero per poter avviare la simulazione, '0' se non si vuole acquistare il prodotto");
    		btnSimula.setDisable(true);
    		return;
    	}
    	
    	try {
    		double collezionabilipc = Double.parseDouble(collezionabili.getText().replace(',', '.').replace('%', ' '));
    		if(collezionabilipc+Double.parseDouble(libri.getText().replace(',', '.').replace('%', ' '))+Double.parseDouble(stage.getText().replace(',', '.').replace('%', ' '))+Double.parseDouble(close.getText().replace(',', '.').replace('%', ' '))>100) {
    			risultato.clear();
    			risultato.appendText("La percentuale non può superare il 100%");
    			btnSimula.setDisable(true);
    			return;
    		}
    		risultato.appendText("Nel magazzino ci sono "+(cmbBox.getValue()/100*(int) Math.round(collezionabilipc)/15)+" collezionabili\n");
    		btnSimula.setDisable(false);
    	} catch (NumberFormatException e){
    		collezionabili.clear();
    		risultato.appendText("Inserire nella casella 'Collezionabili' un numero per poter avviare la simulazione, '0' se non si vuole acquistare il prodotto");
    		btnSimula.setDisable(true);
    		return;
    	}

    }

    @FXML
    void reset(ActionEvent event) {
    	
    	risultato.clear();
    	libri.clear();
    	stage.clear();
    	close.clear();
    	collezionabili.clear();
    	cmbBox.setValue(null);
    	btnSimula.setDisable(true);

    }

    @FXML
    void simula(ActionEvent event) {
    	risultato.clear();
    	
    	try {
    		double libripc = Double.parseDouble(libri.getText().replace(',', '.').replace('%', ' '));
        	double closepc = Double.parseDouble(close.getText().replace(',', '.').replace('%', ' '));
        	double collezionabilipc = Double.parseDouble(collezionabili.getText().replace(',', '.').replace('%', ' '));
        	double stagepc = Double.parseDouble(stage.getText().replace(',', '.').replace('%', ' '));
    	model.run((cmbBox.getValue()/100*(int) Math.round(libripc)/25), (cmbBox.getValue()/100*(int) Math.round(closepc)/30), (cmbBox.getValue()/100*(int) Math.round(collezionabilipc)/15), (cmbBox.getValue()/100*(int) Math.round(stagepc)/100));
        risultato.appendText("sono stati soddisfatti il "+model.getSoddisfatti()+"% dei clienti"); }
    	catch (NumberFormatException e) {
    		risultato.appendText("controlla di avere inserito valori corretti!");
    	}
    } 

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert cmbBox != null : "fx:id=\"cmbBox\" was not injected: check your FXML file 'Scene.fxml'.";
        assert libri != null : "fx:id=\"libri\" was not injected: check your FXML file 'Scene.fxml'.";
        assert stage != null : "fx:id=\"stage\" was not injected: check your FXML file 'Scene.fxml'.";
        assert close != null : "fx:id=\"close\" was not injected: check your FXML file 'Scene.fxml'.";
        assert collezionabili != null : "fx:id=\"collezionabili\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnSimula != null : "fx:id=\"btnSimula\" was not injected: check your FXML file 'Scene.fxml'.";
        assert risultato != null : "fx:id=\"risultato\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

        List<Integer> box = new ArrayList<>();
        //valori sensati in base alla realtà ed ai dati, partendo da un minimo di 100 al di sotto del quale, il problema, sarebbe molto poco realistico
        box.add(100);
        box.add(200);
        box.add(300);
        box.add(400);
        box.add(500);
        box.add(600);
        box.add(700);
        box.add(800);
        box.add(900);
        box.add(1000);
        
        cmbBox.getItems().addAll(box);
        
        btnSimula.setDisable(true);
    }

	public void setModel(Model model) {
		// TODO Auto-generated method stub
		this.model=model;
	}
}
