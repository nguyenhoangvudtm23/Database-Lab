package DatabaseLab;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.util.Callback;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CreateOrderController implements Initializable {
	static class XCell extends ListCell<String>{
		HBox hbox = new HBox();
		Label label = new Label(" 0 ");
		Pane pane = new Pane();
		String lastItem;
		Button addbutton = new Button("(+)");
        Label quantity = new Label(" 0 ");
        Button subbutton = new Button("(-)");
        int quant = 0;
        
		public XCell() {
            super();
            hbox.getChildren().addAll(label, pane, addbutton, quantity, subbutton);
            HBox.setHgrow(pane, Priority.ALWAYS);
            addbutton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    quant ++;
                    quantity.setText(" " + Integer.toString(quant) + " ");
                }
            });
            subbutton.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					// TODO Auto-generated method stub
					if(quant == 0) {
						JOptionPane.showMessageDialog(null, "Cant less than 0");
					}
					else {
						quant --;
						quantity.setText(" " + Integer.toString(quant) + " ");
					}
				}
            	
            });
        }
		@Override
        protected void updateItem(String item, boolean empty) {
            super.updateItem(item, empty);
            setText(null);  // No text in label of super class
            if (empty) {
                lastItem = null;
                setGraphic(null);
            } else {
                lastItem = item;
                label.setText(item!=null ? item : "<null>");
                setGraphic(hbox);
            }
        }
		
	}
	private Stage stage;
	private Scene scene;
	private Parent root;
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
	@FXML
	private Button BackMainButton;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
        ObservableList<String> list = FXCollections.observableArrayList(
                "Item 1", "Item 2", "Item 3", "Item 4");
        listitemView.setItems(list);
        listitemView.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {
            @Override
            public ListCell<String> call(ListView<String> param) {
                return new XCell();
            }
        });
        
		
	}
	public void SwitchMainMenu(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
		stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
}	
