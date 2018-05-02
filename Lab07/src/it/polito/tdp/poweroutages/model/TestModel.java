package it.polito.tdp.poweroutages.model;

public class TestModel {

	public static void main(String[] args) {

		Model model = new Model();
		// System.out.println(model.getNercList());

		for (Nerc n : model.getNercList()) {
			for (Outages o : model.testpodao(n)) {
				o.toString();
			}
		}
	}
}
