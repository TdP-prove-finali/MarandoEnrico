/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

package it.polito.tdp.tesi;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

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

    }

    @FXML
    void reset(ActionEvent event) {
    	
    	risultato.clear();
    	libri.clear();
    	stage.clear();
    	close.clear();
    	collezionabili.clear();
    	cmbBox.setValue(null);

    }

    @FXML
    void simula(ActionEvent event) {
          
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
        box.add(1000);
        box.add(2000);
        box.add(3000);
        
        cmbBox.getItems().addAll(box);
    }
}
