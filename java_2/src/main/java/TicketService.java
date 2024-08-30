import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class TicketService {

    public static void main(String[] args) throws ParseException, IOException {
        char[] id = {'4', 'a', 'c', 'r'};

        System.out.println("Enter hall name length (less than 10):");
        Scanner in = new Scanner(System.in);
        int lenHallName = 0;

        while (lenHallName > 10 || lenHallName < 1) {
            lenHallName = in.nextInt();
        }

        char[] hall = new char[lenHallName];
        for (int i = 0; i < lenHallName; i++) {
            System.out.printf("%d: ", i);
            hall[i] = in.next().charAt(0);
        }

        System.out.println("Enter time dd/MM/yyyy hh:mm: ");
        in.nextLine();
        String timeString = in.nextLine();

        Date time = new SimpleDateFormat("dd/MM/yyyy hh:mm").parse(timeString);
        System.out.println(time);
        System.out.println(time.getTime());

        System.out.println("Enter event code:");
        int eventCode = -1;
        while (eventCode > 1000 | eventCode < 1) {
            eventCode = in.nextInt();
        }

        System.out.println("Enter is promo:");
        boolean isPromo = in.nextBoolean();

        System.out.println("Choose stadium sector\n A B C");
        List<String> sectors = Arrays.asList("A", "B", "C");

        String stadiumSector = " ";

        while (!sectors.contains(stadiumSector)) {
            stadiumSector = String.valueOf(in.next().charAt(0));
        }

        System.out.print("Enter max backpack weight: ");
        double maxBackpackWeight = in.nextInt();

        Ticket emptyTicket = new Ticket();
        Ticket limitedTicket = new Ticket(hall, time, eventCode);
        Ticket ticket = new Ticket(id, hall, eventCode, time, isPromo, stadiumSector.charAt(0), maxBackpackWeight);


        emptyTicket.printTicket();
        limitedTicket.printTicket();
        ticket.printTicket();

        ticket.addTicketPrice(15.3);
        System.out.printf("Ticket price: %.2f\n", ticket.getTicketPrice());
    }
}
