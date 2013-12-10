package com.exist.empreg;

import java.util.Comparator;

public class IdComparator implements Comparator<Employee> {
	
	public IdComparator(){
		
	}
	
	@Override
	public int compare(Employee a, Employee b){
		return a.getId() - b.getId();
	}
}