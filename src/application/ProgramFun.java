package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entites.Funcionario;

public class ProgramFun {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<Funcionario> list = new ArrayList<>();

		System.out.print("how many employees will be registered? ");

		int N = sc.nextInt();

		for (int i = 1; i < N; i++) {
			System.out.println();
			System.out.println("Employee #" + i + ": ");

			System.out.println("id: ");
			Integer id = sc.nextInt();

			System.out.println("nome: ");
			sc.nextLine();
			String nome = sc.nextLine();

			System.out.println("salario: ");
			Double salario = sc.nextDouble();

			Funcionario fun = new Funcionario(id, nome, salario);

			list.add(fun);
		}

		System.out.println("Enter the employee id that will have salary increase: ");
		Integer verSalario = sc.nextInt();
		Integer pos = position (list, verSalario);
			if (pos == null) {
				System.out.println("this id does not Exist! ");
			}
				
				else {
					System.out.println("Enter the percentage: ");
					double porcentagem = sc.nextDouble();
					list.get(pos).aumentarsalario(porcentagem);
				}
			System.out.println();
			System.out.println("List employees: ");
			for (Funcionario fun : list) {
				System.out.println(fun);
			}
			

				sc.close();
	}
	
	public static Integer position (List <Funcionario> list, int id) {
		for (int i=0; i<list.size(); i++) {
			if (list.get(i).getId() == id ) {
				return i;
			}
		}
		return -1;
	}
}

/*
 * 
 * List<Funcionario> list = new ArrayList<>();
 * 
 * // PART 1 - READING DATA:
 * 
 * System.out.print("How many employees will be registered? "); int n =
 * sc.nextInt();
 * 
 * for (int i = 1; i <= n; i++) { System.out.println();
 * System.out.println("Employee #" + i + ": ");
 * 
 * System.out.print("Id: "); int id = sc.nextInt(); while (hasId(list, id)) {
 * System.out.print("Id already taken. Try again: "); id = sc.nextInt(); }
 * 
 * System.out.print("Name: "); sc.nextLine(); String name = sc.nextLine();
 * System.out.print("Salary: "); double salary = sc.nextDouble(); list.add(new
 * Employee(id, name, salary)); }
 * 
 * // PART 2 - UPDATING SALARY OF GIVEN EMPLOYEE:
 * 
 * System.out.println();
 * System.out.print("Enter the employee id that will have salary increase: ");
 * int id = sc.nextInt(); Employee emp = list.stream().filter(x -> x.getId() ==
 * id).findFirst().orElse(null); if (emp == null) {
 * System.out.println("This id does not exist!"); } else {
 * System.out.print("Enter the percentage: "); double percentage =
 * sc.nextDouble(); emp.increaseSalary(percentage); }
 * 
 * // PART 3 - LISTING EMPLOYEES:
 * 
 * System.out.println(); System.out.println("List of employees:"); for (Employee
 * obj : list) { System.out.println(obj); }
 * 
 * sc.close(); }
 * 
 * public static boolean hasId(List<Employee> list, int id) { Employee emp =
 * list.stream().filter(x -> x.getId() == id).findFirst().orElse(null); return
 * emp != null; } }
 */
