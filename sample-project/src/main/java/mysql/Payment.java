package mysql;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Payment {
    private int    payment_id;
    private int    customer_id;
    private int    staff_id;
    private int    rental_id;
    private double amount;
    private String payment_date;
    private String last_update;
}
