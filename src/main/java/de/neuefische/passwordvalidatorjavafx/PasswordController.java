package de.neuefische.passwordvalidatorjavafx;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class PasswordController {
	@FXML
	private Label passwordLabel;
	@FXML
	private TextField passwordTextField;

	@FXML
	protected void onGeneratePasswordButtonClick() {
		passwordTextField.setText(PasswordValidation.generateRandomValidPassword());
	}

	@FXML
	protected void onCheckPasswordButtonClick() {
		String password = passwordTextField.getText();
		passwordLabel.setText(PasswordValidation.isValidPassword(password) ? "Password is valid" : "Password is invalid");
	}
}