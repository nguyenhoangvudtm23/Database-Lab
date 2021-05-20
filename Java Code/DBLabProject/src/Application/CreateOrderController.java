package Application;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import Classes.Customer;
import Classes.Product;
import Execution.CustomerStatistics;
import Scenario.Starter;
import javafx.util.Callback;
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



public class CreateOrderController extends MenuController implements Initializable {
	static class XCell extends TableCell<Product, String>{
		HBox hbox = new HBox();
		Pane pane = new Pane();
		String lastItem;
		Button addbutton = new Button("+");
        TextField quantity = new TextField("0");
        Button subbutton = new Button("-");
        public int quant = 0;
		public XCell() {
            super();
            quantity.setAlignment(Pos.CENTER);
            
            addbutton.setMinWidth(USE_COMPUTED_SIZE);
            subbutton.setMinWidth(USE_COMPUTED_SIZE);
            quantity.setMaxWidth(100);
            hbox.getChildren().addAll(pane, addbutton, quantity, subbutton);
            hbox.setAlignment(Pos.CENTER);
            HBox.setHgrow(pane, Priority.ALWAYS);
//            quantity.setOnAction(new EventHandler<ActionEvent>() {
//				@Override
//				public void handle(ActionEvent event) {
//					// TODO Auto-generated method stub
//					quant = Integer.valueOf(quantity.getText());
//				}
//            	
//            });
            quantity.textProperty().addListener((v, oldValue, newValue) -> 
            	{try{
            		quant = Integer.valueOf(newValue.replace("\n", "").trim());
            		Product temp = getTableView().getItems().get(getIndex());
                 	temp.setCur_quantity(quant);
            		}
            	catch(Exception e) {}
            	}
            );
            addbutton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    quant = quant + 1;
                    quantity.setText(Integer.toString(quant));
                    Product temp = getTableView().getItems().get(getIndex());
                	temp.setCur_quantity(quant);
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
						quant = quant - 1;
						quantity.setText(Integer.toString(quant));
						Product temp = getTableView().getItems().get(getIndex());
		            	temp.setCur_quantity(quant);
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
                setGraphic(hbox);
            }
        }
		
	}
	private Stage stage;
	private Scene scene;
	private Parent root;
	@FXML
	private TableView<Product> ListProductTable;
	@FXML	
	private VBox ListBox;
	@FXML	
	private Label ListProductLb;
	@FXML
	private Button BackMainButton, showOrderButton;
	@FXML
	private TableColumn<Product, String> idColumn;
	@FXML
	private TableColumn<Product, Integer> AmountLeftColumn;
	@FXML
	private TableColumn<Product, String> NameColumn;
	@FXML
	private TableColumn<Product, Double> PriceColumn;
	@FXML
	private TableColumn<Product, String> DescriptionColumn;
	
	@FXML
	private TableColumn<Product, String> ActionColumn;
	@FXML
	private TextField PhoneNumberText, NameText, AddressText, EmailText;
	
	private String PhoneNumber="", Name="", Address="", Email="";
	
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Configuration.ListCustomer.clear();
		try {
			Starter.starting();
			ResultSet listCus = CustomerStatistics.getAllCustomer();
			while (listCus.next())
			{
				Customer customer = new Customer(
						listCus.getString(3),
						listCus.getString(2),
						listCus.getString(1),
						listCus.getString(4));
				Configuration.ListCustomer.add(customer);
			}
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
        idColumn.setCellValueFactory(new PropertyValueFactory<>("ProductID"));
        AmountLeftColumn.setCellValueFactory(new PropertyValueFactory<>("AmountLeft"));
        NameColumn.setCellValueFactory(new PropertyValueFactory<>("Name"));
        DescriptionColumn.setCellValueFactory(new PropertyValueFactory<>("Description"));
        PriceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        ActionColumn.setCellValueFactory(new PropertyValueFactory<>("DUMMY"));
        
        
        Callback<TableColumn<Product, String>, TableCell<Product, String>> cellFactory = new Callback<TableColumn<Product, String>, TableCell<Product, String>>() {
		    @Override
		    public TableCell<Product, String> call(final TableColumn<Product, String> param) {
		        TableCell<Product, String> cell = new XCell();
		        return cell;
		    }
        };
        ActionColumn.setCellFactory(cellFactory);
 
        ListProductTable.setItems(Configuration.ListProduct);
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
	public void ShowOrderScene(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("ShowOrder.fxml"));
		Parent root1 = loader.load();
		
		ShowOrderController showOrderscene = loader.getController();
		showOrderscene.showOrder(ListProductTable, Name);
		Stage stage1 = new Stage();
		stage1.setScene(new Scene(root1));
		stage1.setTitle("Order created!!!");
		stage1.show();
		
	}
	public void GetCustomerInformation(ActionEvent e) {
		if(Configuration.CheckPhone(PhoneNumber)) {
			System.out.println("There is Phone");
			System.out.println(PhoneNumber);
			int CustomerIndex = Configuration.findCustomerIndex(PhoneNumber);
			Customer cus = Configuration.ListCustomer.get(CustomerIndex);
			if(cus == null) {
				System.out.println("null");
			}
			
			// update name in text field
			// flag to check if customer information has change
			boolean flag = false;
			if(cus.getName().isEmpty() && !Name.isEmpty()) {
				System.out.println("customer name is empty");
				flag = true;
				cus.setName(Name);
			}
			else if(!cus.getName().isEmpty()) {
				System.out.println("customer name is not empty");
				NameText.setText(cus.getName());
			}
			// address
			if(cus.getAddress().isEmpty() && !Address.isEmpty()) {
				System.out.println("customer address is empty");
				flag = true;
				cus.setAddress(Address);
			}
			else if(!cus.getAddress().isEmpty()) {
				System.out.println("customer address is not empty");
				AddressText.setText(cus.getAddress());
			}
			// email 
			if(cus.getEmail().isEmpty() && !Email.isEmpty()) {
				System.out.println("customer email is empty");
				flag = true;
				cus.setEmail(Email);
			}
			else if(!cus.getEmail().isEmpty()) {
				System.out.println("customer email is not empty");
				EmailText.setText(cus.getEmail());
			}
			
			if(flag) {
				// set change
				Configuration.ListCustomer.remove(CustomerIndex);
				Configuration.ListCustomer.add(CustomerIndex, cus);
			}
		}
		else {
			System.out.println("There is no phone");
			Customer cus = new Customer(Address, PhoneNumber, Name, Email);
			
			
			try {
				CustomerStatistics.insertCustomer(Address, PhoneNumber, Name, Email);
				Configuration.ListCustomer.add(cus);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}	
