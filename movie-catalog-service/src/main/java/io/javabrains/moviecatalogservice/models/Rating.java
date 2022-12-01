package io.javabrains.moviecatalogservice.models;

public class Rating {
    public Rating(String movieId, int rating) {
        this.movieId = movieId;
        this.rating = rating;
    }
    public Rating() {
    }
    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    private String movieId;
    private int rating;
}
