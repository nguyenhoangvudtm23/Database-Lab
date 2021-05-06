package application;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.*;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.converter.NumberStringConverter;
import javafx.scene.control.Slider;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
public class Controller2
{
	@FXML
	private AnchorPane ap;
	@FXML
	private ImageView imageView;
	public void ChooseImage (ActionEvent e)
	{
		Stage stage = (Stage) ap.getScene().getWindow();
		FileChooser fc = new FileChooser();
		fc.setTitle("Pick a file");
		FileChooser.ExtensionFilter imageFilter = new FileChooser.ExtensionFilter("Image Files", "*.jpg", "*.png");
		fc.getExtensionFilters().add(imageFilter);
		File file = fc.showOpenDialog(null);
		if (file != null)
		{
			Image image = new Image(file.toURI().toString());
			imageView.setImage(image);
		}
	}
//	public void Close(ActionEvent event)
//	{
//		Platform.exit();
//		System.exit(0);
//	}
}
