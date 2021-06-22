package Application;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

import Classes.Orders;
import Execution.OrderStatistics;
import Scenario.Starter;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Callback;

public class ShowListOrderController extends MenuController implements Initializable {
	@FXML
	private Button backCreateProductSceneButton;
	private Parent root;
	private Stage stage;
	private Scene scene;
	@FXML
	private TableView<Orders> ListOrderTable;
	@FXML
	private TableColumn<Orders, String> OrderIDColumn;
	@FXML
	private TableColumn<Orders, Integer> CustomerIDColumn;
	@FXML
	private TableColumn<Orders, String> TotalCostColumn;
	@FXML
	private TableColumn<Orders, Double> DateColumn;
	@FXML
	private TableColumn<Orders, String> StatusColumn;
	@FXML 
	private TableColumn<Orders, String> DiscountColumn;
	@FXML 
	private TableColumn<Orders, String> DeleteColumn;
	@FXML
	private TextField filterField;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			Starter.starting();
			Configuration.ListOrder.clear();
			int tmp = 0;
			ResultSet listOr = OrderStatistics.selectAllOrders();
			while (listOr.next())
			{
				tmp++;
//				System.out.println(tmp);
				Orders order = new Orders(listOr.getInt(2), listOr.getInt(3),
						LocalDate.parse(listOr.getString(4)), listOr.getString(5),
						listOr.getDouble(5)
						);
				order.setOrderID(listOr.getInt(1));
				Configuration.ListOrder.add(order);
				
			}
			
		}
		catch (Exception e)
		{
			showAlert("DB Error", "Can't connect to the database");
		}
		// TODO Auto-generated method stub
		CustomerIDColumn.setCellValueFactory(new PropertyValueFactory<>("CustomerID"));
        
        // OrderID Column
        OrderIDColumn.setCellValueFactory(new PropertyValueFactory<>("OrderID"));
		
		// Customer Column
		StatusColumn.setCellValueFactory(new PropertyValueFactory<>("Status"));
		
		// TotalCost Column
		TotalCostColumn.setCellValueFactory(new PropertyValueFactory<>("Totalcost"));
		
		// create date Column
		DateColumn.setCellValueFactory(new PropertyValueFactory<>("CreationDate"));
		
		// Discount column
		DiscountColumn.setCellValueFactory(new PropertyValueFactory<>("Discount"));
		
		// Delete Column
		DeleteColumn.setCellValueFactory(new PropertyValueFactory<>("DUMMY"));
		Callback<TableColumn<Orders, String>, TableCell<Orders, String>> DelCellFactory = 
        		new Callback<TableColumn<Orders,String>, TableCell<Orders,String>>() {

					@Override
					public TableCell<Orders, String> call(TableColumn<Orders, String> param) {
						// TODO Auto-generated method stub
						DelCell cell = new DelCell();
						return cell;
					}
				};
		DeleteColumn.setCellFactory(DelCellFactory);
		
		
//		ListOrderTable.setItems(Configuration.ListOrder);
		FilteredList<Orders> filteredData = new FilteredList<>(Configuration.ListOrder, b -> true);
		filterField.textProperty().addListener((o, oldValue, newValue) -> {
			filteredData.setPredicate(order -> {
				if(newValue == null || newValue.isEmpty()) {
					return true;
				}
				String lowerCaseFilter = newValue.toLowerCase();
				if(String.valueOf(order.getOrderID()).toLowerCase().indexOf(lowerCaseFilter) != - 1) {
					return true;
				}
				else if(String.valueOf(order.getCustomerID()).toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true;
				}
				else if(String.valueOf(order.getStatus()).toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true;
				}
				else if(String.valueOf(order.getDiscount()).toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true;
				}
				else if(String.valueOf(order.getTotalcost()).toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true;
				}
				else if(order.getCreationDate().toString().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true;
				}
				else return false;
			});
		});
		SortedList<Orders> sortedData = new SortedList<>(filteredData);
		sortedData.comparatorProperty().bind(ListOrderTable.comparatorProperty());
		ListOrderTable.setItems(sortedData);
         
	}
	
	static class DelCell extends TableCell<Orders, String>{
		HBox hbox = new HBox();
		Button delbutton = new Button("Del");
		public int quant = 0;
		public DelCell() {
			super();

			delbutton.setMinWidth(USE_COMPUTED_SIZE);
			hbox.getChildren().addAll(delbutton);
			hbox.setAlignment(Pos.CENTER);
			delbutton.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					Orders temp = getTableView().getItems().get(getIndex());
					Configuration.ListOrder.remove(temp);
					try {
						OrderStatistics.deleteOrderWithID(temp.getOrderID());
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					};
					
				}
			});
		}
		@Override
		protected void updateItem(String item, boolean empty) {
			super.updateItem(item, empty);
			setText(null);  // No text in label of super class
			if (empty) {
				setGraphic(null);
			} else {
				setGraphic(hbox);
			}
		}

	}
	
	public void BackCreateProductScene(ActionEvent e) throws IOException {
		root = FXMLLoader.load(getClass().getResource("CreateProductScene.fxml"));
		stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
}