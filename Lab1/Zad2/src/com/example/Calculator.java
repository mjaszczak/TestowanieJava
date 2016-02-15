package com.example;

public class Calculator {
	
	public double add(double n1, double n2){
		return n1 + n2;
	}
	
	public double sub(double n1, double n2){
		return n1 - n2;
	}

	public double multi(double a, double b){
		return a * b;
	}
	public double div(double a, double b){
		return a / b;
	}
	public boolean greater(double a, double b){
		if (a>b) return true;
			else return false;		
	}

}
