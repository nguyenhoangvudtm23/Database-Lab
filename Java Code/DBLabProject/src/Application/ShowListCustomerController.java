package Application;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import Classes.Customer;
import Execution.CustomerStatistics;
import Scenario.Starter;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.util.Callback;

public class ShowListCustomerController extends MenuController implements Initializable {
	@FXML 
	private TableView<Customer> ListCustomerTable;
	@FXML
	private TableColumn<Customer, Integer> CustomerIDColumn;
	@FXML
	private TableColumn<Customer, String> NameColumn;
	@FXML
	private TableColumn<Customer, String> AddressColumn;
	@FXML
	private TableColumn<Customer, String> PhoneNumberColumn;
	@FXML
	private TableColumn<Customer, String> EmailColumn;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		// id column
		try {
			Customer.ID = 1;
			Configuration.ListCustomer.clear();
			Starter.starting();
			ResultSet listCus = CustomerStatistics.getAllCustomer();
			while (listCus.next())
			{
				Customer customer = new Customer(listCus.getString(3), listCus.getString(2), listCus.getString(1), listCus.getString(4));
				Configuration.ListCustomer.add(customer);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		CustomerIDColumn.setCellValueFactory(new PropertyValueFactory<>("CustomerID"));
		
		// CustomerIdColumn
		NameColumn.setCellValueFactory(new PropertyValueFactory<>("Name"));
		Callback<TableColumn<Customer, String>, TableCell<Customer, String>> NameFactory = new Callback<TableColumn<Customer,String>, TableCell<Customer,String>>() {

			@Override
			public TableCell<Customer, String> call(TableColumn<Customer, String> param) {
				// TODO Auto-generated method stub
				NameCell cell = new NameCell();
				return cell;
			}
		};
		NameColumn.setCellFactory(NameFactory);
		
		// address
		AddressColumn.setCellValueFactory(new PropertyValueFactory<>("Address"));
		Callback<TableColumn<Customer, String>, TableCell<Customer, String>> AddressFactory = new Callback<TableColumn<Customer,String>, TableCell<Customer,String>>() {

			@Override
			public TableCell<Customer, String> call(TableColumn<Customer, String> param) {
				// TODO Auto-generated method stub
				AddressCell cell = new AddressCell();
				return cell;
			}
		};
		AddressColumn.setCellFactory(AddressFactory);
		
		//PhoneNumber 
		PhoneNumberColumn.setCellValueFactory(new PropertyValueFactory<>("PhoneNumber"));
		Callback<TableColumn<Customer, String>, TableCell<Customer, String>> PhoneNumberFactory = new Callback<TableColumn<Customer,String>, TableCell<Customer,String>>() {

			@Override
			public TableCell<Customer, String> call(TableColumn<Customer, String> param) {
				// TODO Auto-generated method stub
				PhoneNumberCell cell = new PhoneNumberCell();
				return cell;
			}
		};
		PhoneNumberColumn.setCellFactory(PhoneNumberFactory);
		
		// Email
		EmailColumn.setCellValueFactory(new PropertyValueFactory<>("Email"));
		Callback<TableColumn<Customer, String>, TableCell<Customer, String>> EmailFactory = new Callback<TableColumn<Customer,String>, TableCell<Customer,String>>() {

			@Override
			public TableCell<Customer, String> call(TableColumn<Customer, String> param) {
				// TODO Auto-generated method stub
				EmailCell cell = new EmailCell();
				return cell;
			}
		};
		EmailColumn.setCellFactory(EmailFactory);
		
		
		ListCustomerTable.setItems(Configuration.ListCustomer);
		
	}
	// Name cell 
	class NameCell extends TableCell<Customer, String> {

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
	                      Customer temp = getTableView().getItems().get(getIndex());
	                      temp.setName(textField.getText());
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
	// address cell
	class AddressCell extends TableCell<Customer, String> {

	      private TextField textField;
	    
	      public AddressCell() {
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
	                      Customer temp = getTableView().getItems().get(getIndex());
	                      temp.setAddress(textField.getText());
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
	// PhoneNumber
	class PhoneNumberCell extends TableCell<Customer, String> {

	      private TextField textField;
	    
	      public PhoneNumberCell() {
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
	                      Customer temp = getTableView().getItems().get(getIndex());
	                      temp.setPhoneNumber(textField.getText());
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
	// Email Cell
	class EmailCell extends TableCell<Customer, String> {

	      private TextField textField;
	    
	      public EmailCell() {
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
	                      Customer temp = getTableView().getItems().get(getIndex());
	                      temp.setEmail(textField.getText());
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