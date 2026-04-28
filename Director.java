
package project.h;

public final class Director extends Person {

    private int yearsOfExperience;

    public Director() { //chaining
        this(0, "", "", 0);
    }

    public Director(int ID, String name, String email, int yearsOfExperience) {
        super(ID, name, email);
        setYearsOfExperience(yearsOfExperience);
      
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

   
    @Override
    public String toString() {
        return String.format("%s\nYears Of Experience: %d", super.toString(), getYearsOfExperience());
    }
}
