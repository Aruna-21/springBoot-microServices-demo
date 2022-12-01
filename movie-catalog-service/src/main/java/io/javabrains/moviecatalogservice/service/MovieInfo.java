package io.javabrains.moviecatalogservice.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import io.javabrains.moviecatalogservice.models.CatalogItem;
import io.javabrains.moviecatalogservice.models.Movie;
import io.javabrains.moviecatalogservice.models.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MovieInfo {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getFallBackUserCatalogItem")
    public CatalogItem getCatalogItem(Rating ratings) {
        Movie movie = restTemplate.getForObject("http://movie-info-service/movies/" + ratings.getMovieId(), Movie.class);
        return new CatalogItem(movie.getName(), movie.getDescription(), ratings.getRating());
    }

    public CatalogItem getFallBackUserCatalogItem(Rating ratings){
        return new CatalogItem("Movie name not found", "", ratings.getRating());
    }
}
