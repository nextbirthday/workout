package mysql;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
public class Customer {
    private int           customer_id;
    private int           store_id;
    private String        first_name;
    private String        last_name;
    private String        email;
    private int           address_id;
    private int           active;
    private String        create_date;
    private String        last_update;
    @NonNull
    private Payment       payment;
    private List<Payment> payments;
}
