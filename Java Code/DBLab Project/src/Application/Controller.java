package Application;
import java.sql.SQLException;

import Execution.PlaceOrder;
import Scenario.Tester;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
public class Controller {
	@FXML
	private TextField Name, Address, PhoneNumber, Email;
	public void Submit(ActionEvent event) throws ClassNotFoundException, SQLException
	{
		Tester.starting();
		String name, address, phoneNumber, email;
		name = Name.getText();
		address = Address.getText();
		phoneNumber = PhoneNumber.getText();
		email = Email.getText();
		PlaceOrder.insertCustomer(address, phoneNumber, name, email);
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("DONE");
		alert.setContentText("Customer Added!");
		alert.show();
	}
}
