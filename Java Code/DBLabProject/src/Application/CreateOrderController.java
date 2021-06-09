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
import Execution.ProductStatistics;
import Scenario.Starter;
import javafx.util.Callback;

import jfxtras.labs.scene.control.BigDecimalField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.*;



public class CreateOrderController extends MenuController implements Initializable {
	static class AddSubCell extends TableCell<Product, String>{
		HBox hbox = new HBox();
		Pane pane = new Pane();
		Button addbutton = new Button("+");
        Button subbutton = new Button("-");
        public int quant = 0;
		public AddSubCell() {
            super();

            addbutton.setMinWidth(USE_COMPUTED_SIZE);
            subbutton.setMinWidth(USE_COMPUTED_SIZE);
            hbox.getChildren().addAll(pane, addbutton, subbutton);
            hbox.setAlignment(Pos.CENTER);
            HBox.setHgrow(pane, Priority.ALWAYS);
            addbutton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                	Product temp = getTableView().getItems().get(getIndex());
                	quant = temp.getCur_quantity();
                    quant = quant + 1;
                	temp.setCur_quantity(quant);
                	Configuration.ListProduct.set(getIndex(), temp);
                }
            });
            subbutton.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					// TODO Auto-generated method stub
					Product temp = getTableView().getItems().get(getIndex());
					quant = temp.getCur_quantity();
					if(quant == 0) {
						JOptionPane.showMessageDialog(null, "Cant less than 0");
					}
					else {
						quant = quant - 1;
		            	temp.setCur_quantity(quant);
		            	Configuration.ListProduct.set(getIndex(), temp);
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
	class XCell extends TableCell<Product, Integer> {

	      private TextField textField;
	    
	      public XCell() {
	    	  super();
	      }
	    
	      @Override
	      public void startEdit() {
	          super.startEdit();
	        
	          if (textField == null) {
	              createTextField();
	          }
	        
	          setGraphic(textField);
	          setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
	          textField.selectAll();
	      }
	    
	      @Override
	      public void cancelEdit() {
	          super.cancelEdit();
	        
	          setText(String.valueOf(getItem()));
	          setContentDisplay(ContentDisplay.TEXT_ONLY);
	      }

	      @Override
	      public void updateItem(Integer item, boolean empty) {
	          super.updateItem(item, empty);
	        
	          if (empty) {
	              setText(null);
	              setGraphic(null);
	          } else {
	              if (isEditing()) {
	                  if (textField != null) {
	                      textField.setText(getString());
	                  }
	                  setGraphic(textField);
	                  setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
	              } else {
	                  setText(getString());
	                  setContentDisplay(ContentDisplay.TEXT_ONLY);
	              }
	          }
	      }

	      private void createTextField() {
	          textField = new TextField(getString());
	          textField.setMinWidth(this.getWidth() - this.getGraphicTextGap()*2);
	          textField.setOnKeyPressed(new EventHandler<KeyEvent>() {
	            
	              @Override
	              public void handle(KeyEvent t) {
	                  if (t.getCode() == KeyCode.ENTER) {
	                      commitEdit(Integer.valueOf(textField.getText()));
	                      Product temp = getTableView().getItems().get(getIndex());
	                      temp.setCur_quantity(Integer.valueOf(textField.getText()));
//	                      try {
//	                    	  ProductStatistics.updateProductName(Integer.parseInt(temp.getProductID()), temp.getName());
//	                      }
//	                      catch(Exception e)
//	                      {
//	                    	  
//	                      }
	                  } else if (t.getCode() == KeyCode.ESCAPE) {
	                      cancelEdit();
	                  }
	              }
	          });
	      }
	    
	      private String getString() {
	          return getItem() == null ? "" : getItem().toString();
	      }
	}

           
	@FXML
	private TextField filterField;
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
	private TableColumn<Product, Integer> ActionColumn;
	@FXML
	private TableColumn<Product, String> AddSubColumn;
	@FXML
	private TextField PhoneNumberText, NameText, AddressText, EmailText;
	
	private String PhoneNumber="", Name="", Address="", Email="";
	
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Configuration.ListCustomer.clear();
		ListProductTable.setEditable(true);
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
			ResultSet listProd = ProductStatistics.selectAll();
			while (listProd.next())
			{
				//amount_left is 2nd column, name & description are 1st column, price is 3rd column
				Product product = new Product(
						listProd.getInt(2), 
						listProd.getString(1), 
						listProd.getDouble(3),
						listProd.getString(1));
				product.setProductID(String.valueOf(listProd.getInt(4)));
				Configuration.ListProduct.add(product);
			}
		} catch (ClassNotFoundException e1) {
			showAlert("DB Error", "Can't connect to the database");
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			showAlert("DB Error", "Can't connect to the database");
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
        idColumn.setCellValueFactory(new PropertyValueFactory<>("ProductID"));
        AmountLeftColumn.setCellValueFactory(new PropertyValueFactory<>("AmountLeft"));
        NameColumn.setCellValueFactory(new PropertyValueFactory<>("Name"));
        DescriptionColumn.setCellValueFactory(new PropertyValueFactory<>("Description"));
        PriceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        ActionColumn.setCellValueFactory(new PropertyValueFactory<>("cur_quantity"));
        AddSubColumn.setCellValueFactory(new PropertyValueFactory<>("DUMMY"));
        
        Callback<TableColumn<Product, Integer>, TableCell<Product, Integer>> cellFactory = new Callback<TableColumn<Product, Integer>, TableCell<Product, Integer>>() {
		    @Override
		    public TableCell<Product, Integer> call(final TableColumn<Product, Integer> param) {
		        XCell cell = new XCell();
		        return cell;
		    }
        };
        ActionColumn.setCellFactory(cellFactory);
        

        Callback<TableColumn<Product, String>, TableCell<Product, String>> addsubcellFactory = 
        		new Callback<TableColumn<Product,String>, TableCell<Product,String>>() {

					@Override
					public TableCell<Product, String> call(TableColumn<Product, String> param) {
						// TODO Auto-generated method stub
						TableCell<Product, String> cell = new AddSubCell();
						return cell;
					}
				};
		AddSubColumn.setCellFactory(addsubcellFactory);
//        ActionColumn.setOnEditCommit(
//                new EventHandler<CellEditEvent<Product, Integer>>() {
//                    @Override
//                    public void handle(CellEditEvent<Product, Integer> t) {
//                        ((Product) t.getTableView().getItems().get(
//                            t.getTablePosition().getRow())
//                            ).setCur_quantity(t.getNewValue());
//                    }
//                }
//        );
        
        

//        ListProductTable.setItems(Configuration.ListProduct);
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
        
        FilteredList<Product> filteredData = new FilteredList<>(Configuration.ListProduct, b -> true);
		filterField.textProperty().addListener((o, oldValue, newValue) -> {
			filteredData.setPredicate(product -> {
				if(newValue == null || newValue.isEmpty()) {
					return true;
				}
				String lowerCaseFilter = newValue.toLowerCase();
				if(product.getName().toLowerCase().indexOf(lowerCaseFilter) != - 1) {
					return true;
				}
				else if(product.getProductID().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true;
				}
				else if(product.getDescription().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true;
				}
				else if(String.valueOf(product.getPrice()).toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true;
				}
				else if(String.valueOf(product.getAmountLeft()).toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true;
				}
				else return false;
			});
		});
		SortedList<Product> sortedData = new SortedList<>(filteredData);
		sortedData.comparatorProperty().bind(ListProductTable.comparatorProperty());
		ListProductTable.setItems(sortedData);
        
       
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
	public void ShowListOrderScene(ActionEvent event) throws IOException{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("ShowListOrder.fxml"));
		Parent root1 = loader.load();
		
		Stage stage1 = new Stage();
		stage1.setScene(new Scene(root1));
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
				showAlert("DB Error", "Can't connect to the database");
				e1.printStackTrace();
			}
		}
	}
}	
