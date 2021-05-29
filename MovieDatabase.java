import java.io.IOException;
import java.util.*;

public class MovieDatabase
{
    private static HashMap <String, movie> ourMovies;

    public static void initialize(String moviefile) throws IOException
    {
        if (ourMovies == null)
        {
            ourMovies = new HashMap <String, movie>();
            loadMovies(moviefile);
        }
    }

    private static void initialize() throws IOException
    {
        if (ourMovies == null)
        {
            ourMovies = new HashMap <String, movie>();
            loadMovies("ratedmoviesfull.csv");
        }
    }	

    private static void loadMovies(String filename) throws IOException
    {
        firstRatings ratings = new firstRatings();
        ArrayList <movie> movies = ratings.loadMovies(filename);
        for (movie myMovie : movies)
        {
            ourMovies.put(myMovie.getID(), myMovie);
        }
    }

    public static boolean containsID(String movieID) throws IOException
    {
        initialize();
        return ourMovies.containsKey(movieID);
    }

    public static int getYear(String movieID) throws IOException
    {
        initialize();
        return ourMovies.get(movieID).getYear();
    }

    public static String getGenres(String movieID) throws IOException
    {
        initialize();
        return ourMovies.get(movieID).getGenres();
    }

    public static String getTitle(String movieID) throws IOException
    {
        initialize();
        return ourMovies.get(movieID).getTitle();
    }

    public static movie getMovie(String movieID) throws IOException
    {
        initialize();
        return ourMovies.get(movieID);
    }

    public static String getPoster(String movieID) throws IOException
    {
        initialize();
        return ourMovies.get(movieID).getPoster();
    }

    public static int getMinutes(String movieID) throws IOException
    {
        initialize();
        return ourMovies.get(movieID).getMinutes();
    }

    public static String getCountry(String movieID) throws IOException
    {
        initialize();
        return ourMovies.get(movieID).getCountry();
    }

    public static String getDirector(String movieID) throws IOException
    {
        initialize();
        return ourMovies.get(movieID).getDirector();
    }

    public static int size()
    {
        return ourMovies.size();
    }

    public static ArrayList <String> filterBy(Filter f) throws IOException
    {
        initialize();
        ArrayList <String> movieList = new ArrayList <String>();
        for(String id : ourMovies.keySet()) {
            if (f.satisfies(id))
            {
                movieList.add(id);
            }
        }
        return movieList;
    }
}