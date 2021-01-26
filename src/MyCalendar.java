import java.util.Scanner;

public class MyCalendar {
	public static void main(String[] args) {
		Scanner input = new Scanner (System.in);
		
		//Stage 1
		System.out.printf("Enter an integer between 1780 and 2040 to print a calendar of that year: ");
		int year = input.nextInt();
		int leapyear = 0;
		while (year > 2040 || year < 1780) {
			System.out.print("Incorrect year. Please enter an integer between 1780 and 2040: ");
			year = input.nextInt();
		}
		if (year % 4 == 0) {
			if (year % 100 != 0) {
				leapyear++;
			}
			else if (year % 400 == 0) {
				leapyear++;
			}
		}
		
		//Stage 2
		int floor1 = Math.floorMod(year, 100);
		int floor2 = Math.floorDiv(floor1 - 1, 4);
		int floor3 = Math.floorDiv(year, 400);
		int floor4 = Math.floorDiv(year, 100);
		int firstday = 28 + (year % 100) + floor2 + floor3 - (2 * floor4);
		firstday = Math.floorMod(firstday, 7);
		
		//Stage 3
		String[] month = new String[] {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
		int daysinmonth;
		for (int i = 0; i < month.length; i++) {
			
			//Stage 3.1
			System.out.printf("-------------------------------\n");
			System.out.printf("\t%9s %d\n", month[i], year);
			switch (i) {
			case 0: daysinmonth = 31; break;
			case 1: daysinmonth = 28; break;
			case 2: daysinmonth = 31; break;
			case 3: daysinmonth = 30; break;
			case 4: daysinmonth = 31; break;
			case 5: daysinmonth = 30; break;
			case 6: daysinmonth = 31; break;
			case 7: daysinmonth = 31; break;
			case 8: daysinmonth = 30; break;
			case 9: daysinmonth = 31; break;
			case 10: daysinmonth = 30; break;
			case 11: daysinmonth = 31; break;
			default: daysinmonth = 0;
			}
			if (i == 1 && leapyear == 1) {
				daysinmonth = 29;
			}
			
			//Stage 3.2
			System.out.printf("  Sun Mon Tue Wed Thu Fri Sat\n ");
			
			//Stage 3.3
			int[] day = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31};
			int dayofweek = 0;
			for (int j = 0; j < firstday; j++) {
				System.out.printf("    ");
				dayofweek++;
			}
			for (int j = 0; j < daysinmonth; j++) {
				System.out.printf(" %3d", day[j]);
				dayofweek++;
				if (dayofweek % 7 == 0) {
					System.out.printf("\n ");
					dayofweek = 0;
				}	
			}
			firstday = dayofweek;
			while (dayofweek % 7 != 0) {
				System.out.printf("    ");
				dayofweek++;
			}
			System.out.printf("\n ");
		}
		System.out.printf("-------------------------------");
		input.close();
	}
}