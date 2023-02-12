public class Ticket {
    private final int idCustomer;
    private final int place;
    private final int number;
    private final int numberFlight;
    private final int price;
    private final String timeCreated;


    public Ticket(int idCustomer, int place, int number, int numberFlight, int price, String timeCreated) {
        this.idCustomer = idCustomer;
        this.place = place;
        this.number = number;
        this.numberFlight = numberFlight;

        this.price = price;
        this.timeCreated = timeCreated;
    }

    public int getCustomer() {
        return idCustomer;
    }

    public int getPlace() {
        return place;
    }

    public int getNumber() {
        return number;
    }

    public int getNumberFlight() {
        return numberFlight;
    }

    public int getPrice() {
        return price;
    }

    public String getTimeCreated() {
        return timeCreated;
    }
}


