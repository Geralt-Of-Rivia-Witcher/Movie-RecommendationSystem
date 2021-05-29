public class MinutesFilter implements Filter
{
    int minMinutes;
    int maxMinutes;

    public MinutesFilter(int minMinutes, int maxMinutes)
    {
        this.minMinutes = minMinutes;
        this.maxMinutes = maxMinutes;
    }

    @Override
    public boolean satisfies(String movieID)
    {
        try
        {
            int duration = MovieDatabase.getMinutes(movieID);
            return (minMinutes <= duration && duration <= maxMinutes);
        }
        catch (Exception e)
        {
            System.out.println(e);
            return false;
        }
    }
}
