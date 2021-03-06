package Application;

import java.awt.GraphicsConfigTemplate;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Classes.Product;
import Execution.ProductStatistics;
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
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;

public class ShowListProductController extends MenuController implements Initializable {
	@FXML
	private Button backCreateProductSceneButton;
	private Parent root;
	private Stage stage;
	private Scene scene;
	@FXML
	private TableView<Product> ListProductTable;
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
	private TextField filterField;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		idColumn.setCellValueFactory(new PropertyValueFactory<>("ProductID"));
        
		try {
			Starter.starting();
		}
		catch(Exception e)
		{
			showAlert("DB Error", "Can't connect to the database");
		}
        
        // AmountLeft Column
        AmountLeftColumn.setCellValueFactory(new PropertyValueFactory<>("AmountLeft"));
        Callback<TableColumn<Product, Integer>, TableCell<Product, Integer>> AmountLeftCellFactory = 
        		new Callback<TableColumn<Product,Integer>, TableCell<Product,Integer>>() {

					@Override
					public TableCell<Product, Integer> call(TableColumn<Product, Integer> param) {
						// TODO Auto-generated method stub
						AmountLeftCell cell = new AmountLeftCell();
						return cell;
					}
				};
		AmountLeftColumn.setCellFactory(AmountLeftCellFactory);
		
		
		// Name Column
		NameColumn.setCellValueFactory(new PropertyValueFactory<>("Name"));
		Callback<TableColumn<Product, String>, TableCell<Product, String>> NameCellFactory = 
        		new Callback<TableColumn<Product,String>, TableCell<Product,String>>() {

					@Override
					public TableCell<Product, String> call(TableColumn<Product, String> param) {
						// TODO Auto-generated method stub
						NameCell cell = new NameCell();
						return cell;
					}
				};
		NameColumn.setCellFactory(NameCellFactory);
		
		// Description Column
		DescriptionColumn.setCellValueFactory(new PropertyValueFactory<>("Description"));
		Callback<TableColumn<Product, String>, TableCell<Product, String>> DescriptionCellFactory = 
        		new Callback<TableColumn<Product,String>, TableCell<Product,String>>() {

					@Override
					public TableCell<Product, String> call(TableColumn<Product, String> param) {
						// TODO Auto-generated method stub
						DescriptionCell cell = new DescriptionCell();
						return cell;
					}
				};
		DescriptionColumn.setCellFactory(DescriptionCellFactory);
		
		// Price Column
		PriceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
		Callback<TableColumn<Product, Double>, TableCell<Product, Double>> PriceCellFactory = 
				new Callback<TableColumn<Product,Double>, TableCell<Product,Double>>() {

					@Override
					public TableCell<Product, Double> call(TableColumn<Product, Double> param) {
						// TODO Auto-generated method stub
						PriceCell cell = new PriceCell();
						return cell;
					}
				};
		PriceColumn.setCellFactory(PriceCellFactory);
		
//		ListProductTable.setItems(Configuration.ListProduct);
		FilteredList<Product> filteredData = new FilteredList<>(Configuration.ListProduct, b -> true);
		filterField.textProperty().addListener((o, oldValue, newValue) -> {
			filteredData.setPredicate(Product -> {
				if(newValue == null || newValue.isEmpty()) {
					return true;
				}
				String lowerCaseFilter = newValue.toLowerCase();
				if(Product.getName().toLowerCase().indexOf(lowerCaseFilter) != - 1) {
					return true;
				}
				else if(Product.getProductID().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true;
				}
				else if(Product.getDescription().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true;
				}
				else if(String.valueOf(Product.getPrice()).toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true;
				}
				else if(String.valueOf(Product.getAmountLeft()).toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true;
				}
				else return false;
			});
		});
		SortedList<Product> sortedData = new SortedList<>(filteredData);
		sortedData.comparatorProperty().bind(ListProductTable.comparatorProperty());
		ListProductTable.setItems(sortedData);
         
	}
	public void BackCreateProductScene(ActionEvent e) throws IOException {
		root = FXMLLoader.load(getClass().getResource("CreateProductScene.fxml"));
		//stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
		stage = new Stage();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	class AmountLeftCell extends TableCell<Product, Integer> {

	      private TextField textField;
	      
	      public AmountLeftCell() {
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
//	          textField.textProperty().addListener((v, oldValue, newValue) -> {
//	    		  try {
//	    			  Product temp = getTableView().getItems().get(getIndex());
//	    			  temp.setAmountLeft(Integer.valueOf(newValue));
//	    		  }
//	    		  catch(Exception e) {}
//	    	  });
	          textField.setOnKeyPressed(new EventHandler<KeyEvent>() {
	            
	              @Override
	              public void handle(KeyEvent t) {
	                  if (t.getCode() == KeyCode.ENTER) {
	                      commitEdit(Integer.parseInt(textField.getText()));
	                      Product temp = getTableView().getItems().get(getIndex());
	                      System.out.println(Integer.parseInt(textField.getText()));
		    			  temp.setAmountLeft(Integer.valueOf(textField.getText()));
		    			  try {
		    				  ProductStatistics.updateProductAmountLeft(Integer.parseInt(temp.getProductID()), temp.getAmountLeft());
		    			  }
		    			  catch(Exception e)
		    			  {
		    				  
		    			  }
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
	class NameCell extends TableCell<Product, String> {

	      private TextField textField;
	    
	      public NameCell() {
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
	      public void updateItem(String item, boolean empty) {
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
	                      commitEdit(textField.getText());
	                      Product temp = getTableView().getItems().get(getIndex());
	                      temp.setName(textField.getText());
	                      try {
	                    	  ProductStatistics.updateProductName(Integer.parseInt(temp.getProductID()), temp.getName());
	                      }
	                      catch(Exception e)
	                      {
	                    	  
	                      }
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
	class PriceCell extends TableCell<Product, Double> {

	      private TextField textField;
	    
	      public PriceCell() {
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
	      public void updateItem(Double item, boolean empty) {
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
	                      commitEdit(Double.parseDouble(textField.getText()));
	                      Product temp = getTableView().getItems().get(getIndex());
	                      temp.setPrice(Double.parseDouble(textField.getText()));
	                      try {
	                    	  ProductStatistics.updateProductPrice(Integer.parseInt(temp.getProductID()), temp.getPrice());
	                      }
	                      catch (Exception e)
	                      {
	                    	  
	                      }
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
	class DescriptionCell extends TableCell<Product, String> {

	      private TextField textField;
	    
	      public DescriptionCell() {
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
	      public void updateItem(String item, boolean empty) {
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
	                      commitEdit(textField.getText());
	                      Product temp = getTableView().getItems().get(getIndex());
	                      temp.setDescription(textField.getText());
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
}