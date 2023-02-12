public class Airport {
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
}
