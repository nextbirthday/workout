package dto;

public class Payment {
    private int    payment_id;
    private int    customer_id;
    private int    staff_id;
    private int    rental_id;
    private double amount;
    private String payment_date;
    private String last_update;
    
    public int getPayment_id() { return payment_id; }
    
    public void setPayment_id( int payment_id ) { this.payment_id = payment_id; }
    
    public int getCustomer_id() { return customer_id; }
    
    public void setCustomer_id( int customer_id ) { this.customer_id = customer_id; }
    
    public int getStaff_id() { return staff_id; }
    
    public void setStaff_id( int staff_id ) { this.staff_id = staff_id; }
    
    public int getRental_id() { return rental_id; }
    
    public void setRental_id( int rental_id ) { this.rental_id = rental_id; }
    
    public double getAmount() { return amount; }
    
    public void setAmount( double amount ) { this.amount = amount; }
    
    public String getPayment_date() { return payment_date; }
    
    public void setPayment_date( String payment_date ) { this.payment_date = payment_date; }
    
    public String getLast_update() { return last_update; }
    
    public void setLast_update( String last_update ) { this.last_update = last_update; }
    
    @Override
    public String toString() {
        return "Payment [payment_id=" + payment_id + ", customer_id=" + customer_id + ", staff_id=" + staff_id + ", rental_id=" + rental_id + ", amount=" + amount
                        + ", payment_date=" + payment_date + ", last_update=" + last_update + "]";
    }
}
