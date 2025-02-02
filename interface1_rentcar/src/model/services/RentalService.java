package model.services;

import java.time.Duration;

import model.entities.CarRental;
import model.entities.Invoice;

public class RentalService { //classe para calcular a duração do aluguel e calcular o preço 
	
	private Double pricePerHour;
	private Double pricePerDay;
	
	private TaxService taxService; //instanciou a classe interface de imposto, que está relacionada com BrazilTaxService
	
	//não coloca construtor vazio nesse caso, queremos obrigar a instanciar apenas com os dados digitados

	public RentalService(Double pricePerHour, Double pricePerDay, TaxService taxService) { 
		super();
		this.pricePerHour = pricePerHour;
		this.pricePerDay = pricePerDay;
		this.taxService = taxService;
	}

	public void processInvoice(CarRental carRental) { //método para calcular os atributos do CarRental e atribuir um novo Invoice (fatura)
			
		double minutes = Duration.between(carRental.getStart(), carRental.getFinish()).toMinutes(); //duração entre as datas de aluguel, convertida em minutos
		double hours = minutes / 60.0; //minutos convertido em horas
		
		double basicPayment;
		if (hours <= 12.0) {
			basicPayment = pricePerHour * Math.ceil(hours); //cálculo do preço por horas (fórmula Math.ceil arredonda para cima, se for 4:30 horas, fica 5 horas)
		}
		else {
			basicPayment = pricePerDay * Math.ceil(hours / 24.0); //cálculo do preço por dias (aqui convertemos horas para dias)
		}
		
		double tax = taxService.tax(basicPayment); //instanciação do objeto imposto
		
		carRental.setInvoice(new Invoice(basicPayment, tax)); //instanciação do carRental com novo Invoice(argumentos) 
	}
	
}
