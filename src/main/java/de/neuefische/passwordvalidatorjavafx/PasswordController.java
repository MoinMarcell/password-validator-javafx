package de.neuefische.passwordvalidatorjavafx;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class PasswordController {
	@FXML
	private Label passwordLabel;
	@FXML
	private TextField passwordTextField;

	private final PasswordValidation passwordValidation = new PasswordValidation();

	@FXML
	protected void onGeneratePasswordButtonClick() {
		passwordTextField.setText(passwordValidation.generateRandomValidPassword());
	}

	@FXML
	protected void onCheckPasswordButtonClick() {
		String password = passwordTextField.getText();
		passwordLabel.setText(passwordValidation.isValidPassword(password) ? "Password is valid" : "Password is invalid");
	}
}