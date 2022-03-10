package streams.movies;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static streams.movies.Provider.greatActionMovies;
import static streams.movies.Rating.GREAT;

public class Solution {
    private static class Pair<T, U> {
        public Pair(T first, U second) {
            this.first = first;
            this.second = second;
        }

        private final T first;
        private final U second;
    }

    public static void main(String[] args) {
        List<Movie> movies = greatActionMovies();
        allTheMovieTitles(movies);
        allTheGreatMovieTitles(movies);
        titleAndRatingOfMoviesFrom1984(movies);
        allTheQuotes(movies);
        averageQuoteLength(movies);
        moviesListedByDecade(movies);
        moviesGroupedByRating(movies);
    }

    private static void allTheMovieTitles(List<Movie> movies) {
        System.out.println("The titles of all the movies");
        movies.stream()
                .map(Movie::getTitle)
                .forEach(Solution::printTabbed);
    }

    private static void allTheGreatMovieTitles(List<Movie> movies) {
        System.out.println("Titles of all the movies with a rating of GREAT");
        movies.stream()
                .filter(m -> m.getRating() == GREAT)
                .map(Movie::getTitle)
                .forEach(Solution::printTabbed);
    }

    private static void titleAndRatingOfMoviesFrom1984(List<Movie> movies) {
        System.out.println("Title and rating of movies released in 1984");
        movies.stream()
                .filter(m -> m.getReleaseDate().getYear() == 1984)
                .map(m -> new Pair<>(m.getTitle(), m.getRating()))
                .forEach(p -> System.out.printf("\t%s rated %s\n", p.first, p.second));

    }

    private static void allTheQuotes(List<Movie> movies) {
        System.out.println("All the quotes");
        movies.stream()
                .flatMap(m -> m.getQuotes().stream())
                .forEach(Solution::printTabbed);
    }

    private static void averageQuoteLength(List<Movie> movies) {
        System.out.println("The average length of a quote is");
        double result = movies.stream()
                .flatMap(m -> m.getQuotes().stream())
                .mapToInt(String::length)
                .average().orElse(0.0);
        System.out.printf("\t%.2f\n", result);

    }

    private static void moviesListedByDecade(List<Movie> movies) {
        Map<Boolean, List<Movie>> results = movies.stream()
                .collect(Collectors.partitioningBy(m -> m.getReleaseDate().getYear() < 1990));

        System.out.println("The titles of all the movies from the 1980s");
        results.get(true)
                .stream()
                .map(Movie::getTitle)
                .forEach(Solution::printTabbed);

        System.out.println("The titles of all the movies from the 1990s");
        results.get(false)
                .stream()
                .map(Movie::getTitle)
                .forEach(Solution::printTabbed);
    }

    private static void moviesGroupedByRating(List<Movie> movies) {
        System.out.println("The movies grouped by their rating:");
        movies.stream()
                .collect(Collectors.groupingBy(Movie::getRating))
                .forEach((rating, moviesOfType) -> {
                    System.out.printf("\tMovies with a rating of %s\n", rating);
                    moviesOfType.stream().map(Movie::getTitle)
                            .forEach(t -> System.out.printf("\t\t%s\n", t));
                });
    }

    private static void printTabbed(String input) {
        System.out.printf("\t%s\n", input);
    }

}
