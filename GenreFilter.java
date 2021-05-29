public class GenreFilter implements Filter
{
    String genre;

    public GenreFilter(String genre)
    {
        this.genre = genre;
    }

    @Override
    public boolean satisfies(String movieID)
    {
        try
        {
            return MovieDatabase.getGenres(movieID).contains(genre);    
        } catch (Exception e)
        {
            System.out.println(e);
            return false;
        }
    }
    
}
