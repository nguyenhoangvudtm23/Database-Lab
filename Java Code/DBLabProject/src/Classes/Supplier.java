package Classes;

public class Supplier {
	private String SupplierID;
	private String Name;
	private String Address;
	private String Phone_Number;
	private String Email;
	private static int ID = 0;
	public String getSupplierID() {
		return SupplierID;
	}
	public void setSupplierID(String supplierID) {
		SupplierID = supplierID;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
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
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	
	
	public Supplier(String address, String phone_Number, String name, String email) {
		super();
		SupplierID = String.valueOf(ID++);
		Name = name;
		Address = address;
		Phone_Number = phone_Number;
		Email = email;
	}
}	
