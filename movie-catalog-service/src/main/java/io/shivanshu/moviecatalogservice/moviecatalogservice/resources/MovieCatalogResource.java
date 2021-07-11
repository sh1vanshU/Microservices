package io.shivanshu.moviecatalogservice.moviecatalogservice.resources;

// import java.util.Arrays;
// import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.shivanshu.moviecatalogservice.moviecatalogservice.models.CatalogItem;
import io.shivanshu.moviecatalogservice.moviecatalogservice.models.Movie;
// import io.shivanshsu.moviecatalogservice.moviecatalogservice.models.Rating;
import io.shivanshu.moviecatalogservice.moviecatalogservice.models.UserCatalog;
// import io.shivanshu.moviecatalogservice.moviecatalogservice.models.Rating;
import io.shivanshu.moviecatalogservice.moviecatalogservice.models.UserRating;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/{userId}")
    public UserCatalog getCatalog(@PathVariable("userId") String userId) {

        // RestTemplate restTemplate=new RestTemplate();
        // Get all rated movie IDs

        // List<Rating> ratings=Arrays.asList(
        // new Rating("1234", 4),
        // new Rating("5678", 3)
        // );
        UserRating userRatings = restTemplate.getForObject("http://rating-info-service:8083/ratingsdata/users/" + userId,
                UserRating.class);

        UserCatalog userCatalog = new UserCatalog();
        userCatalog.setUserCatalog(userRatings.getUserRatings().stream().map(rating -> {
            // for each movie id and , call movie info service and get details.
            Movie movie = restTemplate.getForObject("http://movie-info-service:8082/movies/" + rating.getMovieId(), Movie.class);
            // put them all together.
            return new CatalogItem(movie.getMovieId(), movie.getDescription(), rating.getRating());
        }).collect(Collectors.toList()));
        return userCatalog;

        // return Collections.singletonList(new CatalogItem("name", "desc", 5));
    }
}
