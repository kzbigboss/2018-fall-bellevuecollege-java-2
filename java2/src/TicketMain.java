
public class TicketMain {

	public static void main(String[] args) {
		
		WalkupTicket first = new WalkupTicket(Ticket.getUniqueTicketNumber());
		WalkupTicket second = new WalkupTicket(Ticket.getUniqueTicketNumber());
		WalkupTicket third = new WalkupTicket(Ticket.getUniqueTicketNumber());
		AdvanceTicket fourth = new AdvanceTicket(Ticket.getUniqueTicketNumber(), 11);
		AdvanceTicket fifth = new AdvanceTicket(Ticket.getUniqueTicketNumber(), 9);
		StudentAdvanceTicket sixth = new StudentAdvanceTicket(Ticket.getUniqueTicketNumber(), 10);
		StudentAdvanceTicket seventh = new StudentAdvanceTicket(Ticket.getUniqueTicketNumber(), 9);
		
		System.out.println(first);
		System.out.println(second);
		System.out.println(third);
		System.out.println(fourth);
		System.out.println(fifth);
		System.out.println(sixth);
		System.out.println(seventh);

	}

}
