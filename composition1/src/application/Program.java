package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		 System.out.print("Enter department's name: ");
		 String departmentName = sc.nextLine();
		 System.out.println("Enter worker data: ");
		 System.out.print("Name: ");
		 String workerName = sc.nextLine();
		 System.out.print("Level: ");
		 String workerLevel = sc.nextLine();
		 System.out.print("Base salary: ");
		 double baseSalary = sc.nextDouble();
		 
		 //instanciou um novo objeto do tipo Worker, com os dados digitados e associado a esse objeto terá um outro objeto do tipo Department com o nome digitado 
		 Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary, new Department(departmentName));
		 
		 System.out.print("How many contracts to this worker? "); //leitura n de quantos contratos
		 int n = sc.nextInt();
		 
		 for (int i=1; i<=n; i++) { //construção dos contratos 
		 System.out.println("Enter contract #" + i + " data: ");
		 System.out.print("Date (DD/MM/YYYY): ");
		 Date dateContract = sdf.parse(sc.next());
		 System.out.print("Value per hour: ");
		 double valuePerHour = sc.nextDouble();
		 System.out.print("Duration (hours): ");
		 int hours = sc.nextInt();
		 
		 HourContract contract = new HourContract(dateContract, valuePerHour, hours);//instanciando o contrato
		 worker.addContract(contract); //contrato sendo associado com o trabalhador
		 }
		 
		 System.out.println();
		 System.out.print("Enter month and year to calculate income(MM/YYYY): "); //mês e ano para calcular o income
		 String monthAndYear = sc.next();
		 int month = Integer.parseInt(monthAndYear.substring(0, 2)); //recortar o String em substring para coletar os dois digitos do mês digitado
		 int year = Integer.parseInt(monthAndYear.substring(3)); //recortar o String em substring para coletar os 4 digitos do ano digitado

		 System.out.println("Name: " + worker.getName()); //puxar nome do worker
		 System.out.println("Department: " + worker.getDepartment().getName()); //puxar nome do departamento que é um objeto instanciado da composição worker
		 System.out.println("Income for " + monthAndYear + ": " + String.format("%.2f", worker.income(year, month))); //puxar cálculo do salário baseado no mês e ano

		 sc.close();
		}
	}