package FracCalc;

import java.util.Scanner;

public class FractionCalculator {
	public static void main(String[] args) {
		System.out.println(
				"THIS PROGRAM IS A FRAC CALCULATOR BY OHAD \nit will add subtract, multiply, and divide fractions until you type Q to quit \nPlease enter your fractions the form a/b where a and b are integers");
		System.out.println("---------------------------------------------------------");
		System.out.println("please enter an operation (+, -, /, *, = or Q to quit)");
		Scanner scanner = new Scanner(System.in);
		String op = scanner.next();
		if (op.contains("Q") || op.contains("q")) {
			System.out.println("operation ended");
			System.exit(0);
		}

		System.out.print("please enter a FIRST fraction X (a): ");
		int x1 = scanner.nextInt();
		
		System.out.print("please enter a FIRST fraction Y (a): ");
		int y1 = scanner.nextInt();
		
		System.out.print("please enter a SECOND fraction X (b): ");
		int x2 = scanner.nextInt();
		
		System.out.print("please enter a SECOND fraction Y (b): ");
		int y2 = scanner.nextInt();
		
		
		
		Fraction fraction = new Fraction(x1,y1);
		Fraction fraction2 = new Fraction(x2,y2);
		
		if (op.contains("+")) {	//add
			System.out.println("result: " + fraction.add(fraction2));			
			System.out.println("simplified if possible: " +fraction.toLowestTerms(fraction.add(fraction2)));
			
		}else if (op.contains("-")) {	//subtract
			System.out.println("result: " + fraction.subtract(fraction2));
			System.out.println("simplified if possible: " +fraction.toLowestTerms(fraction.subtract(fraction2)));
			
		}else if (op.contains("/")) {	//divide
			System.out.println("result: " + fraction.divide(fraction2));
			System.out.println("simplified if possible: " +fraction.toLowestTerms(fraction.divide(fraction2)));
			
		}else if (op.contains("*")) {	//multiply
			System.out.println("result: " + fraction.multiply(fraction2));
			System.out.println("simplified if possible: " +fraction.toLowestTerms(fraction.multiply(fraction2)));
			
		}else if (op.contains("=")) {	//equals
			fraction = fraction.toLowestTerms(fraction);
			
			fraction2 = fraction2.toLowestTerms(fraction2);
			
			System.out.println("is equal: " + fraction.equals(fraction2));
			
		}

	}
}
