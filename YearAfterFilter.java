public class YearAfterFilter implements Filter
{
	private int myYear;
	
	public YearAfterFilter(int year)
    {
		myYear = year;
	}
	
	@Override
	public boolean satisfies(String movieID) 
    {
		try
		{
			return MovieDatabase.getYear(movieID) >= myYear;
		} 
		catch (Exception e)
		{
			System.out.println(e);
			return false;
		}
	}
}
