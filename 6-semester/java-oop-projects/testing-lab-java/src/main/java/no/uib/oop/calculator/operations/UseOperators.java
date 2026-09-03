package no.uib.oop.calculator.operations;

public class UseOperators {

	public static void main(String[] args) {
		System.out.println(Math.sqrt(-0.0));
		double a = 0.0;
		double b = -0.0;

		System.out.println(Math.sqrt(a));
		System.out.println(Math.sqrt(b));
		
		System.out.println(a==b);
		System.out.println(Double.toString(a).equals(Double.toString(b)));
	}

}
