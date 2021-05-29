import java.util.*;
import org.apache.commons.csv.*;
import java.io.*;

public class RaterDatabase
{
   private static HashMap <String, rater> ourRaters;
     
	private static void initialize()
    {
	    // this method is only called from addRatings()
		if (ourRaters == null)
        {
			ourRaters = new HashMap <String, rater>();
		}
	}

    public static void initialize(String raterFile) throws IOException
    {
 		if (ourRaters == null)
        {
 			ourRaters= new HashMap <String, rater>();
 			addRatings(raterFile);
 		}
 	}	
 	
    public static void addRatings(String raterFile) throws IOException
    {
        initialize();

        FileReader reader = new FileReader("data\\" + raterFile);
        CSVFormat format = CSVFormat.RFC4180.withHeader().withDelimiter(',');
        CSVParser parser = new CSVParser(reader, format);
        
        for(CSVRecord record : parser)
        {
                String raterID = record.get("rater_id");
                String item = record.get("movie_id");
                String rating = record.get("rating");
                addRaterRating(raterID, item, Double.parseDouble(rating));
        } 
        parser.close();
    }
    
    public static void addRaterRating(String raterID, String movieID, double rating)
    {
        initialize(); 
        rater ourRater =  null;
        if (ourRaters.containsKey(raterID))
        {
            ourRater = ourRaters.get(raterID); 
        } 
        else
        { 
            ourRater = new EfficientRater(raterID);
            ourRaters.put(raterID, ourRater);
        }
        ourRater.addRating(movieID, rating);
    } 
	         
    public static rater getRater(String raterID)
    {
    	initialize();	
    	return ourRaters.get(raterID);
    }
    
    public static ArrayList <rater> getRaters()
    {
    	initialize();
    	ArrayList <rater> raterList = new ArrayList <rater> (ourRaters.values());
    	return raterList;
    }
 
    public static int size()
    {
	    return ourRaters.size();
    }    
}