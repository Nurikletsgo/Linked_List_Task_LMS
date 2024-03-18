package service.serviceImpl;

import model.DataBase;
import model.Movie;
import model.Producer;
import service.MovieSortableService;

import java.lang.reflect.Array;
import java.util.*;

public class MovieSortableServiceImpl implements MovieSortableService {
    @Override
    public void sortMovieByName(String ascOrDesc) {
        if (ascOrDesc.equalsIgnoreCase("Ascending")) {
            Comparator<Movie> movieComparator = Comparator.comparing(Movie::getName);
            DataBase.movies.sort(movieComparator);
            System.out.println(DataBase.movies);
        } else if (ascOrDesc.equalsIgnoreCase("Descending")) {
            Comparator<Movie> movieComparator = Comparator.comparing(Movie::getName).reversed();
            DataBase.movies.sort(movieComparator);
            System.out.println(DataBase.movies);
        } else {
            System.err.println(" write again");
        }
    }

    @Override
    public void sortByYear(String ascOrDesc) {
        if (ascOrDesc.equalsIgnoreCase("Ascending")) {
            DataBase.movies.sort(Comparator.comparing(Movie::getYear));
            System.out.println(DataBase.movies);
        } else if (ascOrDesc.equalsIgnoreCase("Descending")) {
            DataBase.movies.sort(Comparator.comparing(Movie::getYear).reversed());
            System.out.println(DataBase.movies);
        } else {
            System.err.println(" write again");
        }
    }

    @Override
    public void sortByProducer(String nameOrLastName) {
        if (nameOrLastName.equalsIgnoreCase("name")){
            DataBase.movies.sort(Comparator.comparing(movie -> movie.getProducer().getFirstName()));
            System.out.println(DataBase.movies);
        } else if (nameOrLastName.equalsIgnoreCase("last name")) {
            DataBase.movies.sort(Comparator.comparing(movie -> movie.getProducer().getLastName()));
            System.out.println(DataBase.movies);
        }

        }
    }