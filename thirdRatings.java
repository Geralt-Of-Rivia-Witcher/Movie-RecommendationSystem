import java.io.IOException;
import java.util.ArrayList;

public class thirdRatings
{
    private ArrayList <rater> myRaters;

    public thirdRatings(String ratingfile) throws IOException
    {
        firstRatings rating = new firstRatings();
        myRaters = rating.loadRaters(ratingfile);
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

    public ArrayList <rating> getAverageRatings(int minimalRaters) throws IOException
    {
        ArrayList <String> movies = MovieDatabase.filterBy(new TrueFilter());
        ArrayList <rating> ratings = new ArrayList <rating>();
        for(String movieID : movies)
        {
            double rating = getAverageByID(movieID, minimalRaters);
            if(rating != 0.0)
            {
                rating Rating = new rating(movieID, rating);
                ratings.add(Rating);
            }
        }
        return ratings;
    }

    public ArrayList <rating>  getAverageRatingByFilters(int minimalRaters, Filter filterCriteria) throws IOException
    {
        ArrayList <rating> movieList = new ArrayList <rating>();
        ArrayList <String> movies = MovieDatabase.filterBy(filterCriteria);
        for(String movieID : movies)
        {
            double rating = getAverageByID(movieID, minimalRaters);
            if(rating != 0.0)
            {
                rating Rating = new rating(movieID, rating);
                movieList.add(Rating);
            }
        }
        return movieList;
    }
}