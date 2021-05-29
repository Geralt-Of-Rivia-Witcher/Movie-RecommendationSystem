public class movie
{
    private String id;
    private String title;
    private int year;
    private String genres;
    private String director;
    private String country;
    private int minute;
    private String poster;

    public movie(String id, String title, int year, String genres, String director, String country, int minute, String poster)
    {
        this.id = id.trim();
        this.title = title.trim();
        this.year = year;
        this.genres = genres.trim();
        this.director = director.trim();
        this.country = country.trim();
        this.minute = minute;
        this.poster = poster.trim();
    }

    public String getID()
    {
        return id;
    }

    public String getTitle()
    {
        return title;
    }

    public int getYear()
    {
        return year;
    }

    public String getGenres()
    {
        return genres;
    }

    public String getDirector()
    {
        return director;
    }

    public String getCountry()
    {
        return country;
    }

    public int getMinutes()
    {
        return minute;
    }

    public String getPoster()
    {
        return poster;
    }

    public String toString()
    {
        String result = "Movie [id=" + id + ", title=" + title + ", year=" + year + ", genres= " + genres + "]";
        return result;
    }
}