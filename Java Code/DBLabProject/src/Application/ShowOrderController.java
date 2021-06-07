package Application;



import Classes.Product;

import com.jfoenix.controls.JFXButton;

import Classes.Ingredient;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;

public class ShowOrderController {
	@FXML
	private TextArea textArea ;
	@FXML
	private JFXButton record;
	public void showOrder(TableView<Product> table, String Name) {
		
		Double total_price = 0.0;
		textArea.clear();
		if(Name.isEmpty()) {
			Name = "Nguoi Vo Danh";
		}
		textArea.appendText("Khách hàng: " + Name + "\n");
		textArea.appendText("Danh sách sản phẩm:\n");
		System.out.println(table.getItems().size());
		for(int i = 0; i < table.getItems().size(); i++) {
			Product temp = table.getItems().get(i);
			if(temp.getCur_quantity() == 0) continue;
			total_price += temp.getCur_quantity() * temp.getPrice();
			textArea.appendText(temp.printInformation() + "\n");
		}
		textArea.appendText("Total Price: " + total_price);
		record.setOnAction(e -> {
			
		});
	}
	public void ShowBuyOrder(TableView<Ingredient> table, String Name) {
		Double total_price = 0.0;
		textArea.clear();
		if(Name.isEmpty()) {
			Name = "Nguoi Vo Danh";
		}
		textArea.appendText("Nhà cung cấp: " + Name + "\n");
		textArea.appendText("Danh sách nguyên liệu:\n");
		for(int i = 0; i < table.getItems().size(); i++) {
			Classes.Ingredient temp = table.getItems().get(i);
			if(temp.getCur_quantity() == 0) continue;
			total_price += temp.getCur_quantity() * temp.getPrice();
			textArea.appendText(temp.printInformation() + "\n");
		}
		textArea.appendText("Total Price: " + total_price);
		record.setOnAction(e -> {
			
		});
	}
}
