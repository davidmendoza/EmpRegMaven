package com.exist.empreg;

import java.io.IOException;
public class App {
    public static void main( String[] args ) throws IOException {
        System.out.println( "\nEmployee Registration 2" );
        EmployeeMenu start = new EmployeeMenu();
        start.start();
    }
}
