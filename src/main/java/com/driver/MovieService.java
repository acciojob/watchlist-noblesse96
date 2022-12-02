package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;

    public void addMovie(Movie movie){
        movieRepository.addMovie(movie);
    }

    public void addDirector(Director director){
        movieRepository.addDirector(director);
    }

    public void addDirectorMoviePair(String director, String movie){
        movieRepository.directorMoviePair(director, movie);
    }

    public Movie getMovie(String movie){
        return movieRepository.getMovie(movie);
    }

    public List<String> getMovies(){
        return movieRepository.getMovies();
    }

    public Director getDirectorByName(String directorName){
        return movieRepository.getDirectorbyName(directorName);
    }

    public List<String> getMoviesByDirector(String directorName){
        return movieRepository.getMoviesByDirector(directorName);
    }

    public void deleteDirectorByName(String directorName){
        movieRepository.deleteDirectorByName(directorName);
    }

    public void deleteAllDirectors(){
        movieRepository.deleteAllDirectors();
    }





}
