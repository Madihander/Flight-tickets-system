package CommonClasses;

import java.util.ArrayList;

public class Flight implements СommonClass {
    private int id;
    private final String departureDate;

    private final String departure;
    private final String arrival;

    private final String startTime;
    private final String endTime;

    private final int cost;

    public Flight(String departureDate, String departure, String arrival,
                  String startTime, String endTime, int cost) {
        this.departure = departure;
        this.departureDate = departureDate;
        this.arrival = arrival;

        this.startTime = startTime;
        this.endTime = endTime;

        this.cost = cost;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getDepartureDate() {
        return departureDate;
    }
    public String  getDeparture () {
        return departure;
    }

    public String getArrival() {
        return arrival;
    }

    public String getStartTime() {
        return startTime;
    }
    public String getEndTime() {
        return startTime;
    }

    public int getCost() {
        return cost;
    }



    @Override
    public ArrayList<String> printInfo() {
        ArrayList<String> data = new ArrayList<String>();
        data.add(this.departureDate);
        data.add(this.departure);
        data.add(this.arrival);
        data.add(this.startTime);
        data.add(this.endTime);
        data.add(String.valueOf(this.cost));
        return data;
    }
}
