package Application;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import Classes.Ingredient;
import Classes.Product;
import Classes.Supplier;
import Execution.IngredientStatistics;
import Execution.SupplierStatistics;
import Scenario.Starter;
//import Learnjavafx.JustDoIt.Person;
import javafx.util.Callback;
import jfxtras.labs.scene.control.BigDecimalField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import java.util.*;



public class CreateBuyOrderController extends MenuController implements Initializable {
	static class XCell extends TableCell<Ingredient, String>{
		public BigDecimalField field = new BigDecimalField();
        public int quant = 0;
		public XCell() {
            super();
            field.setText("0");
            field.setMinValue(BigDecimal.ZERO);
            field.numberProperty().addListener((o, oldvalue, newvalue) -> {
            	quant = newvalue.intValue();
            	Ingredient temp = getTableView().getItems().get(getIndex());
             	temp.setCur_quantity(quant);
//             	System.out.println(temp.getCur_quantity() + " " + temp.getIngredientID());
            });
        }
		@Override
		public void updateItem(String item, boolean empty) {
			super.updateItem(item, empty);

			if (empty) {
				setText(null);
				setGraphic(null);
			} else {
				setGraphic(field);
				setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
			}
		}
		
	}
	private Stage stage;
	private Scene scene;
	private Parent root;
	@FXML
	private TableView<Ingredient> ListIngredientTable;
	@FXML	
	private VBox ListBox;
	@FXML	
	private Label ListIngredientLb;
	@FXML
	private Button BackMainButton, showOrderButton;
	@FXML
	private TableColumn<Ingredient, Integer> idColumn;
	@FXML
	private TableColumn<Ingredient, Integer> AmountLeftColumn;
	@FXML
	private TableColumn<Ingredient, String> NameColumn;
	@FXML
	private TableColumn<Ingredient, Double> PriceColumn;
	@FXML
	private TableColumn<Ingredient, String> DescriptionColumn;
	
	@FXML
	private TableColumn<Ingredient, String> ActionColumn;
	@FXML
	private TextField PhoneNumberText, NameText, AddressText, EmailText;
	
