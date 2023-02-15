package CommonClasses;

public class Ticket {
    private final int idCustomer;
    private int idTicket;
    private final int place;
    private final int number;
    private final int numberFlight;
    private final int price;

    public Ticket(int idCustomer, int place, int number, int numberFlight, int price) {
        this.idCustomer = idCustomer;
        this.place = place;
        this.number = number;
        this.numberFlight = numberFlight;

        this.price = price;
    }

    public void setIdTicket(int id){
        this.idTicket=id;
    }

    public int getIdTicket() {
        return idTicket;
    }

    public int getIdCustomer() {
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
}


