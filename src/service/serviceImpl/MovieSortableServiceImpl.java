package service.serviceImpl;

import model.DataBase;
import model.Movie;
import model.Producer;
import service.MovieSortableService;

import java.util.Comparator;

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
            Comparator<Movie> movieComparator = Comparator.comparing(Movie::getYear);
            DataBase.movies.sort(movieComparator);
            System.out.println(DataBase.movies);
        } else if (ascOrDesc.equalsIgnoreCase("Descending")) {
            Comparator<Movie> movieComparator = Comparator.comparing(Movie::getYear).reversed();
            DataBase.movies.sort(movieComparator);
            System.out.println(DataBase.movies);
        } else {
            System.err.println(" write again");
        }
    }

    @Override
    public void sortByProducer(String nameOrLastName) {
        for (Movie movie : DataBase.movies) {
            if (nameOrLastName.equalsIgnoreCase("Name") ) {
                Comparator<Movie> movieComparator = Comparator.comparing(Movie::getName);
               DataBase.movies.sort(movieComparator);
                System.out.println(movie.getProducer());
            }else if (nameOrLastName.equalsIgnoreCase("last name")){
                Comparator<Movie>movieComparator = Comparator.comparing(Movie::getName);
                DataBase.movies.sort(movieComparator);
                System.out.println(movie.getProducer());
                }
            }
        }
    }


