package streams.movies;

import java.time.LocalDate;
import java.util.List;

public class Movie {
    private String title;
    private Rating rating;
    private LocalDate releaseDate;
    private List<String> quotes;

    public Movie(String title,
                 Rating rating,
                 LocalDate releaseDate,
                 List<String> quotes) {
        this.title = title;
        this.rating = rating;
        this.releaseDate = releaseDate;
        this.quotes = quotes;
    }

    public String getTitle() {
        return title;
    }

    public Rating getRating() {
        return rating;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public List<String> getQuotes() {
        return quotes;
    }
}
