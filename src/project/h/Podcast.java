
package project.h;

public final class Podcast extends Media {

    private String downloadURL;
    private String hosts ;
    
    public Podcast() { //chaining

        this(0,"","",0,null,"","");
        
    }

    public Podcast(int num, String title, String type, int productionyear, Director director, String downloadURL ,String hosts) {
        super(num, title, type, productionyear, director);
        setDownloadURL(downloadURL);
        setHosts( hosts);
        
    }

    public String getDownloadURL() {
        return downloadURL;
    }

    public void setDownloadURL(String DownloadURL) {
        this.downloadURL = DownloadURL;
    }

    public String getHosts() {
        return hosts;
    }

    public void setHosts(String hosts) {
        this.hosts = hosts;
    }
    
@Override
    public String mediaType() {
        return "Podcast";
    }

    @Override
    public String toString() {
        return String.format("%s\ndownload URL : %s\nhosts : %s", super.toString(), getDownloadURL(),getHosts());
    }
}    
    
