package it.polito.tdp.poweroutages;

/**
 * Sample Skeleton for 'PowerOutages.fxml' Controller Class
 */

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.poweroutages.model.Model;
import it.polito.tdp.poweroutages.model.Nerc;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class PowerOutagesController {
	Model m = new Model();
	List<Nerc> nercList = new ArrayList<>();
	private int years;
	private int hours;

	@FXML // ResourceBundle that was given to the FXMLLoader
	private ResourceBundle resources;

	@FXML // URL location of the FXML file that was given to the FXMLLoader
	private URL location;

	@FXML // fx:id="choiceBox"
	private ChoiceBox<Nerc> choiceBox; // Value injected by FXMLLoader

	@FXML // fx:id="yearArea"
	private TextField yearArea; // Value injected by FXMLLoader

	@FXML // fx:id="hoursArea"
	private TextField hoursArea; // Value injected by FXMLLoader

	@FXML // fx:id="buttonCalc"
	private Button buttonCalc; // Value injected by FXMLLoader

	@FXML // fx:id="resultArea"
	private TextArea resultArea; // Value injected by FXMLLoader

	@FXML
	void handleCalc(ActionEvent event) {
		years = Integer.parseInt(yearArea.getText());
		hours = Integer.parseInt(hoursArea.getText());

		Nerc n = choiceBox.getValue();

		// Debug
		// resultArea.setText("" + p + " " + d + " " + n.getId());
		//
		// if (years > 0 && hours > 0) {
		//
		//
		// }

		String s = m.calcolaSequenza(n, years, hours).toString();
		// .replaceAll("[.,\\/#!$%\\^&\\*;{}=\\_`~()\\[\\]\"]",
		// "");
		resultArea.setText(" " + s);

	}

	@FXML // This method is called by the FXMLLoader when initialization is complete
	void initialize() {
		assert choiceBox != null : "fx:id=\"choiceBox\" was not injected: check your FXML file 'PowerOutages.fxml'.";
		assert yearArea != null : "fx:id=\"yearArea\" was not injected: check your FXML file 'PowerOutages.fxml'.";
		assert hoursArea != null : "fx:id=\"hoursArea\" was not injected: check your FXML file 'PowerOutages.fxml'.";
		assert buttonCalc != null : "fx:id=\"buttonCalc\" was not injected: check your FXML file 'PowerOutages.fxml'.";
		assert resultArea != null : "fx:id=\"resultArea\" was not injected: check your FXML file 'PowerOutages.fxml'.";
		nercList = m.getNercList();
		for (Nerc n : nercList) {
			choiceBox.getItems().add(n);
		}

	}
}