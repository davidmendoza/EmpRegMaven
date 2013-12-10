package com.exist.empreg;

import java.util.Scanner;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class EmployeeLogic {
	
	private String name;
	private String position;
	private int id;
	private int age;
	private float salary;
	
	
	EmployeeProcess empProcess = new EmployeeProcess();
	
	public void addEmp(){
		
		Scanner sc = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
	
		System.out.println("\n\tAdd New Employee");
		System.out.print("\tEnter name --> ");
		name = sc2.nextLine();
		System.out.print("\tEnter age --> ");
		
		while (!sc.hasNextInt()){
			System.out.print("\tPlease enter a valid age --> ");
			sc.next();
		}
		age = sc.nextInt();
		
		System.out.print("\tEnter position --> ");
		position = sc2.nextLine();
		
		System.out.print("\tEnter salary --> ");
		
		while (!sc.hasNextFloat()){
			System.out.print("\tPlease enter a valid salary --> ");
			sc.next();
		}
		salary = sc.nextFloat();
		
		id = this.getIdCtr();	
		
		empProcess.add(id, name, position, age, salary);
	}
	
	public int getIdCtr(){
		return this.id + 1;
	}
	
	public void viewEmp(){
		
		int choice;
		Scanner sc = new Scanner(System.in);
		
		if (empProcess.getMapSize() > 0) {
			System.out.println("\n\tView all Employees");
			System.out.print("\tView by [1]ID [2]Name");
			System.out.print(" --> ");
			
			while (!sc.hasNextInt()){
				System.out.print("\tPlease enter a valid number --> ");
				sc.next();
			}
			choice = sc.nextInt();
			
			switch (choice) {
				case 1:
					empProcess.view(choice);
				break;
				
				case 2:
					empProcess.view(choice);
				break;
				
				default:
				break;
			}
		} else {
			System.out.println("\n\tNo Employees Registered");
		}
	}
	
	public void updEmp(){
		
		Scanner sc = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		
		int idTest;
		int choice;
		boolean found;
		
		if (empProcess.getMapSize() > 0) {
			System.out.println("\n\tUpdate Employee");
			
			System.out.print("\tEnter id --> ");
			
			while (!sc.hasNextInt()){
				System.out.print("\tPlease enter a valid number --> ");
				sc.next();
			}
			
			idTest = sc.nextInt();
			
			found = empProcess.searchById(idTest);
			
				if(found){
					
					System.out.print("\tEnter age --> ");
					
					while (!sc.hasNextInt()){
						System.out.print("\tPlease enter a valid age --> ");
						sc.next();
					}
					
					age = sc.nextInt();
					
					System.out.print("\tEnter position --> ");
					position = sc2.nextLine();
					
					System.out.print("\tEnter salary --> ");
					
					while (!sc.hasNextFloat()){
						System.out.print("\tPlease enter a valid salary --> ");
						sc.next();
					}
					salary = sc.nextFloat();
					
					empProcess.update(id, position, age, salary);
					
				} else {
					System.out.println("\tEmployee not found");
				}
				
		} else {
			System.out.println("\n\tNo Employees Registered");
		}
	}
	
	public void searchEmp(){
		
		Scanner sc = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		
		int choice;
		int idTest;
		boolean found;
		
		if (empProcess.getMapSize() > 0) {
			
			System.out.println("\n\tSearch Employee");
			System.out.print("\tSearch by [1]ID [2]Name");
			System.out.print(" --> ");
			
			while (!sc.hasNextInt()){
				System.out.print("\tPlease enter a valid number --> ");
				sc.next();
			}
			
			choice = sc.nextInt();
			
			switch(choice){
				
				case 1:
					System.out.print("\tEnter id --> ");
					
					while (!sc.hasNextInt()){
						System.out.print("\tPlease enter a valid number --> ");
						sc.next();
					}
					
					idTest = sc.nextInt();
					
					found = empProcess.searchById(idTest);
					
					if(!found){
						System.out.println("\tEmployee not found");
					}
					
				break;
				
				case 2:
					System.out.print("\tEnter name --> ");
					name = sc2.nextLine();
					System.out.print("\n");
					found = empProcess.searchByName(name.toLowerCase());
					
					if(!found){
						System.out.println("\tEmployee not found");
					}
				break;
				
				default:
				break;
			}
		} else {
			System.out.println("\n\tNo Employees Registered");
		}
	}
	
	public void delEmp(){
		
		Scanner sc = new Scanner(System.in);
		
		int idTest;
		int choice;
		
		if (empProcess.getMapSize() > 0) {
			
			System.out.println("\n\tDelete Employee");
			System.out.print("\t[1]Delete by ID [2]Delete All [0]Exit");
			System.out.print(" --> ");
			
			while (!sc.hasNextInt()){
				System.out.print("\tPlease enter a valid number -->");
				sc.next();
			}
			choice = sc.nextInt();
			
			switch(choice){
			case 1:
				System.out.print("\tEnter id --> ");
				
				while (!sc.hasNextInt()){
					System.out.print("\tPlease enter a valid number -->");
					sc.next();
				}
				
				idTest = sc.nextInt();
				
				empProcess.deleteById(idTest);
			break;
			
			case 2:
				empProcess.deleteAll();
			break;
			
			default:
				
			break;
			
			}
			
		} else {
			System.out.println("\n\tNo Employees Registered");
		}
	}
	
	public void writeFile() throws IOException{
		
		Scanner sc2 = new Scanner(System.in);
		String fileName;
		
		if (empProcess.getMapSize() > 0) {
			
			System.out.println("\n\tWrite / Append to File");
			System.out.println("\tEnter the path + filename to save/append the current record: (Ex: /home/dmendoza/David/test.txt)");
			System.out.print("\t--> ");
			fileName = sc2.next();
					
			empProcess.printFile(fileName);
			System.out.println("\tFile successfully created/appended");

		} else {
			System.out.println("\n\tNo Employees Registered");
		}
	}
	
	public void readFile() throws IOException{
		
		Scanner sc = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		String fileName;
		String line = null;
		int choice;
		int i = 0;
		
		System.out.println("\tLoad employee details");
		System.out.println("\tEnter the filename + path to load: (Ex: /home/dmendoza/David/test.txt)");
		System.out.print("\t--> ");
		fileName = sc.next();
		
		try {
			
			BufferedReader bf = new BufferedReader(new FileReader(new File(fileName)));
			List<String> nameL = new ArrayList<String>();
			List<String> ageL = new ArrayList<String>();
			List<String> positionL = new ArrayList<String>();
			List<String> salaryL = new ArrayList<String>();
			
			
			System.out.println("\n\tName-Age-Position-Salary");
			while ((line = bf.readLine())!=null){
				System.out.println("\t"+line);
				String data[] = line.split("\t");
				nameL.add(data[0]);
				ageL.add(data[1]);
				positionL.add(data[2]);
				salaryL.add(data[3]);
			}
			
			System.out.println("\tLoad these contacts? [1]Yes [2]No");
			System.out.print("\t--> ");
			while (!sc.hasNextInt()){
				System.out.print("\tPlease enter a valid number -->");
				sc.next();
			}
			choice = sc.nextInt();
			
			switch(choice){
			
			case 1:
				System.out.println();
				for (i = 0; i < nameL.size(); i++){
					
					id = this.getIdCtr();
					
					empProcess.add(id, nameL.get(i), positionL.get(i), Integer.parseInt(ageL.get(i)), Float.parseFloat(salaryL.get(i)));
				} 
				System.out.println("\tLoaded Contacts to current list!");
				
			break;
			
			default:
				
			break;
			}
			
		} catch(Exception e) {
			System.out.println("\tCould not load the file ");
		}
		
	}
}