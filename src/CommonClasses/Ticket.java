package CommonClasses;

import java.util.ArrayList;

public class Ticket implements СommonClass{
    private final int idCustomer;
    private int idTicket;
    private final int place;
    private final int numberFlight;
    private final int price;

    public Ticket(int idCustomer, int place, int numberFlight, int price) {
        this.idCustomer = idCustomer;
        this.place = place;
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


    public int getNumberFlight() {
        return numberFlight;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public ArrayList<String> printInfo() {
        ArrayList<String> data = new ArrayList<String>();
        data.add(String.valueOf(this.idCustomer));
        data.add(String.valueOf(this.place));
        data.add(String.valueOf(this.numberFlight));
        data.add(String.valueOf(this.price));
        return data;
    }
}


