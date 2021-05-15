package Classes;

public class Suppliers {
	private int SupplierID;
	private String Name;
	private String Address;
	private String Phone_Number;
	private String Email;
	
	public int getSupplierID() {
		return SupplierID;
	}

	public void setSupplierID(int supplierID) {
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

	public String getEmailx() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public Suppliers(int supplierID, String name, String address, String phone_Number, String email) {
		super();
		SupplierID = supplierID;
		Name = name;
		Address = address;
		Phone_Number = phone_Number;
		Email = email;
	}

	public Suppliers(){
		// TODO Auto-generated constructor stub
	}

}
