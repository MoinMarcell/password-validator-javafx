package de.neuefische.passwordvalidatorjavafx;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordValidationTest {

	@Test
	void expectTrue_whenPasswordHasMoreThanSixCharacters() {
		//GIVEN
		String password = "password";
		//WHEN
		boolean actual = PasswordValidation.hasMoreThanSixCharacters(password);
		//THEN
		assertTrue(actual);
	}

	@Test
	void expectFalse_whenPasswordHasLessThanSixCharacters() {
		//GIVEN
		String password = "pass";
		//WHEN
		boolean actual = PasswordValidation.hasMoreThanSixCharacters(password);
		//THEN
		assertFalse(actual);
	}

	@Test
	void expectTrue_whenPasswordIncludesAtLeastOneNumber() {
		//GIVEN
		String password = "password1";
		//WHEN
		boolean actual = PasswordValidation.hasNumber(password);
		//THEN
		assertTrue(actual);
	}

	@Test
	void expectFalse_whenPasswordDoesNotIncludeAnyNumber() {
		//GIVEN
		String password = "password";
		//WHEN
		boolean actual = PasswordValidation.hasNumber(password);
		//THEN
		assertFalse(actual);
	}

	@Test
	void expectTrue_whenPasswordHasAtLeastOneLowerAndOneUpperCaseCharacter() {
		//GIVEN
		String password = "Password";
		//WHEN
		boolean actual = PasswordValidation.hasLowerAndUpperCase(password);
		//THEN
		assertTrue(actual);
	}

	@Test
	void expectFalse_whenPasswordDoesNotHaveAtLeastOneLowerAndOneUpperCaseCharacter() {
		//GIVEN
		String password = "password";
		//WHEN
		boolean actual = PasswordValidation.hasLowerAndUpperCase(password);
		//THEN
		assertFalse(actual);
	}

	@Test
	void expectTrue_whenPasswordIsBad() {
		//GIVEN
		String password = "password";
		//WHEN
		boolean actual = PasswordValidation.isBadPassword(password);
		//THEN
		assertTrue(actual);
	}

	@Test
	void expectFalse_whenPasswordIsNotBad() {
		//GIVEN
		String password = "Password4325#sd3";
		//WHEN
		boolean actual = PasswordValidation.isBadPassword(password);
		//THEN
		assertFalse(actual);
	}

	@Test
	void expectTrue_whenPasswordHasAtLeastOneSpecialCharacter() {
		//GIVEN
		String password = "Password4325#sd3";
		//WHEN
		boolean actual = PasswordValidation.hasSpecialCharacter(password);
		//THEN
		assertTrue(actual);
	}

	@Test
	void expectFalse_whenPasswordDoesNotHaveAtLeastOneSpecialCharacter() {
		//GIVEN
		String password = "Password4325sd3";
		//WHEN
		boolean actual = PasswordValidation.hasSpecialCharacter(password);
		//THEN
		assertFalse(actual);
	}

	@Test
	void expectTrue_whenPasswordIsValid() {
		//GIVEN
		String password = "Password4325#sd3";
		//WHEN
		boolean actual = PasswordValidation.isValidPassword(password);
		//THEN
		assertTrue(actual);
	}

	@Test
	void expectFalse_whenPasswordIsInvalid() {
		//GIVEN
		String password = "password";
		//WHEN
		boolean actual = PasswordValidation.isValidPassword(password);
		//THEN
		assertFalse(actual);
	}

	@Test
	void expectRandomNotNullPassword_whenGenerateRandomValidPasswordMethodIsCalled() {
		//GIVEN
		//WHEN
		String actual = PasswordValidation.generateRandomValidPassword();
		//THEN
		assertNotNull(actual);
	}
}