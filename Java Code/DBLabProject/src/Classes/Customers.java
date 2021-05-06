package Classes;

public class Customers {
	private int CustomerID;
	private String Address;
	private String Phone_Number;
	private String Name;
	private String Email;
	
	public int getCustomerID() {
		return CustomerID;
	}

	public void setCustomerID(int customerID) {
		CustomerID = customerID;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getPhone_Number() {
		return Phone_Number;
	}

	public void setPhone_Number(String phone_Number) {
		Phone_Number = phone_Number;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public Customers(int customerID, String address, String phone_Number, String name, String email) {
		super();
		CustomerID = customerID;
		Address = address;
		Phone_Number = phone_Number;
		Name = name;
		Email = email;
	}

	public Customers() {
		// TODO Auto-generated constructor stub
	}

}
