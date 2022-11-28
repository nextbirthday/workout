package mysql;

import java.util.List;

public class Customer {
    
    public Customer() {}
    
    public Customer( Payment payment ) {
        this.payment = payment;
    }
    
    private int           customer_id;
    private int           store_id;
    private String        first_name;
    private String        last_name;
    private String        email;
    private int           address_id;
    private int           active;
    private String        create_date;
    private String        last_update;
    private Payment       payment;
    private List<Payment> payments;
    
    public int getCustomer_id() { return customer_id; }
    
    public void setCustomer_id( int customer_id ) { this.customer_id = customer_id; }
    
    public int getStore_id() { return store_id; }
    
    public void setStore_id( int store_id ) { this.store_id = store_id; }
    
    public String getFirst_name() { return first_name; }
    
    public void setFirst_name( String first_name ) { this.first_name = first_name; }
    
    public String getLast_name() { return last_name; }
    
    public void setLast_name( String last_name ) { this.last_name = last_name; }
    
    public String getEmail() { return email; }
    
    public void setEmail( String email ) { this.email = email; }
    
    public int getAddress_id() { return address_id; }
    
    public void setAddress_id( int address_id ) { this.address_id = address_id; }
    
    public int getActive() { return active; }
    
    public void setActive( int active ) { this.active = active; }
    
    public String getCreate_date() { return create_date; }
    
    public void setCreate_date( String create_date ) { this.create_date = create_date; }
    
    public String getLast_update() { return last_update; }
    
    public void setLast_update( String last_update ) { this.last_update = last_update; }
    
    public Payment getPayment() { return payment; }
    
    public void setPayment( Payment payment ) { this.payment = payment; }
    
    public List<Payment> getPayments() { return payments; }
    
    public void setPayments( List<Payment> payments ) { this.payments = payments; }
    
    @Override
    public String toString() {
        return "Customer [customer_id=" + customer_id + ", store_id=" + store_id + ", first_name=" + first_name + ", last_name=" + last_name + ", email=" + email + ", address_id="
                        + address_id + ", active=" + active + ", create_date=" + create_date + ", last_update=" + last_update + "]";
    }
}
