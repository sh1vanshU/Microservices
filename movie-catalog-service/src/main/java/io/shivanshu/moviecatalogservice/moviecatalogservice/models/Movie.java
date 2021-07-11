package io.shivanshu.moviecatalogservice.moviecatalogservice.models;

public class Movie {
    private String movieId;
    private String name;
    private String description;
    
    // you requried to add Movie empty constructor because here we override three parameters constructor. so spring will required empty c
    // constructor to create object.
    // this empty constructor helps us in getting restTemplate object through getForObject method.

    public Movie() {
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Movie(String movieId, String name, String description) {
        this.movieId = movieId;
        this.name = name;
        this.description = description;
    }
    public String getMovieId() {
        return movieId;
    }
    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    
}
