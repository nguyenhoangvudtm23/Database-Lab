package Classes;
import java.time.LocalDate;
public class Orders {
	
	private int OrderID;
	private int CustomerID;
	private double Totalcost;
	private LocalDate CreationDate;
	private char Status;
	private int Discount;
	
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

	public char getStatus() {
		return Status;
	}

	public void setStatus(char status) {
		Status = status;
	}

	public int getDiscount() {
		return Discount;
	}

	public void setDiscount(int discount) {
		Discount = discount;
	}

	public Orders(int orderID, int customerID, double totalcost, LocalDate creationDate, char status, int discount) {
		super();
		OrderID = orderID;
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
