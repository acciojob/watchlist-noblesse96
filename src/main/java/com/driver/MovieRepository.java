package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

@Repository
public class MovieRepository {

    private HashMap<String, Movie> movieMap;
    private HashMap<String, Director> directorMap;
    private HashMap<String, List<String>> directorMovieMap;

    public MovieRepository() {
        this.movieMap = new HashMap<String, Movie>();
        this.directorMap = new HashMap<String, Director>();
        this.directorMovieMap = new HashMap<String, List<String>>();
    }

    public void addMovie(Movie movie){movieMap.put(movie.getName(), movie);}

    public void addDirector(Director director){directorMap.put(director.getName(),director);}

    public void directorMoviePair(String director, String movie){
        if(directorMap.containsKey(director) && movieMap.containsKey(movie)){
            List<String> currentMovies = new ArrayList<>();
            if(directorMovieMap.containsKey(director)) currentMovies = directorMovieMap.get(director);

            currentMovies.add(movie);
            directorMovieMap.put(director, currentMovies);
        }
    }

    public Movie getMovie(String movie){
        return movieMap.get(movie);
    }

    public List<String> getMovies(){
        List<Movie> moviesList = new ArrayList<>();
//        for(String movieName:movieMap.keySet()){
//            moviesList.add(movieMap.get(movieName));
//        }
        return new ArrayList<>(movieMap.keySet());
    }

    public Director getDirectorbyName(String directorName){
        return directorMap.get(directorName);
    }

    public List<String> getMoviesByDirector(String directorName){
        return directorMovieMap.get(directorName);
    }


    public void deleteDirectorByName(String director){
        List<String> movies = new ArrayList<>();
        if(directorMovieMap.containsKey(director)){
            movies = directorMovieMap.get(director);

            for(String movie: movies){
                if(movieMap.containsKey(movie))
                    movieMap.remove(movie);
            }

            directorMovieMap.remove(director);
        }

        if(directorMap.containsKey(director)) directorMap.remove(director);
    }

    public void deleteAllDirectors(){

        HashSet<String> movies = new HashSet<>();

        for(String directorName: directorMovieMap.keySet()){
            for(String movieName : directorMovieMap.get(directorName)){
                movies.add(movieName);
            }
        }

        for(String movie : movies){
            if(movieMap.containsKey(movie)) movieMap.remove(movie);
        }

        directorMap.clear();
        directorMovieMap.clear();

    }
}
