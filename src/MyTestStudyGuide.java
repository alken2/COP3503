/*
Classes and UML

1) 9.2 Stock class Create Class/UML

2) 10.1 Time class Create Class/UML

(Date and Random Class)

3) 9.3 Date Class Use

4) 9.4  Random Class

(Double and Integer)

5) Use the Double class to create and Double object of 1,000,000.
   a) Find the max and min value.
   b) Turn the value into an int, long, float, double.
   c) Compare to 2,000,000.
   d) Then send to string.

6) Use the Integer class to create an Integer array of numbers 2,7,8 find if they are prime
   (Objeect Oriented Manneer)


Inheritance and Polymorphism

7) 11.2

(ArrayList)

8) 11.6

9) 11.11

10) 11.12

Exceptions

11) Create a subclass rhat extends the RunTimeException class, called FloatingPointDivisonException.
    This exception will activate if(double/0) occurs. Then create 3 methods to throw and catch
    exceptions NullPointer, ArrayIndexOutOfBounds, and your new exception.

12) 12.7 (only the error

(File PrintWriter Scanner)

13) Write a program to enter numbers 1-10 in a random order to a file. Output the order entred from the file to
    the console and then sort and change the file.

Abstract Classes Interfaces
14) Create an array of type Number with entries 1-5 and 6.0-10.0  Entries 5 Integer and 5 Double then sum the list
    and return the mean.

15)  Create a abstract class Geometric object with data field Dimention.Then create  abstract subclasses 2D with
     data type area and abstract method getArea and 3D object with data type volume and with abstract method
     getVolume. Then under those classes create rectangle and RecPrism Finaly in main construct a Geometric object
     type using the rectangle constructor(4,5) and a RecPrism constructor (1,2,3). Then find the area and volume
     and print the results. To print overide toString.

16) Create a class school with subclass class and student. Student data fields
    should be name and number. Class data types should be student[] and class name.
    Create 3 school classes with names CS2, Comp Structures and CS1. Each should
    have 3 students. Then impliment coneable and clone CS2 to an object named
     CS2Two.

17) 13.6
 */

public class MyTestStudyGuide {

	public static void main(String[] args) {
		System.out.println("Question 1"); //Question 1
		Stock stock1 = new Stock("ORCL", "Oracle Corporation", 34.5, 34.35);
		System.out.println("The current percentage is: " + stock1.getChangePercent() + "%");
		//System.out.println("Question 2"); //Question 2
		//System.out.println("Question 11"); //Question 11
		System.out.println("Question 15"); //Question 15
		Rectangle rectangle1 = new Rectangle(4, 5);
		rectangle1.getArea();
		System.out.println("Rectangle: " + rectangle1);
		RectangularPrism rectangularPrism1 = new RectangularPrism(1, 2, 3);
		rectangularPrism1.getVolume();
		System.out.println("Rectangular Prism: " + rectangularPrism1);
		Sphere sphere1 = new Sphere(6);
		sphere1.getVolume();
		System.out.println("Sphere: " + sphere1);
	}

}

//Question 1 - Stock Class and UML
class Stock {
	private String symbol;
	private String name;
	private double previousClosingPrice;
	private double currentPrice;
	public Stock(String symbol, String name) {
		this.symbol = symbol;
		this.name = name;
	}
	public Stock(String symbol, String name, double previousClosingPrice, double currentPrice) {
		this.symbol = symbol;
		this.name = name;
		this.previousClosingPrice = previousClosingPrice;
		this.currentPrice = currentPrice;
	}
	public double getChangePercent() {
		return (currentPrice / previousClosingPrice) * 100;
	}
	
	public String getSymbol() {
		return symbol;
	}
	
	public String getName() {
		return name;
	}
}

//Question 2 - Time Class and UML

//Question 11 - Exception Handling

//Question 15 - GeometricObject Abstract Class
abstract class GeometricObject {
	protected int dimension;
	
	protected GeometricObject(int dim) {
		this.dimension = dim;
	}
}

abstract class TwoDimensional extends GeometricObject {
	protected double area;
	protected TwoDimensional() {
		super(2);
		this.area = 0;
	}
	protected TwoDimensional(double area) {
		super(2);
		this.area = area;
	}
	public abstract double getArea();
}

abstract class ThreeDimensional extends GeometricObject {
	protected double volume;
	protected ThreeDimensional() {
		super(3);
		this.volume = 0;
	}
	protected ThreeDimensional(double volume) {
		super(3);
		this.volume = volume;
	}
	public abstract double getVolume();
}

class Rectangle extends TwoDimensional {
	private double length;
	private double width;
	public Rectangle() {
		//
	}
	public Rectangle(double length, double width) {
		this.length = length;
		this.width = width;
	}
	public double getArea() {
		return this.area = (this.length * this.width);
	}
	@Override
	public String toString() {
		String s = "";
		s = String.format(this.dimension + " " + this.area + " " + this.length + " " + this.width);
		return s;
	}
}

class RectangularPrism extends ThreeDimensional {
	private double length;
	private double width;
	private double height;
	public RectangularPrism() {
		//
	}
	public RectangularPrism(double length, double width, double height) {
		this.length = length;
		this.width = width;
		this.height = height;
	}
	public double getVolume() {
		return this.volume = (this.length * this.width * this.height);
	}
	@Override
	public String toString() {
		String s = "";
		s = String.format(this.dimension + " " + this.volume + " " + this.length + " " + this.width + " " + this.height);
		return s;
	}
}

class Sphere extends ThreeDimensional {
	private double radius;
	public Sphere() {
		//
	}
	public Sphere(double radius) {
		this.radius = radius;
	}
	public double getVolume() {
		return this.volume = ((4/3) * Math.PI * (this.radius * this.radius * this.radius));
	}
	@Override
	public String toString() {
		String s = "";
		s = String.format(this.dimension + " " + this.volume + " " + this.radius);
		return s;
	}
}