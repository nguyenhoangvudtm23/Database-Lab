package Application;

import java.net.URL;
import java.util.ResourceBundle;

import Classes.Supplier;
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

public class ShowListSupplierController implements Initializable {
	@FXML 
	private TableView<Supplier> ListSupplierTable;
	@FXML
	private TableColumn<Supplier, Integer> SupplierIDColumn;
	@FXML
	private TableColumn<Supplier, String> NameColumn;
	@FXML
	private TableColumn<Supplier, String> AddressColumn;
	@FXML
	private TableColumn<Supplier, String> PhoneNumberColumn;
	@FXML
	private TableColumn<Supplier, String> EmailColumn;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		// id column
		SupplierIDColumn.setCellValueFactory(new PropertyValueFactory<>("SupplierID"));
		
		// SupplierIdColumn
		NameColumn.setCellValueFactory(new PropertyValueFactory<>("Name"));
		Callback<TableColumn<Supplier, String>, TableCell<Supplier, String>> NameFactory = new Callback<TableColumn<Supplier,String>, TableCell<Supplier,String>>() {

			@Override
			public TableCell<Supplier, String> call(TableColumn<Supplier, String> param) {
				// TODO Auto-generated method stub
				NameCell cell = new NameCell();
				return cell;
			}
		};
		NameColumn.setCellFactory(NameFactory);
		
		// address
		AddressColumn.setCellValueFactory(new PropertyValueFactory<>("Address"));
		Callback<TableColumn<Supplier, String>, TableCell<Supplier, String>> AddressFactory = new Callback<TableColumn<Supplier,String>, TableCell<Supplier,String>>() {

			@Override
			public TableCell<Supplier, String> call(TableColumn<Supplier, String> param) {
				// TODO Auto-generated method stub
				AddressCell cell = new AddressCell();
				return cell;
			}
		};
		AddressColumn.setCellFactory(AddressFactory);
		
		//PhoneNumber 
		PhoneNumberColumn.setCellValueFactory(new PropertyValueFactory<>("PhoneNumber"));
		Callback<TableColumn<Supplier, String>, TableCell<Supplier, String>> PhoneNumberFactory = new Callback<TableColumn<Supplier,String>, TableCell<Supplier,String>>() {

			@Override
			public TableCell<Supplier, String> call(TableColumn<Supplier, String> param) {
				// TODO Auto-generated method stub
				PhoneNumberCell cell = new PhoneNumberCell();
				return cell;
			}
		};
		PhoneNumberColumn.setCellFactory(PhoneNumberFactory);
		
		// Email
		EmailColumn.setCellValueFactory(new PropertyValueFactory<>("Email"));
		Callback<TableColumn<Supplier, String>, TableCell<Supplier, String>> EmailFactory = new Callback<TableColumn<Supplier,String>, TableCell<Supplier,String>>() {

			@Override
			public TableCell<Supplier, String> call(TableColumn<Supplier, String> param) {
				// TODO Auto-generated method stub
				EmailCell cell = new EmailCell();
				return cell;
			}
		};
		EmailColumn.setCellFactory(EmailFactory);
		
		
		ListSupplierTable.setItems(Configuration.ListSupplier);
		
	}
	// Name cell 
	class NameCell extends TableCell<Supplier, String> {

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
	                      Supplier temp = getTableView().getItems().get(getIndex());
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
	class AddressCell extends TableCell<Supplier, String> {

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
	                      Supplier temp = getTableView().getItems().get(getIndex());
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
	class PhoneNumberCell extends TableCell<Supplier, String> {

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
	                      Supplier temp = getTableView().getItems().get(getIndex());
	                      temp.setPhone_Number(textField.getText());
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
	class EmailCell extends TableCell<Supplier, String> {

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
	                      Supplier temp = getTableView().getItems().get(getIndex());
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