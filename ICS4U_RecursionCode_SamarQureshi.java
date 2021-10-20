package com.company.recursion;
import java.util.Scanner;

public class ICS4U_RecursionCode_SamarQureshi {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		boolean flag = true;

		System.out.println("Welcome to the recursion program.\n");
		
		while(flag){ //repeats until the user wants exit
			System.out.println("Select an option from the menu below:" + 
			"\n1: Display consecutive numbers in a right triangle" + 
			"\n2: Determine if a number is divisible by 3" + 
			"\n3: Determine the number of periods and spaces in a string" +
			"\n4: Display a right triangle of astrisks" + 
			"\n5: Exit"); 
			String option = input.nextLine();

			if(option.equals("1")){  
				System.out.println("Enter number of columns: ");
				double width = input.nextDouble(); 
				input.nextLine(); //"eats up" the rest of the line
				while(width<=0 || width%1!=0){ //ensures that the user specified width is a positibe integer
					System.out.println("\nInvalid input! Please enter a positive width that is an integer.\n");
					width = input.nextDouble(); 
					input.nextLine(); //"eats up" the rest of the line
				}
				System.out.println();
				numberedTriangle(width); //displays the right triangle of consecutive integers starting at 1, ending at the width
			}

			else if(option.equals("2")){  //checks if a number is divisible by 3
				System.out.println("Enter number:");
				double num = input.nextDouble(); 
				input.nextLine(); //"eats up" the rest of the line
				System.out.println();
				divisibleBy3(Math.abs(num)); 
			}

			else if(option.equals("3")){ 
				System.out.println("Enter string:");
				String sentence = input.nextLine();
				//displays number of periods and spaces in a string
				System.out.println("\nNumber of periods and spaces: " + periodsAndSpaces(sentence) + "\n"); 

			}
			
			else if(option.equals("4")){ 
				System.out.println("Enter the length of the triangle:");
				double length = input.nextDouble(); 
				input.nextLine();

				while(length<=0 || length%1!=0){ //ensures user specified length is a positive integer
					System.out.println("\nInvalid input! Please enter a positive length that is an integer.\n");
					length = input.nextDouble(); 
					input.nextLine();
				}
				System.out.println();
				asteriskTriangle(length, ""); //displays a right aligned right triangle of asterisks of a user specified length
			}

			else if(option.equals("5")){ //if the user wants to exit the loop
				flag = false;
			}

			else { //in the case where a user does not enter 1,2,3,4 or 5 as an option
				System.out.println("\nThat is not a valid option!\n");
			}

		}

		System.out.println("\nThanks for using the recursion program. See you next time!");
	}

	public static String numberedTriangle(double n) { //option 1
		/*
		*method takes in a double, which is the number of columns and rows, and outputs a string every time the method is run, resulting in
		*a right angled triangle in which each row has consecutive positive integers starting from 1, ending with the width, 
		*each row increases with length
		*
		*/

		if(n == 0){ //base case, in which the specified number of rows/columns has been printed out, and the method needs to stop recursing
			return " ";
		} 

		/*general case, which displays each row by calling on numberedTriangle, 
		*and takes in the width each time, which is consecutively decreasing by 1,
		* allowing each row to consecutively increase
		*/
    	String line = numberedTriangle((int)n - 1); //integer cast bc parameter is initially taken in as a double
    	line = line + (int)n + "\t";
    	System.out.println(line); //prints out the current line, with the addition of the previous line plus n

    	return line;
			
	}

	public static double divisibleBy3(double n){ //option 2
		/*
		*Method takes in a double, and checks if it is divisible by 3 by continually subtracting 3 from it until it reaches 0 or a negative number
		*The absolute value of the double being returned is the remainder 
		*/
		if(n<0){ 
		//base case, allowing the recursion to stop if it reaches a negative number, in which the number cannot be divided by 3
			System.out.println("\nNot divisible by 3.\n");
			return n; //the absolute value of n is the remainder 
		}
		else if(n==0){ 
		//second base case, allowing the recursion to stop if it reaches 0, in which the number can be divide by 3 without remainder
			System.out.println("\nDivisible by 3.\n");
			return 0; //since the remainder is 0
		}
		else{ 
		//general case, where where it keeps subtracting 3 from the initial number until it reaches 0 or a negative number
			return divisibleBy3(n-3);
		}
	}

	public static int periodsAndSpaces(String s){ //option 3
		/*
		*Method takes in a string, and decreases the length of it every time, adding 1 to the return if a period or
		*space is found at each character it recurses through, and finaly returns an integer, which is the collective sum of periods and 
		*spaces in the initial string
		*/
		if(s.length()==0){ 
		//base case, in which the length of the string has decreased to the point where there is no string anymore, and the recursion stops
			return 0;
		}

		else if(s.charAt(0) == ' ' || s.charAt(0) == '.'){ 
		//general case, in which the current character in the string contains a space or a period
			return periodsAndSpaces(s.substring(1)) + 1; 
			/*returns the current string without the first character, shortening it
			*adds 1 to the return each time a period or space is found 
			*/
		}
		else{ 
		/*general case 2, in which the current character does not contain a space or period
		*returns the string without the first character, and continues to recurse through the rest of the indices in the string 
		*/
			return periodsAndSpaces(s.substring(1));
		}
	}

	public static String asteriskTriangle(double n, String s){ //option 4
	/*
	* Method takes in a double, which is the user specified length of the triangle, and a null string, which allows
	*for the 
	*/
		if( n <= 0 ){ //base case
			return "";
		} 

		//general case
    	String line = asteriskTriangle(n - 1, s + " ") + "*";
    	System.out.println(s + line);
    	return line;
	}

	

}
