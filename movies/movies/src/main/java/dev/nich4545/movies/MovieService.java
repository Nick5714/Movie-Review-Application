package dev.nich4545.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    // To prevent the need to instantialize movieRepository by letting the framework do it on its own
    @Autowired
    private MovieRepository movieRepository;
    public List<Movie> allMovies(){
    return movieRepository.findAll();
    }
}
