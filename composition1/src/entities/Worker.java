package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enums.WorkerLevel;


public class Worker {

	private String name;
	
	private WorkerLevel level;
	
	private Double baseSalary;
	
	private Department department; //composição de objetos
	
	// a lista de contratos vai começar vazia e aumentar de acordo com o preenchimento de N contratos do worker
	private List<HourContract> contracts = new ArrayList<>(); //composição de objetos (lista de contratos) e instanciar a lista com arraylist
	
	public Worker() {
	}

	public Worker(String name, WorkerLevel level, Double baseSalary, Department department) { //construtor não deve conter listas
		this.name = name;
		this.level = level;
		this.baseSalary = baseSalary;
		this.department = department;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WorkerLevel getLevel() {
		return level;
	}

	public void setLevel(WorkerLevel level) {
		this.level = level;
	}

	public Double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(Double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public List<HourContract> getContracts() { //não pode existir setContracts porque não se pode alterar a lista de contratos, só add ou remover
		return contracts;
	}
	
	public void addContract(HourContract contract) {
		contracts.add(contract);
	}
	
	public void removeContract(HourContract contract) {
		contracts.remove(contract);
	}
	
	public double income(int year, int month) { //cálculo do valor total dos contratos + salário base do funcionário, com filtro na lista para ano e mês
		double sum = baseSalary;
		Calendar cal = Calendar.getInstance();
		for (HourContract c : contracts) { //função for each para percorrer a lista e encontrar a data dos contratos
			cal.setTime(c.getDate()); //setou no calendário a data do contrato C
			int c_year = cal.get(Calendar.YEAR);//variável para encontrar o ano desse contrato
			int c_month = 1 + cal.get(Calendar.MONTH);//variável para encontrar o mês desse contrato. Deve-se colocar o +1 porque o mês no Calendar começa no 0
			if (year == c_year && month == c_month) { //comando para comparar o ano e mês da lista de contrato e realizar a operação de soma do salário
				sum += c.totalValue();
			}
		}
		return sum;
	}
}
