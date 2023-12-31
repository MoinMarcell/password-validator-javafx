package de.neuefische.passwordvalidatorjavafx;

import java.security.SecureRandom;

public class PasswordValidation {

	private PasswordValidation() {
	}

	private static final String[] BAD_PASSWORDS = {
			"password",
			"123456",
			"12345678",
			"qwerty",
			"abc123",
			"monkey",
			"letmein",
			"dragon",
			"111111",
			"baseball",
			"iloveyou",
			"trustno1",
			"1234567"
	};

	public static boolean hasMoreThanSixCharacters(String password) {
		return password.length() > 6;
	}

	public static boolean hasNumber(String password) {
		return password.matches(".*\\d.*");
	}

	public static boolean hasLowerAndUpperCase(String password) {
		return password.matches(".*[a-z].*") && password.matches(".*[A-Z].*");
	}

	public static boolean isBadPassword(String password) {
		for (String p : BAD_PASSWORDS) {
			if (p.equalsIgnoreCase(password)) {
				return true;
			}
		}
		return false;
	}

	public static boolean hasSpecialCharacter(String password) {
		return password.matches(".*[!@#$%^&*()_+].*");
	}

	public static boolean isValidPassword(String password) {
		return hasMoreThanSixCharacters(password) && hasNumber(password) && hasLowerAndUpperCase(password) && !isBadPassword(password) && hasSpecialCharacter(password);
	}

	public static String generateRandomValidPassword() {
		String uppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String lowercase = "abcdefghijklmnopqrstuvwxyz";
		String numbers = "0123456789";
		String specialChars = "!@#$%^&*()_+";

		String allChars = uppercase + lowercase + numbers + specialChars;
		StringBuilder password = new StringBuilder();

		SecureRandom random = new SecureRandom();

		password.append(uppercase.charAt(random.nextInt(uppercase.length())));
		password.append(lowercase.charAt(random.nextInt(lowercase.length())));
		password.append(numbers.charAt(random.nextInt(numbers.length())));
		password.append(specialChars.charAt(random.nextInt(specialChars.length())));

		for (int i = 4; i < 12; i++) {
			password.append(allChars.charAt(random.nextInt(allChars.length())));
		}

		String shuffledPassword = shuffleString(password.toString());

		while (!isValidPassword(shuffledPassword)) {
			shuffledPassword = shuffleString(password.toString());
		}

		return shuffledPassword;
	}

	private static String shuffleString(String input) {
		char[] characters = input.toCharArray();
		SecureRandom random = new SecureRandom();

		for (int i = characters.length - 1; i > 0; i--) {
			int index = random.nextInt(i + 1);

			char temp = characters[i];
			characters[i] = characters[index];
			characters[index] = temp;
		}

		return new String(characters);
	}

}
