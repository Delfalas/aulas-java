package model.services;

import java.time.LocalDate;
import model.entities.Contract;
import model.entities.Installment;

public class ContractService {
	
	private OnlinePaymentService onlinePaymentService; //instanciou a classe interface de pagamento online, que está relacionada com Paypal

	public ContractService(OnlinePaymentService onlinePaymentService) {
		super();
		this.onlinePaymentService = onlinePaymentService;
	}

	public void processContract(Contract contract, int months) {	//método para gerar N parcelas	
		
		double basicValue = contract.getTotalValue() / months;
		
		for (int i = 1; i <= months; i++) {
			LocalDate dueDate = contract.getDate().plusMonths(i); //método para adicionar os meses nas parcelas
			
			double interest = onlinePaymentService.interest(basicValue, i); //método para o juros de cada mês
			
			double fee = onlinePaymentService.paymentFee(basicValue + interest); //taxa de pagamento = valor inicial + o juros
			
			double total = basicValue + interest + fee; //total de cada parcela
			
			contract.getInstallments().add(new Installment(dueDate, total)); //adicionando no contrato e lista de parcelas, cada parcela já com seus argumentos
																				// data de cada parcela e valor total de cada parcela
		}
	}

}
