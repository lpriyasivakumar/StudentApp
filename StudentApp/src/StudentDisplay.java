import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentDisplay {

	public static void main(String[] args) {
		// Import scanner
		Scanner sc = new Scanner(System.in);

		ArrayList<Student> students = constructStudents();

		// Declare variables		
		String name = "";		
		int index = 0;

		// Print title & ask for Student number
		System.out.println("Welcome to Java Class.");
		System.out.println("Which student would you like to learn more about?");

		// While loop to accept student number and display information
		while (true) {
			// try block to throw exception
			try {
				System.out.println("Enter number 1 - 5:");
				index = sc.nextInt();
				sc.nextLine();
				name = students.get(index - 1).getName();
				System.out.println("Student " + index + " is " + name);

				System.out.println("What would you like to know about " + name);

				// do while to display user prompt once
				// check if user wants more info at the bottom condition
				displayAdditionalInfo(students, sc, index);
				break;// break the loop after user says no

			}
			// catch array index out of bounds exception when student number is wrong
			catch (IndexOutOfBoundsException e) {
				System.out
						.println("That student does not exist: Please try again: ");
				continue;
			}	
			//Catches the wrong input from sc.nextInt() for student number
			catch (InputMismatchException e) {
				System.out.println("Invalid Integer:");
				continue;
			}

		}
		sc.close();// closes the scanner

	}

	private static ArrayList<Student> constructStudents() {
		// Create array list of student objects
		ArrayList<Student> students = new ArrayList<Student>();
		// Add each student to array list
		students.add(new Student("Kim", "Ferndale", 25, 3.7));
		students.add(new Student("John", "Birmigham", 19, 4.0));
		students.add(new Student("Ben", "Detroit", 22, 3.5));
		students.add(new Student("Jake", "Troy", 18, 4.0));
		students.add(new Student("Luke", "Flint", 22, 3.9));
		return students;
	}

	private static void displayAdditionalInfo(ArrayList<Student> students,
			Scanner sc, int index) {
		String choice= "";
		String userInput;
		do {
			try {
				System.out.println("Enter age/ gpa/town");
				userInput = sc.next();
				validateUserInput(userInput);

				getInfo(userInput, students.get(index - 1));
				choice = Validator.getChoice(sc,
						"Do you want more information? (y/n) ");
			} 
			// catch illegal argument exception
			catch (IllegalArgumentException e) {
				System.out
						.println("That data does not exist: Enter age/ gpa/town: ");
				continue;
			}

		} while (choice.equalsIgnoreCase("y"));
	}

	private static void validateUserInput(String userInput) {
		// check what the user inputs and throw exception for
		// invalid input
		if ((!userInput.equalsIgnoreCase("age"))
				&& (!userInput.equalsIgnoreCase("gpa"))
				&& (!userInput.equalsIgnoreCase("town"))) {
			throw new IllegalArgumentException();
		}
	}

	// Method returns information about student based on user input
	public static void getInfo(String a, Student s) {
		if (a.equalsIgnoreCase("age")) {
			System.out
					.println(s.getName() + " is " + s.getAge() + " years old");
		} else if (a.equalsIgnoreCase("gpa")) {
			System.out.println(s.getName() + "s Gpa is " + s.getGpa());
		} else {
			System.out.println(s.getName() + " lives in " + s.getTown());
		}
	}
}
