package com.exist.empreg;

public class Employee {
	
	private String name;
	private String position;
	private int age;
	private int id;
	private float salary;
	
	public Employee(){
		
	}
	
	public Employee(int id, String name, String position, int age, float salary) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.position = position;
		this.salary = salary;
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public int getId(){
		return this.id;
	}
	
	public void setName(String name){
		this.name = name;		
	}
	
	public String getName(){
		return this.name;
	}
	
	public void setAge(int age){
		this.age = age;
	}
	
	public int getAge(){
		return this.age;
	}
	
	public void setPosition(String position){
		this.position = position;		
	}
	
	public String getPosition(){
		return this.position;
	}
	
	public void setSalary(float salary){
		this.salary = salary;
	}
	
	public float getSalary(){
		return this.salary;
	}
	
	
}