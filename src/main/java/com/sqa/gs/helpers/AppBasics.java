/**
 * File Name: AppBasics.java<br>
 * GS, Sheeba<br>
 * Created: Oct 6, 2017
 */
package com.sqa.gs.helpers;

import java.util.*;

import com.sqa.gs.helpers.exceptions.*;

/**
 * AppBasics //ADDD (description of class)
 * <p>
 * //ADDD (description of core fields)
 * <p>
 * //ADDD (description of core methods)
 *
 * @author GS, Sheeba
 * @version 1.0.0
 * @since 1.0
 */
public class AppBasics {

	private static Scanner scanner = new Scanner(System.in);

	public static void farewellUser(String userName) {
		System.out.println("Thank you " + userName + " for using our application.");
		System.out.println("Have a nice day!");
	}

	/**
	 * Generic method to greet the user and request their name. Name is being
	 * returned to you should store it in a variable.
	 *
	 * @param appName
	 *            The name of the application you created.
	 * @return The name of the user
	 */
	public static String greetUserAndGetName(String appName) {
		// Greet the user using a system out call
		System.out.println("Welcome to the " + appName + " Application.");
		// Ask the user for their name and store in a local scope String
		// variable
		System.out.print("Can I get your name? ");
		return scanner.nextLine();
	}

	public static void greetUserAndIntroTest(String appName, String testName) {
		// Greet the user using a system out call
		System.out.println("Welcome to the " + appName + " Application.");
		// Ask the user for their name and store in a local scope String
		// variable
		System.out.println("\\-------------------------------------------------------------------\\");
		System.out.println("You are running the following tests for " + testName);
		System.out.println("\\-------------------------------------------------------------------\\\n");
	}

	public static boolean requestBoolean(String question) {
		String input;
		boolean isValid = false;
		boolean response = true;
		while (!isValid) {
			System.out.print(question + " (Yes/No)");
			input = scanner.nextLine();
			if (input.trim().equalsIgnoreCase("yes")) {
				isValid = true;
				response = true;
			} else if (input.trim().equalsIgnoreCase("no")) {
				isValid = true;
				response = false;
			} else {
				System.out.println("You did not respond to the question in the correct form: (Yes/No)");
			}
		}
		return response;
	}

	public static byte requestByte(String question) {
		byte num = 0;
		String input;
		boolean isValid = false;
		while (!isValid) {
			System.out.print(question + " ");
			input = scanner.nextLine();
			try {
				num = Byte.parseByte(input);
				isValid = true;
			} catch (NumberFormatException e) {
				System.out.println("You did not supply a valid number [" + input + "]. please provide only digits.");
			}
		}
		return num;
	}

	public static char requestChar(String question) {
		System.out.print(question + " ");
		return scanner.nextLine().charAt(0);
	}

	public static double requestDouble(String question) {
		double num = 0;
		String input;
		boolean isValid = false;
		while (!isValid) {
			System.out.print(question + " ");
			input = scanner.nextLine();
			try {
				num = Double.parseDouble(input);
				isValid = true;
			} catch (NumberFormatException e) {
				System.out.println("You did not supply a valid number [" + input + "]. please provide only digits.");
			}
		}
		return num;
	}

	public static float requestFloat(String question) {
		float num = 0;
		String input;
		boolean isValid = false;
		while (!isValid) {
			System.out.print(question + " ");
			input = scanner.nextLine();
			try {
				num = Float.parseFloat(input);
				isValid = true;
			} catch (NumberFormatException e) {
				System.out.println("You did not supply a valid number [" + input + "]. please provide only digits.");
			}
		}
		return num;
	}

	public static int requestInt(String question) {
		int num = 0;
		String input;
		boolean isValid = false;
		while (!isValid) {
			System.out.print(question + " ");
			input = scanner.nextLine();
			try {
				num = Integer.parseInt(input);
				isValid = true;
			} catch (NumberFormatException e) {
				System.out.println("You did not supply a valid number [" + input + "]. please provide only digits.");
			}
		}
		return num;
	}

	public static int requestInt(String question, int min, int max) {
		int num = 0;
		String input;
		boolean isValid = false;
		while (!isValid) {
			System.out.print(question + " ");
			input = scanner.nextLine();
			try {
				num = Integer.parseInt(input);
				if (num > max) {
					throw new RequestNumberOverMaxException();
				} else if (num < min) {
					throw new RequestNumberUnderMinException();
				}
				isValid = true;
			} catch (NumberFormatException e) {
				System.out.println("You did not supply a valid number [" + input + "]. please provide only digits.");
			} catch (RequestNumberOverMaxException e) {
				System.out.println("You have exceeded the max value of " + max + " [" + input
						+ "]. Please provide a number within range.");
			} catch (RequestNumberUnderMinException e) {
				System.out.println("You have not reached the min value of " + min + " [" + input
						+ "]. Please provide a number within range.");
			}
		}
		return num;
	}

	public static int requestInt(String question, int min, int max, String errorMessage) {
		int num = 0;
		String input;
		boolean isValid = false;
		while (!isValid) {
			System.out.print(question + " ");
			input = scanner.nextLine();
			try {
				num = Integer.parseInt(input);
				if (num > max) {
					throw new RequestNumberOverMaxException();
				}
				if (num < min) {
					throw new RequestNumberUnderMinException();
				}
				isValid = true;
			} catch (NumberFormatException e) {
				System.out.println("You did not supply a valid number [" + input + "]. please provide only digits.");
			} catch (RequestNumberUnderMinException | RequestNumberOverMaxException e) {
				System.out.println(errorMessage);
			}
		}
		return num;
	}

	public static long requestLong(String question) {
		long num = 0;
		String input;
		boolean isValid = false;
		while (!isValid) {
			System.out.print(question + " ");
			input = scanner.nextLine();
			try {
				num = Long.parseLong(input);
				isValid = true;
			} catch (NumberFormatException e) {
				System.out.println("You did not supply a valid number [" + input + "]. please provide only digits.");
			}
		}
		return num;
	}

	public static short requestShort(String question) {
		short num = 0;
		String input;
		boolean isValid = false;
		while (!isValid) {
			System.out.print(question + " ");
			input = scanner.nextLine();
			try {
				num = Short.parseShort(input);
				isValid = true;
			} catch (NumberFormatException e) {
				System.out.println("You did not supply a valid number [" + input + "]. please provide only digits.");
			}
		}
		return num;
	}

	public static String requestString(String question) {
		System.out.print(question + " ");
		return scanner.nextLine();
	}
}
