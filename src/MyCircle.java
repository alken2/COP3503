import java.util.Scanner;

public class MyCircle {

	public static void main(String[] args) {
		Scanner input = new Scanner (System.in);

        System.out.printf("Enter the radius of your circle: ");
        double radius = input.nextDouble();
        
        System.out.printf("Radius: %10.2f\n", radius);
        System.out.printf("Area: %10.2f\n", 3.14159 * radius * radius);
        System.out.printf("Circumference: %10.2f\n", 3.14159 * radius * 2);

        input.close();

	}

}
