package DatabaseLab;



import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;

public class ShowOrderController {
	@FXML
	private TextArea textArea ;
	public void showOrder(TableView<Product> table, String Name) {
		
		Double total_price = 0.0;
		textArea.clear();
		if(Name.isEmpty()) {
			Name = "Nguoi Vo Danh";
		}
		System.out.println("Bill of Customer: " + Name + "\n");
		System.out.println("List of the product:");
		for(int i = 0; i < table.getItems().size(); i++) {
			Product temp = table.getItems().get(i);
			if(temp.getCur_quantity() == 0) continue;
			total_price += temp.getCur_quantity() * temp.getPrice();
			textArea.appendText(temp.printInformation() + "\n");
		}
		textArea.appendText("Total Price: " + total_price);
	}
}
