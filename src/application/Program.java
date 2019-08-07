package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Departament;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");

		System.out.print("Enter department's name: ");
		String departamentName = sc.nextLine();
		System.out.println("Dados trabalhador:");
		System.out.println("name :");
		String workerName = sc.nextLine();
		System.out.println("Level :");
		String workerLevel = sc.nextLine();
		System.out.println("Salary :");

		double workerSalary = sc.nextDouble();
		Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), workerSalary,
				new Departament(departamentName));
		System.out.print("Quantos contratos por trabalhador:");
		int cont = sc.nextInt();
		
		for(int i=1; i<=cont; i++) {
			System.out.print("Enter contract "+i+" data :");
			System.out.print("Data dd/mm/yyyy: ");
			Date contracDate = sdf.parse(sc.next());
			System.out.print("Value per hour:");
			double valuePerHour = sc.nextDouble();
			System.out.print("Duration (Hours):");
			int hours = sc.nextInt();
			HourContract contract = new HourContract(contracDate, valuePerHour, hours);
			worker.addContract(contract);
		}
		System.out.println();
		System.out.print("Entra com mes e ano PARA CALCULAR SALARIO (MM/YYYY)");
		String monthAndYear = sc.next();
		int month = Integer.parseInt(monthAndYear.substring(0,2));
		int year = Integer.parseInt(monthAndYear.substring(3));
		System.out.print("Name: " + worker.getName());
		System.out.print("Departament: " + worker.getDepartament().getName());
		System.out.print("Income for " + monthAndYear + " : "+String.format("%.2f",worker.income(year, month)));
		
		
		
		sc.close();
	}

}
