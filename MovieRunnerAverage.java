import java.io.IOException;
import java.util.*;

public class MovieRunnerAverage
{
    public static void printAverageRatings() throws IOException
    {
        int numberOfMinimumRatings = 12;
        secondRatings ratings = new secondRatings("ratedmoviesfull.csv", "ratings.csv");
        System.out.println("Total number of movies = " + ratings.getMovieSize());
        System.out.println("Total number of raters = " + ratings.getRaterSize());

        ArrayList <rating> movieList = ratings.getAverageRatings(numberOfMinimumRatings);
        System.out.println(movieList.size());
        Collections.sort(movieList);
        for(rating thatRating : movieList)
        {
            System.out.println(thatRating.getValue() + " " + ratings.getTitle(thatRating.getItem()));
        }
    }

    public static void getAverageRatingOneMovie() throws IOException
    {
        String movieName = "Vacation";
        secondRatings ratings = new secondRatings("ratedmoviesfull.csv", "ratings.csv");
        String movieID = ratings.getID(movieName);
        System.out.println(movieName + " = " + ratings.getAverageByID(movieID, 1));
    }

    public static void main(String[] args) throws IOException
    {
        //printAverageRatings();
        //getAverageRatingOneMovie();
    }
}