package com.exist.empreg;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;

public class EmployeeProcess {
	
	Map<Integer, Employee> empMap = new HashMap<Integer, Employee>();
	
	public void add(int id, String name, String position, int age, float salary){
		
		Employee emp = new Employee(id, name, position, age, salary);
		
		empMap.put(id,emp);
		
		System.out.println("\tEmployee "+name+" added");
	}
	
	public void view(int choice){

		List<Employee> list = new ArrayList<Employee>(empMap.values());
		System.out.println("\n\t|ID|-|Name|-|Age|-|Position|-|Salary|\n");
		
		if (choice == 1) {
		Collections.sort(list, new Comparator<Employee>() {
			public int compare(Employee a, Employee b){
				return a.getId() - b.getId();
			};
		});
		} else {
			Collections.sort(list, new Comparator<Employee>() {
				public int compare(Employee a, Employee b) {
					return a.getName().compareToIgnoreCase(b.getName());
				};
			});
		}
		
		for (Employee emp: list){
			System.out.print("\t| "+emp.getId()+" |");
			System.out.print("-| "+emp.getName()+" |");
			System.out.print("-| "+emp.getAge()+" |");
			System.out.print("-| "+emp.getPosition()+" |");
			System.out.print("-| "+emp.getSalary()+" |");
			System.out.println("\n");
		}
		
	}
	
	public void update(int id, String position, int age, float salary){
		
		empMap.get(id).setPosition(position);
		empMap.get(id).setAge(age);
		empMap.get(id).setSalary(salary);
		System.out.println("\tEmployee Details Updated");
		
	}
	
	public boolean searchById(int id){
		
		if (empMap.containsKey(id)){
			
			System.out.println("\n\tFound: ");
			System.out.println("\t|ID|-|Name|-|Age|-|Position|-|Salary|");
			System.out.print("\t| "+empMap.get(id).getId()+" |");
			System.out.print("-| "+empMap.get(id).getName()+" |");
			System.out.print("-| "+empMap.get(id).getAge()+" |");
			System.out.print("-| "+empMap.get(id).getPosition()+" |");
			System.out.print("-| "+empMap.get(id).getSalary()+" |");
			System.out.println("\n");
			return true;
		} 	
		return false;
	}
	
	public boolean searchByName(String name){
		
		List<Employee> list = new ArrayList<Employee>(empMap.values());
		int counter = 0;
		
		for (int i = 0; i < list.size(); i++){
			if (list.get(i).getName().toLowerCase().contains(name)) {
				
				System.out.println("\tMatch: "+(counter+1));
				System.out.println("\t|ID|-|Name|-|Age|-|Position|-|Salary|");	
				System.out.print("\t| "+list.get(i).getId()+" |");
				System.out.print("-| "+list.get(i).getName()+" |");				
				System.out.print("-| "+list.get(i).getAge()+" |");
				System.out.print("-| "+list.get(i).getPosition()+" |");
				System.out.print("-| "+list.get(i).getSalary()+" |");
				System.out.println("\n");
				counter++;
			}
		}
		
		if (counter > 0){
			return true;
		}
		
		return false;

	}
	
	public void deleteAll(){
		empMap.clear();
		System.out.println("\tAll records deleted");
	}
	
	public void deleteById(int id){
		
		if (empMap.containsKey(id)){
			empMap.remove(id);
			System.out.println("\tEmployee deleted");
		} else {
			System.out.println("\tEmployee not found");
		}
	}
	
	public int getMapSize(){
		return this.empMap.size();
	}
	
	public void printFile(String fileName) throws IOException{
		
		try {
			File file  = new File(fileName);
			
			if(!file.exists()){
				
				System.out.println("\tCreating a new file...");
				file.createNewFile();
			}
			
			FileWriter writer = new FileWriter(file, true);
			List<Employee> list = new ArrayList<Employee>(empMap.values());
			
			for (int i = 0; i < list.size(); i++){
				writer.write(list.get(i).getName()+"\t"+list.get(i).getAge()+"\t"
						+list.get(i).getPosition()+"\t"+list.get(i).getSalary()+"\n");
			}
			writer.flush();
			writer.close();
			
			
		} catch(Exception e) {
			System.out.println("\tNo such file or directory");
		}
		
	}	
}