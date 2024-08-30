import javax.sound.midi.Soundbank;
import java.util.Date;

public class Ticket {
    private char[] id = {};
    private char[] concertHall = {};
    private int eventCode;
    private long time;
    private boolean isPromo;
    private char stadiumSector;
    private double maxBackpackWeight;
    private long ticketCreationTime;
    private double tickerPrice;

    public Ticket() {
    }

    public Ticket(char[] idInput, char[] concertHallInput, int eventCodeInput, Date timeInput,
                  boolean isPromoInput, char stadiumSectorInput, double maxBackpackWeightInput) {
        this.id = idInput;

        this.concertHall = concertHallInput;
        this.eventCode = eventCodeInput;
        this.time = timeInput.getTime();
        this.isPromo = isPromoInput;
        this.stadiumSector = stadiumSectorInput;
        this.maxBackpackWeight = maxBackpackWeightInput;
        this.ticketCreationTime = new Date().getTime();
    }

    public Ticket(char[] concertHallInput, Date timeInput, int eventCodeInput) {

        this.concertHall = concertHallInput;
        this.eventCode = eventCodeInput;
        this.time = timeInput.getTime();
        this.ticketCreationTime = new Date().getTime();

    }

    public void printTicket() {
        System.out.println("_______________________________________");
        if (this.eventCode == 0) {
            System.out.println("Empty ticket");
            return;
        }
        if (this.maxBackpackWeight == -1) {
            System.out.printf("concertHall: %s,\n eventCode: %d,\n time: %s,\n ticketCreationTime: %s\n",
                    new String(this.concertHall), this.eventCode, new Date(this.time), new Date(this.ticketCreationTime));
            return;
        }
        System.out.printf("id: %s,\n concertHall: %s,\n eventCode: %d,\n time: %s,\n isPromo: %b,\n stadiumSector: %c,\n maxBackpackWeight: %.3f,\n ticketCreationTime: %s\n",
                new String(this.id), new String(this.concertHall), this.eventCode, new Date(this.time), this.isPromo,
                this.stadiumSector, this.maxBackpackWeight, new Date(this.ticketCreationTime));

    }

    public void addTicketPrice(double priceInput) {
        this.tickerPrice = priceInput;
    }

    public double getTicketPrice() {
        return this.tickerPrice;
    }
}
