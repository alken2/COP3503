/*
 Kenneth Alcineus
 This is a program that solves for the sum, difference, product, and quotient of two fractions provided by user input.
 The purpose of this project is to understand the capabilities of Java classes.
 A class could be defined by contain constructors and methods, and another class could use the said class to create objects.
 */
import java.util.Scanner;

public class TestFractionAlcineus {

	public static void main(String[] args) {
		Scanner input = new Scanner (System.in);
		//Stage 1:
		Fraction myFraction1 = new Fraction();
		//Stage 2:
		System.out.print("Enter the numerator and the denominator for the first fraction:\n");
		int n1 = input.nextInt();
		int d1 = input.nextInt();
		myFraction1 = new Fraction(n1, d1);
		//Stage 3:
		System.out.print("Enter the numerator and the denominator for the second fraction:\n");
		int n2 = input.nextInt();
		int d2 = input.nextInt();
		Fraction myFraction2 = new Fraction(n2, d2);
		//Stage 4:
		System.out.printf("The first fraction is: %s\n", myFraction1.printFraction());
		System.out.printf("The second fraction is: %s\n", myFraction2.printFraction());
		//Stage 5:
		//Stage 6:
		System.out.printf("The sum of both fractions is: %s\n", myFraction1.addFraction(myFraction2));
		//Stage 7:
		System.out.printf("The difference of both fractions is: %s\n", myFraction1.subtractFraction(myFraction2));
		System.out.printf("The product of both fractions is: %s\n", myFraction1.multiplyFraction(myFraction2));
		System.out.printf("The quotient of both fractions is: %s\n", myFraction1.divideFraction(myFraction2));
		input.close();
	}

}


class Fraction {
	private int numerator;
	private int denominator;
	/*
	 This is a constructor that contains the default values of the fraction.
	 When there is no user input, the numerator is 0 and the denominator is 1.
	 */
	public Fraction() {
		numerator = 0;
		denominator = 1;
	}
	/*
	 This is a constructor that contains the specified values of the fraction.
	 When there is a user input, the numerator and denominator is equal to the first and second user input, respectively.
	 */
	public Fraction(int numer, int denom) {
		numerator = numer;
		denominator = denom;
	}
	/*
	 This is a method called an accessor, also known as a getter.
	 The numerator of the fraction object is returned by the getter.
	 */
	public int getNumerator() {
		return numerator;
	}
	/*
	 This is a method called an accessor, also known as a getter.
	 The denominator of the fraction object is returned by the getter.
	 */
	public int getDenominator() {
		return denominator;
	}
	/*
	 This is a method called a mutator, also known as a setter.
	 The numerator of the fraction object is modified by the setter.
	 */
	public void setNumerator(int numer) {
		numerator = numer;
	}
	/*
	 This is a method called a mutator, also known as a setter.
	 The denominator of the fraction object is modified by the setter.
	 */
	public void setDenominator(int denom) {
		denominator = denom;
	}
	/*
	 This is a method that returns a user-defined fraction to be printed.
	 With this method, the resulting string is simply "(numerator)/(denominator)".
	 */
	public String printFraction() {
		return (numerator + "/" + denominator);
	}
	/*
	 This is a method that divides both the numerator and denominator of a fraction by the greatest common denominator.
	 To get the greatest common denominator, another method is called within it.
	 */
	public void reduceFraction() {
		int greatestCD = gcd(numerator, denominator);
		setNumerator(numerator/greatestCD);
		setDenominator(denominator/greatestCD);
	}
	/*
	 This is a method that finds the greatest common denominator of the numerator and denominator of a fraction.
	 This method is static, meaning that it is part of the Fraction class instead of an object.
	 */
	public static int gcd(int numer, int denom) {
		if (denom == 0) {
			return numer;
		}
		else {
			return gcd(denom, numer % denom);
		}
	}
	/*
	 This is a method that adds two different fractions provided by the user input.
	 It is based on the mathematical formula: (a/b) + (c/d) = ((a*d) + (b*c))/(b*d).
	 This method cannot be printed with the printFraction method, so it is given its own return type and statement, which is the resultant sum.
	 */
	public Fraction addFraction(Fraction secondFraction) {
		reduceFraction();
		int numer1 = numerator * secondFraction.denominator;
		int numer2 = denominator * secondFraction.numerator;
		int numer = numer1 + numer2;
		int denom = denominator * secondFraction.denominator;
		Fraction sum = new Fraction(numer, denom);
		return sum;
	}
	/*
	 This is a method that subtracts two different fractions provided by the user input.
	 It is based on the mathematical formula: (a/b) - (c/d) = ((a*d) - (b*c))/(b*d).
	 This method cannot be printed with the printFraction method, so it is given its own return type and statement, which is the resultant difference.
	 */
	public Fraction subtractFraction(Fraction secondFraction) {
		reduceFraction();
		int numer1 = numerator * secondFraction.denominator;
		int numer2 = denominator * secondFraction.numerator;
		int numer = numer1 - numer2;
		int denom = denominator * secondFraction.denominator;
		Fraction difference = new Fraction(numer, denom);
		return difference;
	}
	/*
	 This is a method that multiplies two different fractions provided by the user input.
	 It is based on the mathematical formula: (a/b) * (c/d) = (a*c)/(b*d).
	 This method cannot be printed with the printFraction method, so it is given its own return type and statement, which is the resultant product.
	 */
	public Fraction multiplyFraction(Fraction secondFraction) {
		reduceFraction();
		int numer = numerator * secondFraction.numerator;
		int denom = denominator * secondFraction.denominator;
		Fraction product = new Fraction(numer, denom);
		return product;
	}
	/*
	 This is a method that divides two different fractions provided by the user input.
	 It is based on the mathematical formula: (a/b) / (c/d) = (a*d)/(b*c).
	 This method cannot be printed with the printFraction method, so it is given its own return type and statement, which is the resultant quotient.
	 */
	public Fraction divideFraction(Fraction secondFraction) {
		reduceFraction();
		int numer = numerator * secondFraction.denominator;
		int denom = denominator * secondFraction.numerator;
		Fraction quotient = new Fraction(numer, denom);
		return quotient;
	}
	/*
	 This statement and method overrides the Object.toString() method.
	 This is so the string for fractions can properly be printed, instead of the class name and hexidecimal code.
	 */
	@Override
    public String toString() {
		return (numerator + "/" + denominator);
    }
}
