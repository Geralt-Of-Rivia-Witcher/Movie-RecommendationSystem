import java.io.IOException;
import java.util.*;

public class RecommendationRunner implements Recommender
{

    @Override
    public ArrayList<String> getItemsToRate() throws IOException
    {
        System.out.println("Please rate a few movies to get recommendations : ");
        MovieDatabase.initialize("ratedmoviesfull.csv");

        Random random = new Random();

        ArrayList <String> movieList = new ArrayList <String>();
        ArrayList <String> movies = MovieDatabase.filterBy(new AllFilters());

        for(int i = 0; i < 15; i++)
        {
            int index = random.nextInt(MovieDatabase.size());
            movieList.add(movies.get(index));
        }
        return movieList;
    }

    @Override
    public void printRecommendationsFor(String webRaterID) throws IOException
    {
        int numberOfMinimumRatings = 5;
        int numberOfSimilarRaters = 20;
        FourthRatings ratings = new FourthRatings();

        RaterDatabase.initialize("ratings.csv");

        MovieDatabase.initialize("ratedmoviesfull.csv");

        //ArrayList <String> moviesRated = RaterDatabase.getRater(webRaterID).getItemsRated();
        ArrayList <rating> movieList = ratings.getSimilarRatings(webRaterID, numberOfSimilarRaters, numberOfMinimumRatings);

        for(rating r : movieList)
        {
            System.out.println(r.getItem());
        }
        // int numberOfMovies = 10;
        // int index = movieList.size() - 1;
        // try
        // {
        //     while(numberOfMovies > 0)
        //     {
        //         if(! moviesRated.contains(movieList.get(index).getItem()))
        //         {
        //             System.out.println(movieList.get(index).getItem() + "-" + movieList.get(index).getValue());
        //             numberOfMovies--;
        //         }
        //         index--;
        //     }
        // }
        // catch(Exception e)
        // {
        //     System.out.println("No more movies found😔");
        // }        
    }   
}