public class DirectorsFilter implements Filter
{
    String directors[];

    public DirectorsFilter(String directors)
    {
        this.directors = directors.split(",");
    }

    @Override
    public boolean satisfies(String movieID)
    {
        try
        {
            for(String director : directors)
            {
                if(MovieDatabase.getDirector(movieID).contains(director))
                {
                    return true;
                }
            }
            return false;
        }
        catch (Exception e)
        {
            System.out.println(e);
            return false;
        }
    } 
}
