package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Address;
import entities.Department;
import entities.Employee;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Nome do departamento: ");
		String departmentName = sc.nextLine();
		System.out.print("Dia do pagamento: ");
		int payDay = sc.nextInt();
		sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("Telefone: ");
		String phone = sc.nextLine();
		
		Address address = new Address(email, phone);
		Department dept = new Department(departmentName, payDay, address);
		
		System.out.print("Quantos funcionários tem o departamento? ");
		int n = sc.nextInt();
		
		for (int i = 1; i <= n; i++) {
			sc.nextLine();
			System.out.printf("Dados do funcionário %d:%n", i);
			System.out.print("Nome: ");
			String empName = sc.nextLine();
			System.out.print("Salário: ");
			double salary = sc.nextDouble();
			Employee emp = new Employee(empName, salary);
			dept.addEmployee(emp);
		}
		
		
		showReport(dept);
		
		sc.close();

	}
	
	public static void showReport(Department dept) {
		System.out.println();
		System.out.println("FOLHA DE PAGAMENTO:");
		System.out.printf("Departamento %s = R$ %.2f%n", dept.getName(), dept.payRoll());
		System.out.printf("Pagamento realizado no dia %d%n", dept.getPayDay());
		System.out.println("Funcionários:");
		
		for (Employee emp : dept.getEmployees()) {
			System.out.printf("%s%n", emp.getName());
		}
		
		System.out.printf("Para dúvidas favor entrar em contato: %s", dept.getAddress().getEmail());
	}

}
