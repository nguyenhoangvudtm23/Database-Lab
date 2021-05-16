package Classes;

public class Customer {
	private String CustomerID;
	private String Address;
	private String PhoneNumber;
	private String Name;
	private String Email;
	private static int ID = 0;
	
	
	public Customer(boolean createCustomerID, String Address, String PhoneNumber, String Name, String Email) {
		this.Address = Address;
		this.PhoneNumber = PhoneNumber;
		this.Name = Name;
		this.Email = Email;
	}
	public Customer(String Address, String PhoneNumber, String Name, String Email) {
		this.CustomerID = String.valueOf(ID++);
		this.Address = Address;
		this.PhoneNumber = PhoneNumber;
		this.Name = Name;
		this.Email = Email;
	}
	public Customer() {
		this("", "", "", "");
	}
	public Customer(String PhoneNumber, String Name) {
		this("", PhoneNumber, Name, "");
	}
	
	public Customer(String PhoneNumber) {
		this("", PhoneNumber, "", "");
	}
	
	public String getCustomerID() {
		return CustomerID;
	}
	public void setCustomerID(String customerID) {
		CustomerID = customerID;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getPhoneNumber() {
		return PhoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
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
	public boolean CheckPhoneNumber(String PhoneNumber) {
		return (this.PhoneNumber.equals(PhoneNumber));
	}
	
	
}
