package model.services;

public class BrazilTaxService implements TaxService { //classe para calcular o imposto no Brasil, implementada em TaxService
	
	public double tax(double amount) {
		if (amount <= 100.0) {
			return amount * 0.2;
		}
		else {
			return amount * 0.15;
		}
	}

}
