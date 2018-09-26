
public abstract class Ticket {
	// static variables
	private static int uniqueTicketNumber = 1;
	
	// class fields
	private int ticketNumber;
	
	private double price;
	
	// constructors
	public Ticket(int ticketNumber) {
		this.ticketNumber = ticketNumber;
		advanceTicketNumber();
	}
	
	// mutators
	private void advanceTicketNumber() {
		uniqueTicketNumber++;
	}
	
	public void setPrice(double inputPrice) {
		this.price = inputPrice;
	}
	
	// accessors
	public static int getUniqueTicketNumber() {
		return uniqueTicketNumber;
	}
	
	public int getTicketNumber() {
		return ticketNumber;
	}
	
	public double getPrice() {
		return price;
	}
	
	public String toString() {
		return "Number: " + ticketNumber + ", Price: " + price;
	}
}
