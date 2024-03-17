package service.serviceImpl;

import model.Actor;
import model.DataBase;
import model.enums.Genre;
import model.Movie;
import service.MovieFindableService;

import java.time.LocalDate;
import java.util.List;

public class MovieFindableServiceImpl implements MovieFindableService {
    @Override
    public List<Movie> getAllMovies() {
        return DataBase.movies;
    }

    @Override
    public Movie findMovieByFullNameOrPartName(String name) {
        for (Movie movie : DataBase.movies) {
            if (movie.getName().equalsIgnoreCase(name)) {
                return movie;
            }
        }
        return null;
    }

    @Override
    public Movie findMovieByActorName(String actorName) {
        for (Movie movie : DataBase.movies) {
            for (Actor actor : movie.getActors()) {
                if (actor.getActorFullName().equalsIgnoreCase(actorName)) {
                    return movie;
                }
            }
        }
        return null;
    }

    @Override
    public Movie findMovieByYear(LocalDate year) {
        for (Movie movie : DataBase.movies){
            if (movie.getYear().equals(year)){
                return  movie;
            }
        }
        return null;
    }

    @Override
    public Movie findMovieByProducer(String producerFullName) {
        for (Movie movie : DataBase.movies){
            if (movie.getProducer().getLastName().equalsIgnoreCase(producerFullName) || movie.getProducer().getFirstName().equalsIgnoreCase(producerFullName)){
                return movie;
            }
        }
        return null;
    }

    @Override
    public Movie findMovieByGenre(Genre genre) {
        for (Movie movie : DataBase.movies){
            if (movie.getGenre().equals(genre)){
                return  movie;
            }
        }
            return null;
    }

    @Override
    public Movie findMovieByRole(String role) {
        for (Movie movie : DataBase.movies) {
            for (Actor actor : movie.getActors()) {
                if (actor.getRole().equalsIgnoreCase(role)) {
                    return movie;
                }
            }
        }
        return null;
    }
}
