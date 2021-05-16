package DatabaseLab;


import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Controller implements Initializable{
	@FXML
	private ListView<String> listitemView;
	@FXML 
	private AnchorPane BillPane;
	@FXML 
	private Label BuildLabel, ListItemLb;
	@FXML 
	private GridPane pane;
	@FXML	
	private VBox ListBox;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		ObservableList<String> ListItem = FXCollections.<String>observableArrayList("Spring", "Summer", "Fall", "Winter");
//		listitemView.setCellFactory(TextFieldListCell.forListView());
//        listitemView.setEditable(true);//Setting list can be edited
		listitemView.getItems().addAll(ListItem);
		listitemView.getItems().add("1111");
		listitemView.getItems().add("2222");
		listitemView.getItems().add("3333");
//		ListBox.setSpacing(10);
		ListBox.autosize();
//		pane.setHgap(10);
//        pane.setVgap(5); 
		//pane.autosize();
		
	}

}
