import java.io.*;
import java.util.*;
import org.apache.commons.csv.*;

public class firstRatings
{
    public ArrayList <movie> loadMovies(String filename) throws IOException
    {
        ArrayList <movie> movies = new ArrayList <movie>();
        FileReader reader = new FileReader("data\\" + filename);
        CSVFormat format = CSVFormat.RFC4180.withHeader().withDelimiter(',');
        CSVParser parser = new CSVParser(reader, format);
        for(CSVRecord record : parser)
        {
            movie Movie = new movie(record.get("id"), record.get("title"), Integer.parseInt(record.get("year")), record.get("genre"), record.get("director"), record.get("country"), Integer.parseInt(record.get("minutes")), record.get("poster"));
            movies.add(Movie);
        }
        parser.close();
        return movies;
    }

    public ArrayList <rater> loadRaters(String filename) throws IOException
    {
        ArrayList <rater> Rater = new ArrayList <rater>();
        FileReader reader = new FileReader("data\\" + filename);
        CSVFormat format = CSVFormat.RFC4180.withHeader().withDelimiter(',');
        CSVParser parser = new CSVParser(reader, format);
        out: for(CSVRecord record : parser)
        {
            String ID = record.get("rater_id");
            for(int i = 0; i < Rater.size(); i++)
            {
                if(Rater.get(i).getID().equals(ID))
                {
                    Rater.get(i).addRating(record.get("movie_id"), Double.parseDouble(record.get("rating")));
                    continue out;
                }
            }
            rater newRater = new EfficientRater(ID);
            newRater.addRating(record.get("movie_id"), Double.parseDouble(record.get("rating")));
            Rater.add(newRater); 
        }
        parser.close();
        return Rater;
    }
}