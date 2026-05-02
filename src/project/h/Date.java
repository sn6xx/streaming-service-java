
package project.h;

public final class Date { //when we Subscription?

    private int day;
    private int month;
    private int year;        //قيم رقمية لازم نعرفها بالسترز

    public Date() { //chaining
        this(0, 0, 0);
    }

    public Date(int day, int month, int year) {
        setDay(day);
        setMonth(month);
        setYear(year);
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        if (day >= 1 && day <= 31) {
            this.day = day;
        } else {
            System.err.println("Invalid day!");
        }
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        if (month >= 1 && month <= 12) {
            this.month = month;
        } else {
            System.err.println("Invalid month!");
        }
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if (year >= 2023) {
            this.year = year;
        } else {
            System.err.println("Invalid year!");
        }
    }

    @Override
    public String toString() {
        return String.format("%02d-%02d-%04d", getDay(), getMonth(), getYear());
    }

}
