package CommonClasses;

import java.util.ArrayList;

public class Airport implements СommonClass {
    private final String title;
    private final String location;

    private ScheduledFlight scheduledFlight;

    public Airport(String title, String location) {
        this.title = title;
        this.location = location;
    }

    public String getTitle() {
        return title;
    }

    public String getLocation() {
        return location;
    }

    public ScheduledFlight getScheduledFlight() {
        return scheduledFlight;
    }

    public void setScheduledFlight(ScheduledFlight SF) {
        this.scheduledFlight = SF;
    }

    @Override
    public ArrayList<String> printInfo() {
        ArrayList<String> data = new ArrayList<String>();
        data.add(this.title);
        data.add(this.location);
        return data;
    }
}
