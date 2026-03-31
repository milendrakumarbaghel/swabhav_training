package streamAPI.streamAPIAssignment.transportRoutePassengerSystem;

import java.util.Objects;

public class Passenger {
    private int passengerId;
    private String name;
    private int routeNo;
    private double fare;
    private String ticketType;
    private boolean checkedIn;

    public Passenger(int passengerId, String name, int routeNo,
                     double fare, String ticketType, boolean checkedIn) {
        this.passengerId = passengerId;
        this.name = name;
        this.routeNo = routeNo;
        this.fare = fare;
        this.ticketType = ticketType;
        this.checkedIn = checkedIn;
    }

    public int getPassengerId() { return passengerId; }
    public String getName() { return name; }
    public int getRouteNo() { return routeNo; }
    public double getFare() { return fare; }
    public String getTicketType() { return ticketType; }
    public boolean isCheckedIn() { return checkedIn; }

    public void setCheckedIn(boolean checkedIn) {
        this.checkedIn = checkedIn;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "id=" + passengerId +
                ", name='" + name + '\'' +
                ", routeNo=" + routeNo +
                ", fare=" + fare +
                ", ticketType='" + ticketType + '\'' +
                ", checkedIn=" + checkedIn +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Passenger)) return false;
        Passenger that = (Passenger) o;
        return passengerId == that.passengerId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(passengerId);
    }
}
