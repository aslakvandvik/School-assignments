package no.uib.this OOP course.calculator;

import no.uib.this OOP course.calculator.gui.CalculatorGUI;

public class Main {

	public static void main(String[] args) {
		Calculator calculator = new Calculator();
		new CalculatorGUI(calculator);
	}

}
