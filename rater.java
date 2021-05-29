import java.util.*;

public interface rater
{
    public void addRating(String item, double rating);

    public String getID();

    public double getRating(String item);

    public int numRatings();

    public ArrayList <String> getItemsRated();
}