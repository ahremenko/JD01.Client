package by.htp.ahremenko.utl;

import java.util.Scanner;

public class KeyboardInput {

	public int enterInt ( boolean isPositiveOnly, String messageText ) {
		Scanner sc = new Scanner(System.in);
		int i;
		
		do {
			if (isPositiveOnly) {
				   System.out.print(messageText + " (>0): ");	
			} else {
				   System.out.print(messageText + ": ");
			}
			
			while (!sc.hasNextInt()) {
  			    sc.nextLine();				
				System.out.print("Try again: ");	
			}
			i = sc.nextInt();
			if (i <= 0) { sc.nextLine();}
		} while ( isPositiveOnly && i<=0  );
		return i;
	}
	
	public String enterString ( String messageText ) {
		String enteredString = "";
		Scanner sc = new Scanner(System.in);
		System.out.print(messageText + ": ");
		if (sc.hasNextLine()) {
			enteredString = sc.nextLine();
		}
		return enteredString;
	}

	public Double enterDouble ( String messageText ) {
		Double enteredDouble;
		Scanner sc = new Scanner(System.in);
		System.out.print(messageText + ": ");
		while (!sc.hasNextDouble()) {
			    sc.nextLine();				
			System.out.print("Try again: ");	
		}
		enteredDouble = sc.nextDouble();
		return enteredDouble;
		// 
	}
}
