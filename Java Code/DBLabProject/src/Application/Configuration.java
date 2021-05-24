package Application;

import java.time.LocalDate;

import Classes.BuyOrders;
import Classes.Customer;
import Classes.Ingredient;
import Classes.Orders;
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
			
    );
	
	public static ObservableList<Orders> ListOrder = FXCollections.observableArrayList(
			new Orders(1, 120, LocalDate.of(2019, 2, 3), 'S', 20),
			new Orders(2, 125, LocalDate.of(2019, 1, 13), 'P', 30)
	);
	public static ObservableList<BuyOrders> ListBuyOrder = FXCollections.observableArrayList(
			new BuyOrders(1, 120, LocalDate.of(2019, 2, 3), 'S'),
			new BuyOrders(2, 125, LocalDate.of(2019, 1, 13), 'P')
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