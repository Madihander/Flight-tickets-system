package CommonClasses;

import java.util.ArrayList;

public class Flight implements СommonClass {
    private final int number;
    private final String localAirport;
    private final String departureDate;

    private final String departure;
    private final String arrival;

    private final String startTime;
    private final String endTime;

    private final int cost;

    private int Places;


    public Flight(int number, String localAirport, String departureDate, String departure, String arrival, String startTime, String endTime, int cost, int Places) {
        this.number = number;
        this.localAirport = localAirport;
        this.departureDate = departureDate;
        this.departure = departure;
        this.arrival = arrival;

        this.startTime = startTime;
        this.endTime = endTime;

        this.cost = cost;
        this.Places = Places;
    }
    public int getNumber() {
        return number;
    }
    public String getLocalAirport() {
        return localAirport;
    }
    public String getDepartureDate() {
        return departureDate;
    }
    public String getDeparture() {
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


    public int getPlaces() {
        return Places;
    }
    public void setPlaces(int places) {
        this.Places = places;
    }
    @Override
    public ArrayList<String> printInfo() {
        ArrayList<String> data = new ArrayList<String>();
        data.add(String.valueOf(this.number));
        data.add(this.localAirport);
        data.add(this.departureDate);
        data.add(this.departure);
        data.add(this.arrival);
        data.add(this.startTime);
        data.add(this.endTime);
        data.add(String.valueOf(this.cost));
        data.add(String.valueOf(this.Places));
        return data;
    }
}
