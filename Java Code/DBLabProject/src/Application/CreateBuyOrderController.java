package Application;

import java.io.IOException;
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



public class CreateBuyOrderController extends MenuController implements Initializable {
	static class AddSubCell extends TableCell<Ingredient, String>{
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
                	Ingredient temp = getTableView().getItems().get(getIndex());
                	quant = temp.getCur_quantity();
                    quant = quant + 1;
                	temp.setCur_quantity(quant);
                	Configuration.ListIngredient.set(temp.getIngredientID() - 1, temp);
                }
            });
            subbutton.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					// TODO Auto-generated method stub
					Ingredient temp = getTableView().getItems().get(getIndex());
					quant = temp.getCur_quantity();
					if(quant == 0) {
						JOptionPane.showMessageDialog(null, "Cant less than 0");
					}
					else {
						quant = quant - 1;
		            	temp.setCur_quantity(quant);
		            	Configuration.ListIngredient.set(temp.getIngredientID() - 1, temp);
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
	class XCell extends TableCell<Ingredient, Integer> {

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
	                      Ingredient temp = getTableView().getItems().get(getIndex());
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
	private Stage stage;
	private Scene scene;
	private Parent root;
	@FXML
	private TextField filterField;
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
	private TableColumn<Ingredient, Integer> ActionColumn;
	@FXML
	private TableColumn<Ingredient, String> AddSubColumn;
	
	@FXML
	private TextField PhoneNumberText, NameText, AddressText, EmailText;
	
	private String PhoneNumber="", Name="", Address="", Email="";
	
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ListIngredientTable.setEditable(true);
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
        ActionColumn.setCellValueFactory(new PropertyValueFactory<>("cur_quantity"));
        AddSubColumn.setCellValueFactory(new PropertyValueFactory<>("DUMMY"));
        
        
        Callback<TableColumn<Ingredient, Integer>, TableCell<Ingredient, Integer>> cellFactory = new Callback<TableColumn<Ingredient, Integer>, TableCell<Ingredient, Integer>>() {
		    @Override
		    public TableCell<Ingredient, Integer> call(final TableColumn<Ingredient, Integer> param) {
		        TableCell<Ingredient, Integer> cell = new XCell();
		        return cell;
		    }
        };
        ActionColumn.setCellFactory(cellFactory);

        
        Callback<TableColumn<Ingredient, String>, TableCell<Ingredient, String>> addsubcellFactory = 
        		new Callback<TableColumn<Ingredient,String>, TableCell<Ingredient,String>>() {

					@Override
					public TableCell<Ingredient, String> call(TableColumn<Ingredient, String> param) {
						// TODO Auto-generated method stub
						TableCell<Ingredient, String> cell = new AddSubCell();
						return cell;
					}
				};
		AddSubColumn.setCellFactory(addsubcellFactory);

//        ListIngredientTable.setItems(Configuration.ListIngredient);
//        ListIngredientTable.setItems(Configuration.ListIngredient);
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
        FilteredList<Ingredient> filteredData = new FilteredList<>(Configuration.ListIngredient, b -> true);
		filterField.textProperty().addListener((o, oldValue, newValue) -> {
			filteredData.setPredicate(ingredient -> {
				if(newValue == null || newValue.isEmpty()) {
					return true;
				}
				String lowerCaseFilter = newValue.toLowerCase();
				if(ingredient.getName().toLowerCase().indexOf(lowerCaseFilter) != - 1) {
					return true;
				}
//				else if(String.valueOf(ingredient.getIngredientID()).toLowerCase().indexOf(lowerCaseFilter) != -1) {
//					return true;
//				}
				else if(ingredient.getDescription().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true;
				}
//				else if(String.valueOf(ingredient.getPrice()).toLowerCase().indexOf(lowerCaseFilter) != -1) {
//					return true;
//				}
//				else if(String.valueOf(ingredient.getAmountLeft()).toLowerCase().indexOf(lowerCaseFilter) != -1) {
//					return true;
//				}
				else return false;
			});
		});
		SortedList<Ingredient> sortedData = new SortedList<>(filteredData);
		sortedData.comparatorProperty().bind(ListIngredientTable.comparatorProperty());
		ListIngredientTable.setItems(sortedData);
	}
	public void SwitchMainMenu(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
		stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	public void ShowBuyOrderScene(ActionEvent event) throws IOException, SQLException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("ShowOrder.fxml"));
		Parent root1 = loader.load();
		ShowOrderController showOrderscene = loader.getController();
		showOrderscene.ShowBuyOrder(ListIngredientTable, Name, PhoneNumber);
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
	public void refresh(ActionEvent e)
	{	
		int count = 0;
		for(Ingredient ingredient: Configuration.ListIngredient) {
			ingredient.setCur_quantity(0);
			Configuration.ListIngredient.set(count++, ingredient);
		}
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
