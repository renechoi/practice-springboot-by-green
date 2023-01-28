package day4.theater;

import java.util.Arrays;
import java.util.List;

public class Theater {
    private String theaterName;
    private List<Seat> seats;

    public Theater(String theaterName) {
        this(theaterName, new Seat("unKnown"));
    }

    public Theater(String theaterName, Seat... seats) {
        this.theaterName = theaterName;
        this.seats = Arrays.asList(seats);
    }

}
