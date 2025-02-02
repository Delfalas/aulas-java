package model.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Contract {
	
	
	private Integer number; //numero do contrato
	private LocalDate date; //data do contrato
	private Double totalValue; //valor total do contrato
	
	private List<Installment> installments = new ArrayList<>(); //instanciando lista de installments
	
	public Contract() {
	}

	public Contract(Integer number, LocalDate date, Double totalValue) {
		super();
		this.number = number;
		this.date = date;
		this.totalValue = totalValue;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Double getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(Double totalValue) {
		this.totalValue = totalValue;
	}

	public List<Installment> getInstallments() {
		return installments;
	}

	//apagar o setLists, porque você nao altera a lista, só adiciona ou remove itens na lista
}
