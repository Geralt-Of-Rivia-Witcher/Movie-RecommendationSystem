import java.io.IOException;
import java.util.ArrayList;

public class secondRatings
{
    private ArrayList <movie> myMovies;
    private ArrayList <rater> myRaters;

    public secondRatings(String moviefile, String ratingfile) throws IOException
    {
        firstRatings rating = new firstRatings();
        myMovies = rating.loadMovies(moviefile);
        myRaters = rating.loadRaters(ratingfile);
    }

    public int getMovieSize()
    {
        return myMovies.size();
    }

    public int getRaterSize()
    {
        return myRaters.size();
    }

    public double getAverageByID(String movieID, int minimalRaters)
    {
        double sum = 0.0;
        int count = 0;
        for(rater myRater : myRaters)
        {
            ArrayList <String> movieList = myRater.getItemsRated();
            if(movieList.contains(movieID))
            {
                count++;
                sum += myRater.getRating(movieID);
            }
        }
        if(count >= minimalRaters)
        {
            return sum/count;
        }
        return 0.0;
    }

    public ArrayList <rating> getAverageRatings(int minimalRaters)
    {
        ArrayList <rating> ratings = new ArrayList <rating>();
        for(movie myMovie : myMovies)
        {
            double rating = getAverageByID(myMovie.getID(), minimalRaters);
            if(rating != 0.0)
            {
                rating Rating = new rating(myMovie.getID(), rating);
                ratings.add(Rating);
            }
        }
        return ratings;
    }

    public String getTitle(String movieID)
    {
        for(movie myMovie : myMovies)
        {
            if(myMovie.getID().equals(movieID))
            {
                return myMovie.getTitle();
            }
        }
        return "ID NOT FOUND";
    }

    public String getID(String title)
    {
        for(movie myMovie : myMovies)
        {
            if(myMovie.getTitle().equals(title))
            {
                return myMovie.getID();
            }
        }
        return "NO SUCH TITLE";
    }


}