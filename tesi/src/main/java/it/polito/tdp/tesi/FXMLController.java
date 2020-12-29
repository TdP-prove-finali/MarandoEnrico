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
    		int libripc = Integer.parseInt(libri.getText());
    		if(libripc>100) {
    			risultato.clear();
    			risultato.appendText("La percentuale non può superare il 100%");
    			btnSimula.setDisable(true);
    			return;
    		}
    		risultato.appendText("Nel magazzino ci sono "+(cmbBox.getValue()/100*libripc)/25+" libri\n");
    	} catch (NumberFormatException e){
    		libri.clear();
    		risultato.setText("Inserire nella casella 'Libri' un intero (Es. 20) per poter avviare la simulazione, '0' se non si vuole acquistare il prodotto");
    		btnSimula.setDisable(true);
    		return;
    	}
    	
    	try {
    		int stagepc = Integer.parseInt(stage.getText());
    		if(stagepc+Integer.parseInt(libri.getText())>100) {
    			risultato.clear();
    			risultato.appendText("La percentuale non può superare il 100%");
    			btnSimula.setDisable(true);
    			return;
    		}
    		risultato.appendText("Nel magazzino ci sono "+(cmbBox.getValue()/100*stagepc)/100+" stage\n");
    	} catch (NumberFormatException e){
    		stage.clear();
    		risultato.appendText("Inserire nella casella 'Stage' un intero (Es. 20) per poter avviare la simulazione, '0' se non si vuole acquistare il prodotto");
    		btnSimula.setDisable(true);
    		return;
    	}
    		
    	try {
    		int closepc = Integer.parseInt(close.getText());
    		if(closepc+Integer.parseInt(libri.getText())+Integer.parseInt(stage.getText())>100) {
    			risultato.clear();
    			risultato.appendText("La percentuale non può superare il 100%");
    			btnSimula.setDisable(true);
    			return;
    		}
    		risultato.appendText("Nel magazzino ci sono "+(cmbBox.getValue()/100*closepc)/30+" close-up\n");
    	} catch (NumberFormatException e){
    		close.clear();
    		risultato.appendText("Inserire nella casella 'Close-up' un intero (Es. 20) per poter avviare la simulazione, '0' se non si vuole acquistare il prodotto");
    		btnSimula.setDisable(true);
    		return;
    	}
    	
    	try {
    		int collezionabilipc = Integer.parseInt(collezionabili.getText());
    		if(collezionabilipc+Integer.parseInt(libri.getText())+Integer.parseInt(stage.getText())+Integer.parseInt(close.getText())>100) {
    			risultato.clear();
    			risultato.appendText("La percentuale non può superare il 100%");
    			btnSimula.setDisable(true);
    			return;
    		}
    		risultato.appendText("Nel magazzino ci sono "+(cmbBox.getValue()/100*collezionabilipc)/15+" collezionabili\n");
    		btnSimula.setDisable(false);
    	} catch (NumberFormatException e){
    		collezionabili.clear();
    		risultato.appendText("Inserire nella casella 'Collezionabili' un intero (Es. 20) per poter avviare la simulazione, '0' se non si vuole acquistare il prodotto");
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
    	model.run(Integer.parseInt(libri.getText()), Integer.parseInt(close.getText()), Integer.parseInt(collezionabili.getText()), Integer.parseInt(stage.getText()));
        risultato.appendText("sono stati soddisfatti il "+model.getSoddisfatti()+"% dei clienti");  
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
        //valori sensati in base alla realtà ed ai dati
        box.add(500);
        box.add(1000);
        box.add(2000);
        
        cmbBox.getItems().addAll(box);
        
        btnSimula.setDisable(true);
    }

	public void setModel(Model model) {
		// TODO Auto-generated method stub
		this.model=model;
	}
}
