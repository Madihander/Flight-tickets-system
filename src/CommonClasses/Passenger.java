package CommonClasses;

import CommonClasses.Customer;

public class Passenger extends Customer {
    private double luggage;
    private double extraLuggage;
    private final int numberOrder;

    public Passenger(String email, String name, String phoneNumber, double luggage, double extraLuggage,int numberOrder) {
        super(email, name, phoneNumber);
        this.luggage = luggage;
        this.extraLuggage = extraLuggage;
        this.numberOrder =numberOrder;
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

    public int getNumberOrder() {
        return numberOrder;
    }
}
