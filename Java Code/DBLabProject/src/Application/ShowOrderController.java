package Application;



import Classes.Product;
import Execution.BuyOrderStatistics;
import Execution.CustomerStatistics;
import Execution.IngredientStatistics;
import Execution.OrderStatistics;
import Execution.ProductStatistics;
import Execution.SupplierStatistics;
import java.sql.SQLException;
import java.util.ArrayList;
import com.jfoenix.controls.JFXButton;
import Classes.Ingredient;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;

public class ShowOrderController {
	@FXML
	private TextArea textArea ;
	@FXML
	private JFXButton record;
	public void showOrder(TableView<Product> table, String Name, String PhoneNumber) throws SQLException {
		
		ArrayList<Product> items = new ArrayList<Product>();
		Double total_price = 0.0;
		textArea.clear();
		if(Name.isEmpty()) {
			Name = "Nguoi Vo Danh";
		}
		textArea.appendText("Khách hàng: " + Name + "\n");
		textArea.appendText("Danh sách sản phẩm:\n");
//		System.out.println(table.getItems().size());
		for(Product temp: Configuration.ListProduct) {
			
			if(temp.getCur_quantity() == 0) continue;
			total_price += temp.getCur_quantity() * temp.getPrice();
			items.add(temp);
			textArea.appendText(temp.printInformation() + "\n");
		}
		try
		{
			OrderStatistics.insertOrder(CustomerStatistics.getCustomerID(PhoneNumber), total_price, 'F', 0);
		}
		catch(Exception e)
		{
			OrderStatistics.insertOrder(0, total_price, 'F', 0);
		}
		textArea.appendText("Total Price: " + total_price);
		int orderID = OrderStatistics.lastestOrderID();
		record.setOnAction(e -> {
			for (Product prod: items)
			{
				try {
					OrderStatistics.insertOrderItems(orderID, Integer.parseInt(prod.getProductID()), prod.getCur_quantity());
					prod.setAmountLeft(prod.getAmountLeft() - prod.getCur_quantity());
					ProductStatistics.updateProductAmountLeft(Integer.parseInt(prod.getProductID()), prod.getAmountLeft() - prod.getCur_quantity());
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Hoàn thành");
			alert.setHeaderText("Hoàn thành");
			alert.setContentText("Đã ghi nhận hoá đơn");
			alert.showAndWait();
		});
	}
	public void ShowBuyOrder(TableView<Ingredient> table, String Name, String PhoneNumber) throws SQLException, ClassNotFoundException {
		ArrayList<Ingredient> items = new ArrayList<Ingredient>();
		Double total_price = 0.0;
		textArea.clear();
		if(Name.isEmpty()) {
			Name = "Nguoi Vo Danh";
		}
		textArea.appendText("Nhà cung cấp: " + Name + "\n");
		textArea.appendText("Danh sách nguyên liệu:\n");
		for(Ingredient temp: Configuration.ListIngredient) {
			
			if(temp.getCur_quantity() == 0) continue;
			items.add(temp);
			total_price += temp.getCur_quantity() * temp.getPrice();
			textArea.appendText(temp.printInformation() + "\n");
		}
		try {
			BuyOrderStatistics.insertBuyOrder(SupplierStatistics.getSupplierID(PhoneNumber), total_price);
		}
		catch (Exception e)
		{
//			System.out.println(SupplierStatistics.getSupplierID(PhoneNumber));
			BuyOrderStatistics.insertBuyOrder(0, total_price);
		}
		textArea.appendText("Total Price: " + total_price);
		int buyOrderID = BuyOrderStatistics.lastestBuyOrderID();
		record.setOnAction(e -> {
			for (Ingredient ingredient: items)
			{
				try {
					BuyOrderStatistics.insertBuyOrderItem(buyOrderID, ingredient.getIngredientID(), ingredient.getCur_quantity());
					ingredient.setAmountLeft(ingredient.getAmountLeft() + ingredient.getCur_quantity());
					IngredientStatistics.updateIngredientAmountLeft(ingredient.getIngredientID(), ingredient.getAmountLeft() + ingredient.getCur_quantity());
				}
				catch(Exception ex)
				{
					
				}
			}
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Hoàn thành");
			alert.setHeaderText("Hoàn thành");
			alert.setContentText("Đã ghi nhận hoá đơn");
			alert.showAndWait();
		});
	}
}
