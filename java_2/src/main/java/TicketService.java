import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Date;

public class TicketService {

    public static void main(String[] args) {
        char[] id = {'4', 'a', 'c', 'r'};
        char[] hall = {'h', 'a', 'l', 'l'};
        Date time = new GregorianCalendar(2016, Calendar.MARCH, 12).getTime();
        int eventCode = 15;
        boolean isPromo = true;
        char stadiumSector = 'A';
        double maxBackpackWeight = 15.2;

        Ticket emptyTicket = new Ticket();
        Ticket limitedTicket = new Ticket(hall, time, eventCode);
        Ticket ticket = new Ticket(id, hall, eventCode, time, isPromo, stadiumSector, maxBackpackWeight);

        emptyTicket.printTicket();
        limitedTicket.printTicket();
        ticket.printTicket();

        ticket.addTicketPrice(15.3);
        System.out.printf("Ticket price: %.2f\n", ticket.getTicketPrice());
    }
}
