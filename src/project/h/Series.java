
package project.h;


public final class Series extends Media {

    private int seasonCount;
    private int episodeCount;
    private Episode[] episodes; 

    public Series() { //chaining
        this(0, "", "", 0, null, 0, 0, null);
    }

    public Series(int num , String title, String type, int productionyear, Director director, int seasonCount, int episodeCount, Episode[] episodes) {
        super(num, title, type, productionyear, director);
        setSeasonCount(seasonCount);
        setEpisodeCount(episodeCount);
        setEpisodes(episodes);
    }

    public int getSeasonCount() {
        return seasonCount;
    }

    public void setSeasonCount(int seasonCount) {
        this.seasonCount = seasonCount;
    }

    public int getEpisodeCount() {
        return episodeCount;
    }

    public void setEpisodeCount(int episodeCount) {
        this.episodeCount = episodeCount;
    }

    
    public Episode[] getEpisodes() {
        return episodes;
    }

    public void setEpisodes(Episode[] episodes) {
        this.episodes = episodes;
    }
@Override
    public String mediaType() {
        return "Series";
    }
    public void displayEpisodes() { /*To print an array we must 
                                             have a method which has a loop*/   
        System.out.println("*** Episode List ***");
        if (episodes == null) {
            System.out.println("No episode added yet!");
        } else {
            try{
            for (Episode e : episodes) { 
                System.out.println(e);
                System.out.println("-----------------------------");
            }
        }catch(NullPointerException ex){
                System.out.println("invalid obj");
        }
    }
    }
    @Override
    public String toString() {
        return String.format("%s\nEpisode Count : %d\nSeason Count : %d", super.toString(), getEpisodeCount(), getSeasonCount());
    }
}
