package Application;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import Classes.BuyOrders;
import Execution.BuyOrderStatistics;
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

public class ShowListBuyOrderController extends MenuController implements Initializable {
	@FXML
	private Button backCreateProductSceneButton;
	private Parent root;
	private Stage stage;
	private Scene scene;
	@FXML
	private TableView<BuyOrders> ListBuyOrderTable;
	@FXML
	private TableColumn<BuyOrders, String> BuyOrderIDColumn;
	@FXML
	private TableColumn<BuyOrders, Integer> SupplierIDColumn;
	@FXML
	private TableColumn<BuyOrders, String> TotalCostColumn;
	@FXML
	private TableColumn<BuyOrders, Double> DateColumn;
	@FXML
	private TableColumn<BuyOrders, String> StatusColumn;
	@FXML
	private TableColumn<BuyOrders, String> DeleteColumn;
	@FXML
	private TextField filterField;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			Starter.starting();
			Configuration.ListBuyOrder.clear();
			ResultSet list = BuyOrderStatistics.selectAllBuyOrders();
			int tmp = 0;
			while (list.next())
			{
				tmp++;
				System.out.println(tmp);
				BuyOrders buyorder = new BuyOrders();
				buyorder.setBuyOrderId(list.getInt(1));
				buyorder.setStatus(list.getString(5));
				buyorder.setSupplierID(list.getInt(2));
				buyorder.setCreationDate(LocalDate.parse(list.getString(4)));
				buyorder.setTotalcost(list.getDouble(3));
				Configuration.ListBuyOrder.add(buyorder);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			showAlert("DB Error", "Can't connect to the database");
		}
		// TODO Auto-generated method stub
		SupplierIDColumn.setCellValueFactory(new PropertyValueFactory<>("SupplierID"));
        
        // OrderID Column
        BuyOrderIDColumn.setCellValueFactory(new PropertyValueFactory<>("BuyOrderID"));
		
		// Customer Column
		StatusColumn.setCellValueFactory(new PropertyValueFactory<>("Status"));
		
		// TotalCost Column
		TotalCostColumn.setCellValueFactory(new PropertyValueFactory<>("Totalcost"));
		
		// create date Column
		DateColumn.setCellValueFactory(new PropertyValueFactory<>("CreationDate"));
		
		// delete column
		DeleteColumn.setCellValueFactory(new PropertyValueFactory<>("DUMMY"));
		Callback<TableColumn<BuyOrders, String>, TableCell<BuyOrders, String>> DelCellFactory = 
        		new Callback<TableColumn<BuyOrders,String>, TableCell<BuyOrders,String>>() {

					@Override
					public TableCell<BuyOrders, String> call(TableColumn<BuyOrders, String> param) {
						// TODO Auto-generated method stub
						DelCell cell = new DelCell();
						return cell;
					}
				};
		DeleteColumn.setCellFactory(DelCellFactory);
		
		
//		ListOrderTable.setItems(Configuration.ListOrder);
		FilteredList<BuyOrders> filteredData = new FilteredList<>(Configuration.ListBuyOrder, b -> true);
		filterField.textProperty().addListener((o, oldValue, newValue) -> {
			filteredData.setPredicate(buyorder -> {
				if(newValue == null || newValue.isEmpty()) {
					return true;
				}
				String lowerCaseFilter = newValue.toLowerCase();
				if(String.valueOf(buyorder.getBuyOrderID()).toLowerCase().indexOf(lowerCaseFilter) != - 1) {
					return true;
				}
				else if(String.valueOf(buyorder.getSupplierID()).toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true;
				}
				else if(String.valueOf(buyorder.getStatus()).toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true;
				}
				else if(String.valueOf(buyorder.getTotalcost()).toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true;
				}
				else if(buyorder.getCreationDate().toString().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true;
				}
				else return false;
			});
		});
		SortedList<BuyOrders> sortedData = new SortedList<>(filteredData);
		sortedData.comparatorProperty().bind(ListBuyOrderTable.comparatorProperty());
		ListBuyOrderTable.setItems(sortedData);
         
	}
	
	static class DelCell extends TableCell<BuyOrders, String>{
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
					BuyOrders temp = getTableView().getItems().get(getIndex());
					Configuration.ListBuyOrder.remove(temp);
					try {
						BuyOrderStatistics.deleteBuyOrderWithBuyOrderID(temp.getBuyOrderID());
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
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
		root = FXMLLoader.load(getClass().getResource("CreateIngredientScene.fxml"));
		stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
}