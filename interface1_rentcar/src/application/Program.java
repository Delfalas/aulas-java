package application;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import model.entities.CarRental;
import model.entities.Vehicle;
import model.services.BrazilTaxService;
import model.services.RentalService;

public class Program {

	public static void main(String[] args) {
		
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Entre com os dados do aluguel ");
		System.out.print("Modelo do carro: ");
		String vehicle = sc.nextLine();
		
		System.out.print("Retirada (dd/MM/yyyy HH:mm): ");
		LocalDateTime start = LocalDateTime.parse(sc.nextLine(), fmt);
		System.out.print("Retorno (dd/MM/yyyy HH:mm): ");
		LocalDateTime finish = LocalDateTime.parse(sc.nextLine(), fmt);
		
		CarRental carRental = new CarRental(start, finish, new Vehicle(vehicle)); //instanciado novo objeto carRental com argumentos
		
		System.out.print("Entre com o preço por hora: ");
		double hourPrice = sc.nextDouble();
		System.out.print("Entre com o preço por dia: "); 
		double dayPrice = sc.nextDouble();
		
		RentalService rentalService = new RentalService(hourPrice, dayPrice, new BrazilTaxService()); //instanciado novo objeto rentalService com argumentos
																			//injeção de dependências		
		rentalService.processInvoice(carRental);
		
		System.out.println();
		System.out.println("FATURA: ");
		System.out.println("Pagamento basico: " + String.format("%.2f", carRental.getInvoice().getBasicPayment()));
		System.out.println("Imposto: " + String.format("%.2f",carRental.getInvoice().getTax()));
		System.out.println("Pagamento total: " + String.format("%.2f", carRental.getInvoice().totalPayment()));
		
		sc.close();
	}
}
