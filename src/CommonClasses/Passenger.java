package CommonClasses;

import java.util.ArrayList;

public class Passenger implements СommonClass {
    private int id;
    private double luggage;
    private double extraLuggage;
    private final int numberTicket;

    public Passenger(double luggage, double extraLuggage, int numberTicket) {
        this.luggage = luggage;
        this.extraLuggage = extraLuggage;
        this.numberTicket =numberTicket;
    }
    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return this.id;
    }
    public void setLuggage(double num) {
        this.luggage = num;
    }

    public void setExtraLuggage(double extraLuggage) {
        this.extraLuggage = extraLuggage;
    }

    public double getLuggage() {
        return luggage;
    }
    public double getExtraLuggage() {
        return extraLuggage;
    }

    public int getNumberTicket() {
        return numberTicket;
    }

    @Override
    public ArrayList<String> printInfo() {
        ArrayList<String> data = new ArrayList<String>();
        data.add(String.valueOf(this.numberTicket));
        data.add(String.valueOf(this.luggage));
        data.add(String.valueOf(this.extraLuggage));
        return data;
    }
}
