package model.services;

public class PaypalService implements OnlinePaymentService { //classe externa para calcular a taxa de pagamento e juros nas parcelas

	@Override
	public double paymentFee(double amount) {
		return amount * 0.02;
	}

	@Override
	public double interest(double amount, int months) {
		return amount * 0.01 * months;
	}

}
