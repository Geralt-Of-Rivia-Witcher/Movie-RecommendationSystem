import java.io.IOException;
import java.util.*;

public class FourthRatings
{

    public double getAverageByID(String movieID, int minimalRaters)
    {
        double sum = 0.0;
        int count = 0;
        ArrayList <rater> myRaters = RaterDatabase.getRaters();
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

    private int dotProduct(rater me, rater r)
    {
        int dotProduct = 0;
        ArrayList <String> myMovies = me.getItemsRated();
        for(String movie : myMovies)
        {
            double otherRating = r.getRating(movie);
            if(otherRating != -1)
            {
                dotProduct += (otherRating - 5) * (me.getRating(movie) - 5);
            }
        }
        return dotProduct;
    }

    private ArrayList <rating> getSimilarities(String id)
    {
        ArrayList <rating> similarityRatings = new ArrayList <rating>();
        ArrayList <rater> listOfRaters = RaterDatabase.getRaters();
        for(rater Rater : listOfRaters)
        {
            if(! Rater.getID().equals(id))
            {
                int dotProduct = dotProduct(RaterDatabase.getRater(id), Rater);
                if(dotProduct >= 0)
                {
                    rating newRating = new rating(Rater.getID(), dotProduct);
                    similarityRatings.add(newRating);
                }
            }
        }
        Collections.sort(similarityRatings, Collections.reverseOrder());
        return similarityRatings;
    }

    public ArrayList <rating> getSimilarRatings(String id, int numSimilarRaters, int minimalRaters) throws IOException
    {
        ArrayList <rating> movieList = new ArrayList <rating>();
        ArrayList <rating> listOfRaters = getSimilarities(id);
        ArrayList <String> movies = MovieDatabase.filterBy(new AllFilters());

        for(String movie : movies)
        {
            int count = 0, sum = 0;
            for(int i = 0; i < numSimilarRaters; i++)
            {
                String raterID = listOfRaters.get(i).getItem();
                rater currentRater = RaterDatabase.getRater(raterID);
                if(currentRater.getRating(movie) != -1)
                {
                    count++;
                    sum += currentRater.getRating(movie) * listOfRaters.get(i).getValue();
                }
            }
            if(count >= minimalRaters)
            {
                movieList.add(new rating(movie, sum/count));
            }
        }
        Collections.sort(movieList);
        return movieList;
    }

    public ArrayList <rating> getSimilarRatingsByFilter(String id, int numSimilarRaters, int minimalRaters, Filter filterCriteria) throws IOException
    {
        ArrayList <rating> movieList = new ArrayList <rating>();
        ArrayList <rating> listOfRaters = getSimilarities(id);

        ArrayList <String> movies = MovieDatabase.filterBy(filterCriteria);
        
        for(String movie : movies)
        {
            int count = 0, sum = 0;
            for(int i = 0; i < numSimilarRaters; i++)
            {
                String raterID = listOfRaters.get(i).getItem();
                rater currentRater = RaterDatabase.getRater(raterID);
                if(currentRater.getRating(movie) != -1)
                {
                    count++;
                    sum += currentRater.getRating(movie) * listOfRaters.get(i).getValue();
                }
            }
            if(count >= minimalRaters)
            {
                movieList.add(new rating(movie, sum/count));
            }
        }
        Collections.sort(movieList);
        return movieList;
    }
}