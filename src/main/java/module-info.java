module de.neuefische.passwordvalidatorjavafx {
	requires javafx.controls;
	requires javafx.fxml;


	opens de.neuefische.passwordvalidatorjavafx to javafx.fxml;
	exports de.neuefische.passwordvalidatorjavafx;
}