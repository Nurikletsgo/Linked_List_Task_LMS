import model.Actor;
import model.DataBase;
import model.Movie;
import model.Producer;
import model.enums.Genre;
import service.serviceImpl.MovieFindableServiceImpl;
import service.serviceImpl.MovieSortableServiceImpl;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
/** Main де кайсыл иш аракетти аткаргыбыз келсе ошол метод switch case аркылуу чакырылып иштесин.

 Бардык маалыматтар туура жана так болуп консольго чыксын.*/
        MovieFindableServiceImpl movieFindableService = new MovieFindableServiceImpl();
        MovieSortableServiceImpl movieSortableService = new MovieSortableServiceImpl();


        List<Actor> actors1 = Arrays.asList(
                new Actor("Тим Роббинс ", "Энди Дюфрейна"),
                new Actor("Морган Фримен", "Эллиса Реддинга"),
                new Actor("Боб Гантон ", "Сэмюэла Нортона"),
                new Actor("Уильям Сэдлер ", "Хейвуда"),
                new Actor("Клэнси Браун ", "капитана Байрона Хэдли"));
        Producer producer1 = new Producer("Лайнс", "Гудман");
        Movie movie1 = new Movie("Побег из Шоушенка", LocalDate.of(1994, 3, 12), Genre.DRAMA, producer1, actors1);
        DataBase.movies.add(movie1);


        List<Actor> actors2 = Arrays.asList(
                new Actor("Кит Харингтон", "Джон Сноу"),
                new Actor("Эмилия Кларк", "Дейенерис Таргариен"),
                new Actor("Питер Динклэйдж ", "Тирион Ланнистер"),
                new Actor("Лина Хиди ", "Серсея Ланнистер"),
                new Actor("Николай Костер-Вальдау", " Джейме Ланнистер"));
        Producer producer2 = new Producer("Дэвид", "Бениофф");
        Movie movie2 = new Movie("Игра престолов", LocalDate.of(2011, 6, 6), Genre.SCIENCE_FICTION, producer2, actors2);
        DataBase.movies.add(movie2);

        List<Actor> actors3 = Arrays.asList(
                new Actor("Ray Romano", "Мэнни"),
                new Actor("John Leguizamo ", "Сид"),
                new Actor("Denis Leary", "Диего"),
                new Actor("Queen Latifah ", "Элли"),
                new Actor("Chris Wedge ", "Скрата"),
                new Actor("Goran Visnjic ", "Саккера"));
        Producer producer3 = new Producer("Лори", "Форте");
        Movie movie3 = new Movie("Ледниковый период", LocalDate.of(2002, 8, 8), Genre.ANIMATION, producer3, actors3);
        DataBase.movies.add(movie3);

        List<Actor> actors4 = Arrays.asList(
                new Actor("Скотт Эдкинс", "Юрий Бойка"),
                new Actor("Теодора Духовникова", "Альма"),
                new Actor("Альона Амилова", "Кирженцев"),
                new Actor("Юлиан Вергов", "Слава"),
                new Actor("Броок Дженнер", "Гага"));
        Producer producer4 = new Producer("Иван", "Савов");
        Movie movie4 = new Movie("Бойка нерушимый", LocalDate.of(2016, 8, 9), Genre.ACTION, producer4, actors4);
        DataBase.movies.add(movie4);

        List<Actor> actors5 = Arrays.asList(
                new Actor("Джонни Депп","Джек Воробей"),
                new Actor("Орландо Блум","Уилл Тернер"),
                new Actor("Кира Найтли","Элизабет Суон"),
                new Actor("Джеффри Раш","Капитан Гектор Барбосса"),
                new Actor("Джонатан Прайс"," Губернатор Свенгали"),
                new Actor("Джек Давенпорт"," Норрингтон"));
        Producer producer5 = new Producer("Джерри","Брукхаймер");
        Movie movie5 = new Movie("Пираты Карибского моря",LocalDate.of( 2003,4,4),Genre.ADVENTURE,producer5,actors5);
        DataBase.movies.add(movie5);

        while (true){
            System.out.println("""
                           GET MOVIES
                    1. get all movies
                    2. get movie by name
                    3. get movie by actor name
                    4. get movie by foundation year
                    5. get movie by producer name
                    6. get movie by genre
                    7. get movie by role
                           SORT MOVIES
                    8. sort movie by name
                    9. sort movie by year ( ascending - descending)
                    10.sort movie by producer
                    """);
            try {
                switch (new Scanner(System.in).nextInt()){
                    case 1:
                        System.out.println(movieFindableService.getAllMovies());
                        break;
                    case 2:
                        System.out.println("write movie name " + "\n(Игра престолов-Ледниковый период-Бойка нерушимый-Побег из Шоушенка-Пираты Карибского моря)");
                        System.out.println(movieFindableService.findMovieByFullNameOrPartName(new Scanner(System.in).nextLine()));
                        break;
                    case 3:
                        System.out.println("write actor full name (писать на русском)");
                        System.out.println(movieFindableService.findMovieByActorName(new Scanner(System.in).nextLine()));
                        break;
                    case 4:
                        System.out.println("write movie foundation year - mont - day");
                        LocalDate localDate = LocalDate.of(new Scanner(System.in).nextInt(),new Scanner(System.in).nextInt(),new Scanner(System.in).nextInt());
                        System.out.println(movieFindableService.findMovieByYear(localDate));
                        break;
                    case 5:
                        System.out.println("write producer name ");
                        System.out.println(movieFindableService.findMovieByProducer(new Scanner(System.in).nextLine()));
                        break;
                    case 6:
                        System.out.println("write movie genre"+Arrays.toString(Genre.values()));
                        System.out.println(movieFindableService.findMovieByGenre(Genre.valueOf(new Scanner(System.in).nextLine())));
                        break;
                    case 7:
                        System.out.println("write actor role");
                        System.out.println(movieFindableService.findMovieByRole(new Scanner(System.in).nextLine()));
                        break;
                    case 8:
                        System.out.println("choose type of variety movie name, write --> ( ascending or descending)");
                        movieSortableService.sortMovieByName(new Scanner(System.in).nextLine());
                        break;
                    case 9:
                        System.out.println("choose type of variety movie year, write --> ( ascending or descending)");
                        movieSortableService.sortByYear(new Scanner(System.in).nextLine());
                        break;
                    case 10:
                        System.out.println("choose type of variety  movie by producer ,write --> (name or last name) ");
                        movieSortableService.sortByProducer(new Scanner(System.in).nextLine());
                        break;
                    default:
                        System.out.println("write again");
                }
            }catch (Exception e){
                System.err.println("write again (exception main)");
            }
        }

    }
}