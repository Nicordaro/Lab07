package it.polito.tdp.poweroutages.model;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.poweroutages.db.PowerOutageDAO;

public class Model {
	private static int PERIOD_MAX = 0;
	private static int DURATION_MAX = 0;

	List<String> eventi = new ArrayList<>();
	List<Outages> worst;

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

	// IL LIVELLO E' LA DURATA (numero di ore di disservizio)
	// IL PERIODO INDICA IL NUMERO DI ANNI DI CUI TENER CONTO

	public List<Outages> calcolaSequenza(Nerc n, int years, int hours) {
		List<Outages> guasti = new ArrayList<>();
		PERIOD_MAX = hours;
		DURATION_MAX = years;

		cerca(n, guasti, 0);
		return worst;
	}

	private void cerca(Nerc n, List<Outages> guasti, long livello) {
		if (livello >= PERIOD_MAX) {
			int coinvolte = numeroPersone(guasti);
			if (worst == null || coinvolte > numeroPersone(worst)) {
				worst = new ArrayList<>(guasti);
			}

			System.out.println(guasti);
		} else {

			for (Outages o : this.testpodao(n)) {
				if (aggiuntaValida(o, guasti)) {
					guasti.add(o);
					long diff = Duration.between(o.getInizio(), o.getFine()).toHours();
					// long differenza = diff.getSeconds();
					cerca(n, guasti, livello + diff);
					guasti.remove(guasti.size() - 1);
				}
			}
		}

	}

	private boolean aggiuntaValida(Outages o, List<Outages> guasti) {
		Outages first = null;
		for (Outages otest : guasti) {
			if (otest.getInizio().getYear() < first.getInizio().getYear() || first == null) {
				first = otest;
			}
		}
		int annoDaVerificare = o.getInizio().getYear();
		int annoPrimoGuasto = first.getInizio().getYear();
		int differenza = DURATION_MAX;
		if (annoDaVerificare - annoPrimoGuasto < differenza) {
			return true;
		} else
			return false;
	}

	private int numeroPersone(List<Outages> guasti) {
		int somma = 0;
		for (Outages o : guasti) {
			somma += o.getPersone();
		}
		return somma;
	}

}
