
package project.h;

public final class Episode {

    private String title;
    private int duration;
    private int season;

    public Episode() {  //chaining
        this("", 0, 0);
        
    }

    public Episode(String title, int duration, int season) {
        setTitle(title);
        setDuration(duration);
        setSeason(season);
       

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getSeason() {
        return season;
    }

    public void setSeason(int season) {
        this.season = season;
    }

   
    @Override
    public String toString() {
        return String.format("Title: %s\nDuration: %d Minutes\nSeason: %d", getTitle(), getDuration(), getSeason());
    }
}
