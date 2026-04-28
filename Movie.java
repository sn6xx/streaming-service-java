
package project.h;

public final class Movie extends Media { 

    private int duration ;

    public Movie() { //chaining
        this(0, "", "", 0, null, 0);
    }

    public Movie(int num, String title, String type, int productionyear, Director director, int duration) {
        super(num, title, type, productionyear, director);
        setDuration(duration);
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int runtime) {
        this.duration = runtime;
    }

    @Override
    public String mediaType() {
        return "Movie";
    }

    @Override
    public String toString() {
        return String.format("%s\nduration : %d Minutes", super.toString(), getDuration());
    }
}
