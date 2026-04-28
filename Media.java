
package project.h;


public abstract class Media { //an obj cannot be created

    private final int num;
    private String title;
    private String type; 
    private int productionYear;  
    private Director director;
    private static int count;

    
    public Media() { //chaining
        this(0, "", "", 0, null);
    }

    public Media(int num, String title, String type, int productionYear, Director director) {
        this.num = num ; // doesnt have a set method 
        setTitle(title);
        setType(type);
        setProductionYear(productionYear);
        setDirector(director);
        count++; //static variable
    }

    public int getNUM() {
        return num;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(int ProductionYear) {
        this.productionYear = ProductionYear;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Media.count = count;
    }

    public abstract String mediaType();

    @Override
    public String toString() {
        return String.format("number : %d\nTitle : %s\nType : %s\nProduction year : %d\nDirector : %s", getNUM(), getTitle(), getType(), getProductionYear(), getDirector());
    }
}