	private String PhoneNumber="", Name="", Address="", Email="";
	
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			Starter.starting();
			Configuration.ListSupplier.clear();
			ResultSet listSup = SupplierStatistics.getAllSuppliers();
			while (listSup.next())
			{
				Supplier supplier = new Supplier();
				supplier.setSupplierID(String.valueOf(listSup.getInt(1)));
				supplier.setName(listSup.getString(2));
				supplier.setAddress(listSup.getString(3));
				supplier.setEmail(listSup.getString(5));
				supplier.setPhone_Number(listSup.getString(4));
				Configuration.ListSupplier.add(supplier);
			}
			Configuration.ListIngredient.clear();
			ResultSet listIngre = IngredientStatistics.getAllIngredient();
			while (listIngre.next())
			{
				Ingredient ingredient = new Ingredient(
						listIngre.getString(1),
						listIngre.getDouble(4),
						listIngre.getString(2),
						listIngre.getInt(3)
						);
				Configuration.ListIngredient.add(ingredient);
			}
		}
		catch(Exception e)
		{
			showAlert("DB Error", "Can't connect to the database");
		}
        idColumn.setCellValueFactory(new PropertyValueFactory<>("IngredientID"));
        AmountLeftColumn.setCellValueFactory(new PropertyValueFactory<>("AmountLeft"));
        NameColumn.setCellValueFactory(new PropertyValueFactory<>("Name"));
        DescriptionColumn.setCellValueFactory(new PropertyValueFactory<>("Description"));
        PriceColumn.setCellValueFactory(new PropertyValueFactory<>("Price"));
        ActionColumn.setCellValueFactory(new PropertyValueFactory<>("DUMMY"));
        
        
        Callback<TableColumn<Ingredient, String>, TableCell<Ingredient, String>> cellFactory = new Callback<TableColumn<Ingredient, String>, TableCell<Ingredient, String>>() {
		    @Override
		    public TableCell<Ingredient, String> call(final TableColumn<Ingredient, String> param) {
		        TableCell<Ingredient, String> cell = new XCell();
		        return cell;
		    }
        };
        ActionColumn.setCellFactory(cellFactory);
        ListIngredientTable.setItems(Configuration.ListIngredient);
        ListIngredientTable.setItems(Configuration.ListIngredient);
        PhoneNumberText.textProperty().addListener((v, oldValue, newValue) -> {
        	try{
        		PhoneNumber = newValue.replace("\n", "").trim();
        	}
        	catch(Exception e) {}
        });
        NameText.textProperty().addListener((v, oldValue, newValue) -> {
        	try{
        		Name = newValue.replace("\n", "").trim();
        	}
        	catch(Exception e) {}
        });
        EmailText.textProperty().addListener((v, oldValue, newValue) -> {
        	try{
        		Email = newValue.replace("\n", "").trim();
        	}
        	catch(Exception e) {}
        });
        AddressText.textProperty().addListener((v, oldValue, newValue) -> {
        	try{
        		Address = newValue.replace("\n", "").trim();
        	}
        	catch(Exception e) {}
        });
	}
	public void SwitchMainMenu(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
		stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	public void ShowBuyOrderScene(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("ShowOrder.fxml"));
		Parent root1 = loader.load();
		ShowOrderController showOrderscene = loader.getController();
		showOrderscene.ShowBuyOrder(ListIngredientTable, Name);
		Stage stage1 = new Stage();
		stage1.setScene(new Scene(root1));
		stage1.setTitle("Buy Order created!!!");
		stage1.show();
		
	}
	public void ShowListBuyOrderScene(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("ShowListBuyOrder.fxml"));
		Parent root1 = loader.load();
		Stage stage1 = new Stage();
		stage1.setScene(new Scene(root1));
		stage1.show();
		
	}
	public void GetSupplierInformation(ActionEvent e) throws SQLException {
		if(SupplierStatistics.checkExist(PhoneNumber) == 1) {
			System.out.println("There is Phone");
			System.out.println(PhoneNumber);
			int SupplierIndex = Configuration.findSupplierIndex(PhoneNumber);
			Supplier sup = Configuration.ListSupplier.get(SupplierIndex);
			if(sup == null) {
				System.out.println("null");
			}
			
			// update name in text field
			// flag to check if Supplier information has change
			boolean flag = false;
			if(sup.getName().isEmpty() && !Name.isEmpty()) {
				System.out.println("Supplier name is empty");
				flag = true;
				sup.setName(Name);
			}
			else if(!sup.getName().isEmpty()) {
				System.out.println("Supplier name is not empty");
				NameText.setText(sup.getName());
			}
			// address
			if(sup.getAddress().isEmpty() && !Address.isEmpty()) {
				System.out.println("Supplier address is empty");
				flag = true;
				sup.setAddress(Address);
			}
			else if(!sup.getAddress().isEmpty()) {
				System.out.println("Supplier address is not empty");
				AddressText.setText(sup.getAddress());
			}
			// email 
			if(sup.getEmail().isEmpty() && !Email.isEmpty()) {
				System.out.println("Supplier email is empty");
				flag = true;
				sup.setEmail(Email);
			}
			else if(!sup.getEmail().isEmpty()) {
				System.out.println("Supplier email is not empty");
				EmailText.setText(sup.getEmail());
			}
			
			if(flag) {
				// set change
				Configuration.ListSupplier.remove(SupplierIndex);
				Configuration.ListSupplier.add(SupplierIndex, sup);
			}
		}
		else {
			System.out.println("There is no phone");
			Supplier sup = new Supplier(Address, PhoneNumber, Name, Email);
			Configuration.ListSupplier.add(sup);
		}
	}
}	
