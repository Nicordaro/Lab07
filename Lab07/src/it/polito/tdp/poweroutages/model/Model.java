package it.polito.tdp.poweroutages.model;

import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.poweroutages.db.PowerOutageDAO;

public class Model {

	List<String> eventi = new ArrayList<>();
	List<String> worst;

	PowerOutageDAO podao;

	public Model() {
		podao = new PowerOutageDAO();
	}

	public List<Nerc> getNercList() {
		return podao.getNercList();
	}

	public List<Outages> testpodao(Nerc n) {
		return podao.getOutagesList(n);
	}

	// public List<String> calcolaSequenza(Duration d, Period p) {
	// List<String> parziale = new ArrayList<>();
	//
	// return eventi;
	// }

}
