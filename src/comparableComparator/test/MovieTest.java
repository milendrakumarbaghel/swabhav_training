package comparableComparator.test;

import comparableComparator.main.Movie;
import comparableComparator.main.MovieComparator;

import java.util.*;

public class MovieTest {
    static void main() {
        Scanner scanner = new Scanner(System.in);

//        System.out.print("Enter number of movies: ");
//        int n = scanner.nextInt();
//        scanner.nextLine();

        ArrayList<Movie> movieList = new ArrayList<>();

//        movieList.add(new Movie("dark", 2021));
//        movieList.add(new Movie("from", 2022));
//        movieList.add(new Movie("kingsman", 2023));
//        movieList.add(new Movie("fallout", 2024));

        movieList.add(new Movie("from", 2022));
        movieList.add(new Movie("dark", 2022));
        movieList.add(new Movie("kingsman", 2023));
        movieList.add(new Movie("fallout", 2024));

//        for(int i = 0; i < n; i++) {
//            System.out.println("\nEnter Movie " + (i+1) + " details");
//
//            System.out.print("Title: ");
//            String title = scanner.nextLine();
//
//            System.out.print("Year: ");
//            int year = scanner.nextInt();
//            scanner.nextLine();
//
//            movieList.add(new Movie(title, year));
//        }

//        Collections.sort(movieList, new MovieComparator());

//        movieList.sort((m1, m2) -> {
//            int yearCompare = Integer.compare(m2.year, m1.year);
//            if(yearCompare != 0)
//                return yearCompare;
//            return m1.title.compareTo(m2.title);
//        });

        movieList.sort(
                Comparator.comparingInt((Movie m) -> m.year)
                        .reversed()
                        .thenComparing(m -> m.title)
        );
        System.out.println("\nMovies Sorted:");

        for(Movie m : movieList) {
            System.out.println(m.title + " - " + m.year);
        }

        scanner.close();
    }
}
