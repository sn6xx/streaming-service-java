
package project.h;

public class Person {

    private final int ID;
    private String name;
    private String email;

    public Person() { //chaining
        this(0, "", "");
    }

    public Person(int ID, String name, String email) {
        this.ID = ID;
        setName(name);
        setEmail(email);
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return String.format("\nID: %d\nName: %s\nEmail: %s", getID(), getName(), getEmail());
    }
}
