package FracCalc;

public class Fraction {

	private int numerator, denominator; // two private instance variables to hold the numerator and denominator as ints

	// a two parameter constructor that initializes the numerator and denominator:
	public Fraction(int numerator, int denominator) {

		this.numerator = numerator;
		this.denominator = denominator;

		if (numerator < 0 && denominator < 0) {
			this.numerator = Math.abs(numerator);
			this.denominator = Math.abs(denominator);
		} // if both numbers were negative , make them absolute

		if (numerator > 0 && denominator < 0) {
			this.numerator -= numerator * 2;
			this.denominator = Math.abs(denominator);
		} // If the user enters a negative denominator bump the negative sign to the
			// numerator.

		if (denominator == 0) {
			throw new IllegalArgumentException("Error - denominator cannot be 0");
			// This constructor should throw an IllegalArgumentException if the denominator
			// is zero
		}
	}

	// one parameter constructor that initializes the object equal in value to the
	// integer parameter.
	public Fraction(int numerator) {
		this.denominator = 1;

	}

	// zero parameter constructor that initializes the object to 0, meaning the
	// numerator is 0 and the denominator is 1
	public Fraction() {
		this.numerator = 0;
		this.denominator = 1;

	}

	// exposes the value of the numerator field to the user
	public int getNumerator() {
		return numerator;
	}

	// exposes the value of the denominator field to the user
	public int getDenominator() {
		return denominator;
	}

	// "numerator/denominator", a String representation of the Fraction
	@Override
	public String toString() {
		return numerator + "/" + denominator;
	}

	// the result of numerator / denominator
	public Double toDouble() {
		return (double) (numerator / denominator);
	}

	// returns a new Fraction that is the sum of other and this fractions
	public Fraction add(Fraction other) {

		// Finding gcd of den1 and den2
		int den3 = gcd(this.denominator, other.denominator);

		// Denominator of final fraction obtained
		// finding LCM of den1 and den2
		// LCM * GCD = a * b
		den3 = (this.denominator * other.denominator) / den3;

		// Changing the fractions to have same denominator
		// Numerator of the final fraction obtained
		int num3 = (this.numerator) * (den3 / this.denominator) + (other.numerator) * (den3 / other.denominator);

		return new Fraction(num3, den3);
	}

	// returns a new Fraction that is the difference between the other and this
	// fraction
	public Fraction subtract(Fraction other) {

		// Finding gcd of den1 and den2
		int den3 = gcd(this.denominator, other.denominator);

		// Denominator of final fraction obtained
		// finding LCM of den1 and den2
		// LCM * GCD = a * b
		den3 = (this.denominator * other.denominator) / den3;

		// Changing the fractions to have same denominator
		// Numerator of the final fraction obtained
		int num3 = (this.numerator) * (den3 / this.denominator) - (other.numerator) * (den3 / other.denominator);

		return new Fraction(num3, den3);

	}

	// returns a new Fraction that is the product of the other and this fraction
	public Fraction multiply(Fraction other) {
		return new Fraction(this.numerator * other.numerator, this.denominator * other.denominator);
	}

	// returns a new Fraction that is the division of the other and this fraction,
	// throw an IllegalArgumentException() if the user asks you to divide by 0
	public Fraction divide(Fraction other) {
		if (other.denominator == 0) {
			throw new IllegalArgumentException("Error - denominator cannot be 0");
		}
		return new Fraction(this.numerator * other.denominator, this.denominator * other.numerator);
	}

	// converts the current fraction to the lowest terms

	public Fraction toLowestTerms(Fraction other) {
		{
			int d;
			d = gcd(other.numerator, other.denominator);
			return new Fraction(other.numerator / d, other.denominator / d);
		}
	}

	public boolean equals(Fraction other) {
		
		return (this.numerator == other.numerator) && (this.denominator == other.denominator) ;
	}

	// takes in two ints and determines the greatest common divisor of the two ints,
	// should be a static method
	public static int gcd(int num1, int num2) {

		int factor = num2;
		while (num2 != 0) {
			factor = num2;
			num2 = num1 % num2;
			num1 = factor;
		}
		return num1;
	}

}
