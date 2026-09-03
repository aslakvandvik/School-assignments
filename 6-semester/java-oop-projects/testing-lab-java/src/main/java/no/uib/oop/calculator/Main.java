package no.uib.oop.calculator;

import no.uib.oop.calculator.gui.CalculatorGUI;

public class Main {

	public static void main(String[] args) {
		Calculator calculator = new Calculator();
		new CalculatorGUI(calculator);
	}

}
