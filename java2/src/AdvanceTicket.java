
public class AdvanceTicket extends Ticket {
	public AdvanceTicket(int ticketNumber, int daysAdvance) {
		super(ticketNumber);
		
		if (daysAdvance >= 10) {
			setPrice(30.0);
		} else {
			setPrice(40.0);
		}
	}
}
