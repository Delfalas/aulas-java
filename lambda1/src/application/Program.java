package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

import entities.Employee;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter full file path: ");
		String path = sc.nextLine();
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))) { //ler o arquivo

			List<Employee> list = new ArrayList<>();
			
			String line = br.readLine();
			while (line != null) {
				String[] fields = line.split(",");
				list.add(new Employee(fields[0], fields[1], Double.parseDouble(fields[2])));
				line = br.readLine();
			}
				
			System.out.print("Enter salary: ");
			double n = sc.nextDouble();
			
			Comparator<String> comp = (s1, s2) -> s1.toUpperCase().compareTo(s2.toUpperCase()); //Comparator String de ordem alfabética
			
			System.out.println("Email of people whose salary is more than " + String.format("%.2f", n) + ":");
			List<String> emails = list.stream()  //criando stream
					.filter(p -> p.getSalary() > n) //filtrando a lista para pegar o email de funcionários com salário maior do que o digitado
					.map(p -> p.getEmail()).sorted(comp) //map para listar os emails e sorted para ordenar 
					.collect(Collectors.toList()); //transformando em lista
			
			emails.forEach(System.out::println); //forEach para printar (Consumer)
			
			System.out.print("Enter the initial letter of the name you want the sum of salarys: "); //usuário escolher a inicial do nome para filtrar
		    char letter = sc.next().toUpperCase().charAt(0);

			double sum = list.stream() //soma dos salários dos funcionários que começam com a letra escolhida
					.filter(p -> p.getName().charAt(0) == letter )
					.map(p -> p.getSalary())
					.reduce(0.0, (x,y) -> x + y); //reduce para a operação de soma dos salários
			
			System.out.print("Sum of salary of people whose name starts with " + letter + ": " + String.format("%.2f", sum));

		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		sc.close();
	}
}
