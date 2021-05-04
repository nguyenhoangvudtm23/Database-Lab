package Classes;
import java.time.LocalDate;
public class BuyOrders {

	private int BuyOrderId;
	private int SupplierID;
	private double Totalcost;
	private LocalDate CreationDate;
	private char Status;
	
	public int getBuyOrderId() {
		return BuyOrderId;
	}

	public void setBuyOrderId(int buyOrderId) {
		BuyOrderId = buyOrderId;
	}

	public int getSupplierID() {
		return SupplierID;
	}

	public void setSupplierID(int supplierID) {
		SupplierID = supplierID;
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
	
	public BuyOrders(int buyOrderId, int supplierID, double totalcost, LocalDate creationDate, char status) {
		super();
		BuyOrderId = buyOrderId;
		SupplierID = supplierID;
		Totalcost = totalcost;
		CreationDate = creationDate;
		Status = status;
	}

	public BuyOrders() {
		// TODO Auto-generated constructor stub
	}

}
