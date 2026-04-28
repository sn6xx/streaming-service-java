
package project.h;

public final class Subscription implements Payable { // كل اشتراك لديه تاريخ ودفع وعميل

    private final int ID;
    private Client client;
    private Date date;
    private int numPlan; 
    private int months;
    private Payment payment;
    private String status;
    private static int count;

    public Subscription() { //chaining
        this(null, null, 0, 0, null);
    }

    public Subscription(Client client, Date date, int numPlan, int months, Payment payment) {
        this.ID = ++count;
        setDate(date);
        setClient(client);
        setMonths(months);
        setNumPlan(numPlan);
        setPayment(payment);
        setStatus("Not confirmed!");
    }

    public int getID() {
        return ID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public int getMonths() {
        return months;
    }

    public void setMonths(int months) {
        this.months = months;
    }

    public int getNumPlan() {
        return numPlan;
    }

    public void setNumPlan(int numPlan) {
        this.numPlan = numPlan;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public void pay(double amount) {
        System.out.printf("Pay %.2f SAR\n with: ", amount, getPayment());
    }

    @Override
    public double calcPayment() {
        double priceAfterVAT = 0;  
        double totalPrice = 0;
       
        int numPlan = getNumPlan();
        if (numPlan == 1) {
            priceAfterVAT = 35* Payable.VAT;
            totalPrice = (priceAfterVAT + 35) * getMonths();
        } else if (numPlan == 2) {
            priceAfterVAT =  65 * Payable.VAT;
            totalPrice = (priceAfterVAT + 65) * getMonths();
        } else if (numPlan == 3) {
            priceAfterVAT = 95* Payable.VAT;
             totalPrice = (priceAfterVAT + 95) * getMonths();
        }
        return totalPrice;
    }

    public final void confirm() {
        double amount = calcPayment();
        pay(amount);
        setStatus("Confirmed");
        System.out.println("Your subscription has been confirmed!");

    }

    public void print() { 
        System.out.println("*** Subscription Info ***");
        System.out.println("Subscription number: " + getID());
        System.out.println("Subscription Client: " + getClient());
        System.out.println("Subscription Date: " + getDate());
        System.out.println("Months: " + getMonths());
        System.out.println("Subscription Payment: \n"+ getPayment());
        System.out.println("Subscription Status: "+ getStatus());
        System.out.printf("You had paid : %.2f SAR\n", calcPayment());
    }

    
    @Override
    public String toString() { 
        return String.format("ID: %d\nClient: %s\nStatus: %s", getID(), getClient(), getStatus());
    }
}
