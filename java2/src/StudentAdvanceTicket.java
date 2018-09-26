
public class StudentAdvanceTicket extends AdvanceTicket {
	public StudentAdvanceTicket(int ticketNumber, int daysAdvance) {
		super(ticketNumber, daysAdvance);
		setPrice(getPrice() / 2);
	}
	
	public String toString() {
		return super.toString() + " (ID required)";
	}
}
