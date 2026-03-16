package comparableComparator.main;

import java.util.Comparator;

public class MovieComparator implements Comparator<Movie> {

    public int compare(Movie m1, Movie m2) {
        int year = m2.year - m1.year;

        if(year != 0) {
            return year;
        }

        return m1.title.compareTo(m2.title);
    }

}
