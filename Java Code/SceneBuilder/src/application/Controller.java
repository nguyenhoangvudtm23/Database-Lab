package application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class Controller {
	@FXML
	private TextField height;
	public void Submit(ActionEvent event)
	{
		String h = height.getText();
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setContentText("Chieu cao cua ban: " + h + "cm");
		alert.show();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
