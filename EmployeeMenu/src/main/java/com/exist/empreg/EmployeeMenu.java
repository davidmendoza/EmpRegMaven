package com.exist.empreg;

import java.util.Scanner;
import java.io.IOException;

public class EmployeeMenu {
	
	public void start() throws IOException{
		
		int choice;
		Scanner sc = new Scanner(System.in);
		EmployeeLogic empLogic = new EmployeeLogic();

		do {
			
			System.out.println("\n[1] Add New Employee");
			System.out.println("[2] View All Employees");
			System.out.println("[3] Update Employee Details");
			System.out.println("[4] Search Employee");
			System.out.println("[5] Delete Employee");
			System.out.println("[6] Load Employee Data From File");
			System.out.println("[7] Write Current Record To File");
			System.out.println("[0] Exit Program");
			System.out.print("--> ");
			
			while (!sc.hasNextInt()){
				System.out.print("Please enter a valid number --> ");
				sc.next();
			}
			
			choice = sc.nextInt();
			
			switch(choice){
				
				case 1:
					empLogic.addEmp();
					break;
					
				case 2:
					empLogic.viewEmp();
					break;
					
				case 3:
					empLogic.updEmp();
					break;
					
				case 4:
					empLogic.searchEmp();
					break;
					
				case 5:
					empLogic.delEmp();
					break;
					
				case 6:
					empLogic.readFile();
					break;
					
				case 7:
					empLogic.writeFile();
					break;
			}
			
		} while (choice != 0);
	}
	
}