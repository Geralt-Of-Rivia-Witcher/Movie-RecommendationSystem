import java.io.IOException;
import java.util.*;

public class MovieRunnerSimilarRatings
{

    public static void printSimilarRatings() throws IOException
    {
        String raterId = "71";
        int numberOfMinimumRatings = 5;
        int numberOfSimilarRaters = 20;
        FourthRatings ratings = new FourthRatings();

        RaterDatabase.initialize("ratings.csv");
        System.out.println("Number of Raters : " + RaterDatabase.size());

        MovieDatabase.initialize("ratedmoviesfull.csv");
        System.out.println("Number of movies : " + MovieDatabase.size());

        ArrayList <rating> movieList = ratings.getSimilarRatings(raterId, numberOfSimilarRaters, numberOfMinimumRatings);
        System.out.println("Total Movies = " + movieList.size());
        for(rating thatRating : movieList)
        {
            System.out.println(thatRating.getValue() + " " + MovieDatabase.getTitle(thatRating.getItem()));
        }
    }

    public static void printSimilarRatingsByGenre() throws IOException
    {
        String raterId = "964";
        int numberOfMinimumRatings = 5;
        int numberOfSimilarRaters = 20;
        String genre = "Mystery";
        FourthRatings ratings = new FourthRatings();

        RaterDatabase.initialize("ratings.csv");
        System.out.println("Number of Raters : " + RaterDatabase.size());

        MovieDatabase.initialize("ratedmoviesfull.csv");
        System.out.println("Number of movies : " + MovieDatabase.size());

        ArrayList <rating> movieList = ratings.getSimilarRatingsByFilter(raterId, numberOfSimilarRaters, numberOfMinimumRatings, new GenreFilter(genre));
        System.out.println("Total Movies = " + movieList.size());
        for(rating thatRating : movieList)
        {
            System.out.println(thatRating.getValue() + " " + MovieDatabase.getTitle(thatRating.getItem()));
        }
    }

    public static void printSimilarRatingsByDirector() throws IOException
    {
        String raterId = "120";
        int numberOfMinimumRatings = 2;
        int numberOfSimilarRaters = 10;
        String director = "Clint Eastwood,J.J. Abrams,Alfred Hitchcock,Sydney Pollack,David Cronenberg,Oliver Stone,Mike Leigh";
        FourthRatings ratings = new FourthRatings();

        RaterDatabase.initialize("ratings.csv");
        System.out.println("Number of Raters : " + RaterDatabase.size());

        MovieDatabase.initialize("ratedmoviesfull.csv");
        System.out.println("Number of movies : " + MovieDatabase.size());

        ArrayList <rating> movieList = ratings.getSimilarRatingsByFilter(raterId, numberOfSimilarRaters, numberOfMinimumRatings, new DirectorsFilter(director));
        System.out.println("Total Movies = " + movieList.size());
        for(rating thatRating : movieList)
        {
            System.out.println(thatRating.getValue() + " " + MovieDatabase.getTitle(thatRating.getItem()));
        }
    }

    public static void printSimilarRatingsByGenreAndMinutes() throws IOException
    {
        String raterId = "168";
        int numberOfMinimumRatings = 3;
        int numberOfSimilarRaters = 10;
        String genre = "Drama";
        int minMinutes = 80;
        int maxMinutes = 160;
        FourthRatings ratings = new FourthRatings();

        RaterDatabase.initialize("ratings.csv");
        System.out.println("Number of Raters : " + RaterDatabase.size());

        MovieDatabase.initialize("ratedmoviesfull.csv");
        System.out.println("Number of movies : " + MovieDatabase.size());

        AllFilters filterCriteria = new AllFilters();
        filterCriteria.addFilter(new GenreFilter(genre));
        filterCriteria.addFilter(new MinutesFilter(minMinutes, maxMinutes));

        ArrayList <rating> movieList = ratings.getSimilarRatingsByFilter(raterId, numberOfSimilarRaters, numberOfMinimumRatings, filterCriteria);
        System.out.println("Total Movies = " + movieList.size());
        for(rating thatRating : movieList)
        {
            System.out.println(thatRating.getValue() + " " + MovieDatabase.getTitle(thatRating.getItem()));
        }
    }

    public static void printSimilarRatingsByYearAfterAndMinutes() throws IOException
    {
        String raterId = "314";
        int numberOfMinimumRatings = 5;
        int numberOfSimilarRaters = 10;
        int year = 1975;
        int minMinutes = 70;
        int maxMinutes = 200;
        FourthRatings ratings = new FourthRatings();

        RaterDatabase.initialize("ratings.csv");
        System.out.println("Number of Raters : " + RaterDatabase.size());

        MovieDatabase.initialize("ratedmoviesfull.csv");
        System.out.println("Number of movies : " + MovieDatabase.size());

        AllFilters filterCriteria = new AllFilters();
        filterCriteria.addFilter(new YearAfterFilter(year));
        filterCriteria.addFilter(new MinutesFilter(minMinutes, maxMinutes));

        ArrayList <rating> movieList = ratings.getSimilarRatingsByFilter(raterId, numberOfSimilarRaters, numberOfMinimumRatings, filterCriteria);
        System.out.println("Total Movies = " + movieList.size());
        for(rating thatRating : movieList)
        {
            System.out.println(thatRating.getValue() + " " + MovieDatabase.getTitle(thatRating.getItem()));
        }
    }

    public static void main(String[] args) throws IOException
    {
        printSimilarRatings();  
        //printSimilarRatingsByGenre(); 
        //printSimilarRatingsByDirector();
        //printSimilarRatingsByGenreAndMinutes();
        //printSimilarRatingsByYearAfterAndMinutes();
    }
}
