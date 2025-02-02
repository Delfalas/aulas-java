package model.services;

public interface OnlinePaymentService { //classe interface para puxar a taxa de pagamento e juros das parcelas
	
	double paymentFee(double amount);
	double interest(double amount, int months);

}
