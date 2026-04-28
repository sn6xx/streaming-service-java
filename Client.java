
package project.h;

public final class Client extends Person {

    private int phone;
    private String password;

    public Client() { //chaining
        this(0, "", "", 0, "");
    }

    public Client(int ID, String name, String email, int phone, String password) {
        super(ID, name, email);
        setPhone(phone);
        setPassword(password);
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return String.format("%s\nPhone: %s", super.toString(), getPhone());
    }
}
