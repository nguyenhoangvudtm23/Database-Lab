package Application;
import java.sql.SQLException;

import Execution.Installation;
import Execution.PlaceOrder;
import Scenario.Starter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
public class Controller {
	@FXML
	private TextField Name, Address, PhoneNumber, Email;
	public void submitCustomer(ActionEvent event) throws ClassNotFoundException, SQLException
	{
		Starter.starting();
		String name, address, phoneNumber, email;
		name = Name.getText();
		address = Address.getText();
		phoneNumber = PhoneNumber.getText();
		email = Email.getText();
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("DONE");
		
		if (PlaceOrder.checkExist(phoneNumber) == 0)
		{
			PlaceOrder.insertCustomer(address, phoneNumber, name, email);
			alert.setContentText("Customer Added!");
		}
		else
		{
			alert.setContentText("This customer has visited before");
		}
		
		alert.show();
	}
	public void createAllTablesButton(ActionEvent event) throws SQLException, ClassNotFoundException
	{
		Starter.starting();
		Installation.createAllTables();
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("DONE");
		alert.setContentText("All tables created!");
		alert.show();
	}
	public void dropAllTablesButton(ActionEvent event) throws SQLException, ClassNotFoundException
	{
		Starter.starting();
		Installation.dropAllTables();
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("DONE");
		alert.setContentText("All tables dropped!");
		alert.show();
	}
}
