package comparableComparator.main;

public class Flight implements Comparable<Flight> {
    public String airline;
    public double fare;

    public Flight(String airline, double fare) {
        this.airline = airline;
        this.fare = fare;
    }

    @Override
    public int compareTo(Flight f) {
//        return Double.compare(this.fare, f.fare);
        //decending
        return Double.compare(f.fare, this.fare);
    }

}
