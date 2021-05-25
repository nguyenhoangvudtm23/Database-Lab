package Classes;
import java.time.LocalDate;
public class Orders {
	private static int ID = 0;
	private int OrderID;
	private int CustomerID;
	private double Totalcost;
	private LocalDate CreationDate;
	private String Status;
	private double Discount;
	
	public int getOrderID() {
		return OrderID;
	}

	public void setOrderID(int orderID) {
		OrderID = orderID;
	}

	public int getCustomerID() {
		return CustomerID;
	}

	public void setCustomerID(int customerID) {
		CustomerID = customerID;
	}

	public double getTotalcost() {
		return Totalcost;
	}

	public void setTotalcost(double totalcost) {
		Totalcost = totalcost;
	}

	public LocalDate getCreationDate() {
		return CreationDate;
	}

	public void setCreationDate(LocalDate creationDate) {
		CreationDate = creationDate;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public double getDiscount() {
		return Discount;
	}

	public void setDiscount(int discount) {
		Discount = discount;
	}

	public Orders( int customerID, double totalcost, LocalDate creationDate, String status, double discount) {
		super();
		OrderID = ID++;
		CustomerID = customerID;
		Totalcost = totalcost;
		CreationDate = creationDate;
		Status = status;
		Discount = discount;
	}

	public Orders() {
		// TODO Auto-generated constructor stub
	}

}
