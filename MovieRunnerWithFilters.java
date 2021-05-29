import java.io.*;
import java.util.*;

public class MovieRunnerWithFilters
{
    public static void printAverageRatings() throws IOException
    {
        int numberOfMinimumRatings = 35;
        thirdRatings ratings = new thirdRatings("ratings.csv");
        System.out.println("Total number of raters = " + ratings.getRaterSize());
        MovieDatabase.initialize("ratedmoviesfull.csv");
        System.out.println("Total number of movies = " + MovieDatabase.size());
        ArrayList <rating> movieList = ratings.getAverageRatings(numberOfMinimumRatings);
        System.out.println("Total movies = " + movieList.size());
        Collections.sort(movieList);
        for(rating thatRating : movieList)
        {
            System.out.println(thatRating.getValue() + " " + thatRating.getItem());
        }
    }

    public static void printAverageRatingsByYear() throws IOException
    {
        int numberOfMinimumRatings = 20;
        thirdRatings ratings = new thirdRatings("ratings.csv");
        System.out.println("Total number of raters = " + ratings.getRaterSize());
        MovieDatabase.initialize("ratedmoviesfull.csv");
        System.out.println("Total number of movies = " + MovieDatabase.size());
        ArrayList <rating> movieList = ratings.getAverageRatingByFilters(numberOfMinimumRatings, new YearAfterFilter(2000));
        System.out.println("Total movies = " + movieList.size());
        Collections.sort(movieList);
        for(rating thatRating : movieList)
        {
            System.out.println(thatRating.getValue() + " " + MovieDatabase.getYear(thatRating.getItem()) + " " + MovieDatabase.getTitle(thatRating.getItem()));
        }
    }

    public static void printAverageRatingsByGenre() throws IOException
    {
        int numberOfMinimumRatings = 20;
        thirdRatings ratings = new thirdRatings("ratings.csv");
        System.out.println("Total number of raters = " + ratings.getRaterSize());
        MovieDatabase.initialize("ratedmoviesfull.csv");
        System.out.println("Total number of movies = " + MovieDatabase.size());
        ArrayList <rating> movieList = ratings.getAverageRatingByFilters(numberOfMinimumRatings, new GenreFilter("Comedy"));
        System.out.println("Total movies = " + movieList.size());
        Collections.sort(movieList);
        for(rating thatRating : movieList)
        {
            System.out.println(thatRating.getValue() + " " + MovieDatabase.getTitle(thatRating.getItem()));
            System.out.println("\t" + MovieDatabase.getGenres(thatRating.getItem()));
        }
    }

    public static void printAverageRatingsByMinutes() throws IOException
    {
        int numberOfMinimumRatings = 5;
        thirdRatings ratings = new thirdRatings("ratings.csv");
        System.out.println("Total number of raters = " + ratings.getRaterSize());
        MovieDatabase.initialize("ratedmoviesfull.csv");
        System.out.println("Total number of movies = " + MovieDatabase.size());
        ArrayList <rating> movieList = ratings.getAverageRatingByFilters(numberOfMinimumRatings, new MinutesFilter(105, 135));
        System.out.println("Total movies = " + movieList.size());
        Collections.sort(movieList);
        for(rating thatRating : movieList)
        {
            System.out.println(thatRating.getValue() + " Time:  " + MovieDatabase.getMinutes(thatRating.getItem()) + " " + MovieDatabase.getTitle(thatRating.getItem()));
        }
    }

    public static void printAverageRatingsByDirectors() throws IOException
    {
        int numberOfMinimumRatings = 4;
        thirdRatings ratings = new thirdRatings("ratings.csv");
        System.out.println("Total number of raters = " + ratings.getRaterSize());
        MovieDatabase.initialize("ratedmoviesfull.csv");
        System.out.println("Total number of movies = " + MovieDatabase.size());
        ArrayList <rating> movieList = ratings.getAverageRatingByFilters(numberOfMinimumRatings, new DirectorsFilter("Clint Eastwood,Joel Coen,Martin Scorsese,Roman Polanski,Nora Ephron,Ridley Scott,Sydney Pollack"));
        System.out.println("Total movies = " + movieList.size());
        Collections.sort(movieList);
        for(rating thatRating : movieList)
        {
            System.out.println(thatRating.getValue() + " " + MovieDatabase.getTitle(thatRating.getItem()));
            System.out.println("\t" + MovieDatabase.getDirector(thatRating.getItem()));
        }
    }

    public static void printAverageRatingsByYearAfterAndGenre() throws IOException
    {
        int numberOfMinimumRatings = 8;
        thirdRatings ratings = new thirdRatings("ratings.csv");
        System.out.println("Total number of Raters = " + ratings.getRaterSize());
        MovieDatabase.initialize("ratedmoviesfull.csv");
        System.out.println("Total number of movies = " + MovieDatabase.size());
        AllFilters filters = new AllFilters();
        filters.addFilter(new YearAfterFilter(1990));
        filters.addFilter(new GenreFilter("Drama"));
        ArrayList <rating> movieList = ratings.getAverageRatingByFilters(numberOfMinimumRatings, filters);
        System.out.println("Total movies = " + movieList.size());
        Collections.sort(movieList);
        for(rating thatRating : movieList)
        {
            System.out.println(thatRating.getValue() + " " + MovieDatabase.getYear(thatRating.getItem()));
            System.out.println("\t" + MovieDatabase.getGenres(thatRating.getItem()));
        }
    }

    public static void printAverageRatingsByDirectorsAndMinutes() throws IOException
    {
        int numberOfMinimumRatings = 3;
        thirdRatings ratings = new thirdRatings("ratings.csv");
        System.out.println("Total number of Raters = " + ratings.getRaterSize());
        MovieDatabase.initialize("ratedmoviesfull.csv");
        System.out.println("Total number of movies = " + MovieDatabase.size());
        AllFilters filters = new AllFilters();
        filters.addFilter(new MinutesFilter(90, 180));
        filters.addFilter(new DirectorsFilter("Clint Eastwood,Joel Coen,Tim Burton,Ron Howard,Nora Ephron,Sydney Pollack"));
        ArrayList <rating> movieList = ratings.getAverageRatingByFilters(numberOfMinimumRatings, filters);
        System.out.println("Total movies = " + movieList.size());
        Collections.sort(movieList);
        for(rating thatRating : movieList)
        {
            System.out.println(thatRating.getValue() + " Time: " + MovieDatabase.getMinutes(thatRating.getItem()) + " " + MovieDatabase.getTitle(thatRating.getItem()));
            System.out.println("\t" + MovieDatabase.getDirector(thatRating.getItem()));
        }
    }

    public static void main(String[] args) throws IOException
    {
        //printAverageRatings();
        //printAverageRatingsByYear();
        //printAverageRatingsByGenre();
        //printAverageRatingsByMinutes();
        //printAverageRatingsByDirectors();
        printAverageRatingsByYearAfterAndGenre();
        //printAverageRatingsByDirectorsAndMinutes();
    }
}