package Application;

import Classes.Customer;
import Classes.Ingredient;
import Classes.Product;
import Classes.Supplier;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Configuration {
	public static ObservableList<Product> ListProduct = FXCollections.observableArrayList();
	public static ObservableList<Customer> ListCustomer = FXCollections.observableArrayList(
	);
	
	public static ObservableList<Ingredient> ListIngredient = FXCollections.observableArrayList(
	);
	public static ObservableList<Supplier> ListSupplier = FXCollections.observableArrayList(
			new Supplier("HaNoi", "01234", "Nguyen Van A", "naaaa@gmail.com"),
			new Supplier("Hue", "011234", "Nguyen Van B", "n1aa@gmail.com"),
			new Supplier("Vinh", "09097", "Nguyen Van C", "na23aaa@gmail.com"),
			new Supplier("Thanh Hoa", "012345", "Nguyen Van D", "naaa31a@gmail.com"),
			new Supplier("HaTinh", "0121231", "Nguyen Van E", "neea@gmail.com"),
			new Supplier("HaGiang", "0120934", "Nguyen Van F", "naffa@gmail.com"),
			new Supplier("HaTay", "0126734", "Nguyen Van G", "naagaa@gmail.com"),
			new Supplier("PhuTho", "012134", "Nguyen Van H", "naghha@gmail.com")
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
	public static int findSupplierIndex(String PhoneNumber) {
		int count = 0;
		for(Supplier sup: ListSupplier) {
			if(sup.getPhone_Number().equals(PhoneNumber)) {
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