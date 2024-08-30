import javax.sound.midi.Soundbank;
import java.util.Date;

public class Ticket {
    private char[] id = {};
    private char[] concertHall = {};
    private int eventCode = -1;
    private long time = 0;
    private boolean isPromo = false;
    private char stadiumSector = ' ';
    private double maxBackpackWeight = -1;
    private long ticketCreationTime = 0;
    private double tickerPrice = 0;

    public Ticket() {
    }

    public Ticket(char[] idInput, char[] concertHallInput, int eventCodeInput, Date timeInput,
                  boolean isPromoInput, char stadiumSectorInput, double maxBackpackWeightInput) {
        if (idInput.length <= 4) {
            this.id = idInput;
        }
        if (concertHallInput.length <= 10) {
            this.concertHall = concertHallInput;
        }
        if (0 <= eventCodeInput && eventCodeInput < 1000) {
            this.eventCode = eventCodeInput;
        }
        this.time = timeInput.getTime();
        this.isPromo = isPromoInput;
        if (stadiumSectorInput == 'A' | stadiumSectorInput == 'B' | stadiumSectorInput == 'C') {
            this.stadiumSector = stadiumSectorInput;
        }
        if (maxBackpackWeightInput >= 0) {
            this.maxBackpackWeight = maxBackpackWeightInput;
        }
        this.ticketCreationTime = new Date().getTime();
    }

    public Ticket(char[] concertHallInput, Date timeInput, int eventCodeInput) {

        if (concertHallInput.length <= 10) {
            this.concertHall = concertHallInput;
        }
        if (0 <= eventCodeInput && eventCodeInput < 1000) {
            this.eventCode = eventCodeInput;
        }
        this.time = timeInput.getTime();
        this.ticketCreationTime = new Date().getTime();

    }

    public void printTicket() {
        System.out.println("_______________________________________");
        if (this.eventCode == -1) {
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
        if (priceInput >= 0) {
            this.tickerPrice = priceInput;
        }
    }

    public double getTicketPrice() {
        return this.tickerPrice;
    }
}
