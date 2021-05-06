package DatabaseLab;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Configuration {
	public static ObservableList<Product> ListProduct = FXCollections.observableArrayList(
            new Product( 12, "ice", 30.0, "aa"),
            new Product(12, "table", 30.0, "bb"),
            new Product(12, "chair", 30.0, "cc"),
            new Product(12, "bed", 30.0, "zz"),
            new Product(12, "box", 30.0, "gg")
    );
	public static ObservableList<Customer> ListCustomer = FXCollections.observableArrayList(
			new Customer("HaNoi", "01234", "Nguyen Van A", "naaaa@gmail.com"),
			new Customer("Hue", "011234", "Nguyen Van B", "n1aa@gmail.com"),
			new Customer("Vinh", "09097", "Nguyen Van C", "na23aaa@gmail.com"),
			new Customer("Thanh Hoa", "012345", "Nguyen Van D", "naaa31a@gmail.com"),
			new Customer("HaTinh", "0121231", "Nguyen Van E", "neea@gmail.com"),
			new Customer("HaGiang", "0120934", "Nguyen Van F", "naffa@gmail.com"),
			new Customer("HaTay", "0126734", "Nguyen Van G", "naagaa@gmail.com"),
			new Customer("PhuTho", "012134", "Nguyen Van H", "naghha@gmail.com")
	);
	
	public static ObservableList<Ingredient> ListIngredient = FXCollections.observableArrayList(
			new Ingredient("carrot", "good", 12),
			new Ingredient("Tomato", "good", 10),
			new Ingredient("vegetable", "fresh", 15)
	);
	public static void addCustomer(Customer ...customers ) {
		for(Customer customer: customers) {
			ListCustomer.add(customer);
//			System.out.println("Successfull Add Customer");
		}
	}
	public static boolean CheckPhone(String PhoneNumber) {
		for(Customer cus: ListCustomer) {
			//System.out.println(cus.getPhoneNumber());
			if(cus.getPhoneNumber().equals(PhoneNumber)) {
				return true;
			}
		}
		return false;
	}
	public static Customer findCustomer(String PhoneNumber){
		for(Customer cus: ListCustomer) {
			if(cus.getPhoneNumber().equals(PhoneNumber)) {
				return cus;
			}
		}
		return null;
	}
	public static int findCustomerIndex(String PhoneNumber) {
		int count = 0;
		for (Customer cus: ListCustomer) {
			if(cus.getPhoneNumber().equals(PhoneNumber)) {
				return count;
			}
			count ++;
		}
		return -1;
	}
//	public static void ReplaceCustomer(int index, Customer customer) {
//		Customer cur = ListCustomer.get(index);
//		cur.setName(customer.getName());
//		cur.setAddress(customer.getAddress());
//		cur.setEmail(customer.getEmail());
//		cur.setPhoneNumber(customer.getPhoneNumber());
//	}
			
}