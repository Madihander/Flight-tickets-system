package CommonClasses;

import java.util.ArrayList;

public class Passenger implements СommonClass {
    private final int id;
    private double luggage;
    private double extraLuggage;
    private final int numberOrder;

    public Passenger(int id, double luggage, double extraLuggage, int numberOrder) {
        this.id = id;
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

    @Override
    public ArrayList<String> printInfo() {
        ArrayList<String> data = new ArrayList<String>();
        data.add(String.valueOf(this.luggage));
        data.add(String.valueOf(this.extraLuggage));
        data.add(String.valueOf(this.numberOrder));
        return data;
    }
}
