package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("movies")
public class MovieController {

    @Autowired
    MovieService movieService;

    @PostMapping("/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody Movie movie){
        movieService.addMovie(movie);
        return new ResponseEntity<>("New movie added", HttpStatus.CREATED);
    }

    @PostMapping("/add-director")
    public ResponseEntity<String> addDirector(@RequestBody Director director){
        movieService.addDirector(director);
        return new ResponseEntity<>("New director has been added", HttpStatus.CREATED);
    }

    @PutMapping("/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam String movie, @RequestParam String director){
        movieService.addDirectorMoviePair(director, movie);
        return new ResponseEntity<>("New movie director pair has been created", HttpStatus.CREATED);
    }

    @GetMapping("/get-movie-by-name/{movieName}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable String movieName){
        return new ResponseEntity<>(movieService.getMovieByName(movieName), HttpStatus.CREATED);
    }

    @GetMapping("/get-all-movies")
    public ResponseEntity<List<String>> findAllMovies(){
        List<String> allMovies =  movieService.getMovies();
        return new ResponseEntity<>(allMovies, HttpStatus.CREATED);
    }

    @GetMapping("/get-director-by-name/{directorName}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable String directorName){
        Director director = movieService.getDirectorByName(directorName);
        return new ResponseEntity<>(director, HttpStatus.CREATED);
    }

    @GetMapping("/get-movies-by-director/{directorName}")
    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable String directorName){
        List<String> moviesByDirector = movieService.getMoviesByDirector(directorName);
        return new ResponseEntity<>(moviesByDirector, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam String directorName){
        movieService.deleteDirectorByName(directorName);
        return new ResponseEntity<>("Successfully deleted" + directorName + " and his/her movies", HttpStatus.CREATED);
    }

    @DeleteMapping("/delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors(){
        movieService.deleteAllDirectors();
        return new ResponseEntity<>("All directors and their movies removed", HttpStatus.CREATED);
    }



}
