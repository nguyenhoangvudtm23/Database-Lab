package Application;

import java.awt.GraphicsConfigTemplate;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import Classes.Ingredient;
import Execution.IngredientStatistics;
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

public class ShowListIngredientController extends MenuController implements Initializable {
	@FXML
	private Button backCreateIngredientSceneButton;
	private Parent root;
	private Stage stage;
	private Scene scene;
	@FXML
	private TableView<Ingredient> ListIngredientTable;
	@FXML
	private TableColumn<Ingredient, String> idColumn;
	@FXML
	private TableColumn<Ingredient, Integer> AmountLeftColumn;
	@FXML
	private TableColumn<Ingredient, String> NameColumn;
	@FXML
	private TableColumn<Ingredient, Double> PriceColumn;
	@FXML
	private TableColumn<Ingredient, String> DescriptionColumn;
	@FXML
	private TextField filterField;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		Configuration.ListIngredient.clear();
		try {
			Ingredient.ID = 1;
			Starter.starting();
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
		} catch (ClassNotFoundException e) {
			showAlert("DB Error", "Can't connect to the database");
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			showAlert("DB Error", "Can not connect to the database");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		idColumn.setCellValueFactory(new PropertyValueFactory<>("IngredientID"));


		// AmountLeft Column
		AmountLeftColumn.setCellValueFactory(new PropertyValueFactory<>("AmountLeft"));
		Callback<TableColumn<Ingredient, Integer>, TableCell<Ingredient, Integer>> AmountLeftCellFactory = 
				new Callback<TableColumn<Ingredient,Integer>, TableCell<Ingredient,Integer>>() {

			@Override
			public TableCell<Ingredient, Integer> call(TableColumn<Ingredient, Integer> param) {
				// TODO Auto-generated method stub
				AmountLeftCell cell = new AmountLeftCell();
				return cell;
			}
		};
		AmountLeftColumn.setCellFactory(AmountLeftCellFactory);


		// Name Column
		NameColumn.setCellValueFactory(new PropertyValueFactory<>("Name"));
		Callback<TableColumn<Ingredient, String>, TableCell<Ingredient, String>> NameCellFactory = 
				new Callback<TableColumn<Ingredient,String>, TableCell<Ingredient,String>>() {

			@Override
			public TableCell<Ingredient, String> call(TableColumn<Ingredient, String> param) {
				// TODO Auto-generated method stub
				NameCell cell = new NameCell();
				return cell;
			}
		};
		NameColumn.setCellFactory(NameCellFactory);

		// Description Column
		DescriptionColumn.setCellValueFactory(new PropertyValueFactory<>("Description"));
		Callback<TableColumn<Ingredient, String>, TableCell<Ingredient, String>> DescriptionCellFactory = 
				new Callback<TableColumn<Ingredient,String>, TableCell<Ingredient,String>>() {

			@Override
			public TableCell<Ingredient, String> call(TableColumn<Ingredient, String> param) {
				// TODO Auto-generated method stub
				DescriptionCell cell = new DescriptionCell();
				return cell;
			}
		};
		DescriptionColumn.setCellFactory(DescriptionCellFactory);

		// Price Column
		PriceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
		Callback<TableColumn<Ingredient, Double>, TableCell<Ingredient, Double>> PriceCellFactory = 
				new Callback<TableColumn<Ingredient,Double>, TableCell<Ingredient,Double>>() {

			@Override
			public TableCell<Ingredient, Double> call(TableColumn<Ingredient, Double> param) {
				// TODO Auto-generated method stub
				PriceCell cell = new PriceCell();
				return cell;
			}
		};
		PriceColumn.setCellFactory(PriceCellFactory);

		//		ListIngredientTable.setItems(Configuration.ListIngredient);
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
				else if(String.valueOf(ingredient.getIngredientID()).toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true;
				}
				else if(ingredient.getDescription().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true;
				}
				else if(String.valueOf(ingredient.getPrice()).toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true;
				}
				else if(String.valueOf(ingredient.getAmountLeft()).toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true;
				}
				else return false;
			});
		});
		SortedList<Ingredient> sortedData = new SortedList<>(filteredData);
		sortedData.comparatorProperty().bind(ListIngredientTable.comparatorProperty());
		ListIngredientTable.setItems(sortedData);

	}
	public void BackCreateIngredientScene(ActionEvent e) throws IOException {
		root = FXMLLoader.load(getClass().getResource("CreateIngredientScene.fxml"));
		stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	class AmountLeftCell extends TableCell<Ingredient, Integer> {

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
			//	    			  Ingredient temp = getTableView().getItems().get(getIndex());
			//	    			  temp.setAmountLeft(Integer.valueOf(newValue));
			//	    		  }
			//	    		  catch(Exception e) {}
			//	    	  });
			textField.setOnKeyPressed(new EventHandler<KeyEvent>() {

				@Override
				public void handle(KeyEvent t) {
					if (t.getCode() == KeyCode.ENTER) {
						commitEdit(Integer.parseInt(textField.getText()));
						Ingredient temp = getTableView().getItems().get(getIndex());
						System.out.println(Integer.parseInt(textField.getText()));
						temp.setAmountLeft(Integer.valueOf(textField.getText()));
						try {
							IngredientStatistics.updateIngredientAmountLeft(temp.getIngredientID(), temp.getAmountLeft());
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
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
	class NameCell extends TableCell<Ingredient, String> {

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
						Ingredient temp = getTableView().getItems().get(getIndex());
						temp.setName(textField.getText());
						try {
							IngredientStatistics.updateIngredientName(temp.getIngredientID(), temp.getName());
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
	class PriceCell extends TableCell<Ingredient, Double> {

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
						Ingredient temp = getTableView().getItems().get(getIndex());
						temp.setPrice(Double.parseDouble(textField.getText()));
						try {
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
	class DescriptionCell extends TableCell<Ingredient, String> {

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
						Ingredient temp = getTableView().getItems().get(getIndex());
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