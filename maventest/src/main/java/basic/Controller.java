package basic;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dto.Customer;
import dto.Payment;

@SuppressWarnings( "serial" )
@WebServlet( "/customer" )
public class Controller extends HttpServlet {
    
    @Override
    protected void doGet( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException {
        req.setCharacterEncoding( "UTF-8" );
        CustomerDAO dao      = new CustomerDAO();
        Customer    customer = new Customer();
        PrintWriter writer   = resp.getWriter();
        customer.setCustomer_id( Integer.parseInt( String.valueOf( req.getParameter( "customer_id" ) ) ) );
        List<Customer> customerList = dao.getCustomerPaymentList( customer );
        
        writer.print( toJson( customerList ) );
    }
    
    private String toJson( List<Customer> customerList ) {
        List<Map<String, Object>> tempList = new ArrayList<>();
        Map<String, Object>       tempMap;
        Gson                      gson     = new Gson();
        
        for ( Customer c : customerList ) {
            
            for ( Payment p : c.getPayments() ) {
                tempMap = new HashMap<>();
                tempMap.put( "customer_id", c.getCustomer_id() );
                tempMap.put( "store_id", c.getStore_id() );
                tempMap.put( "first_name", c.getFirst_name() );
                tempMap.put( "last_name", c.getLast_name() );
                tempMap.put( "email", c.getEmail() );
                tempMap.put( "address_id", c.getAddress_id() );
                tempMap.put( "active", c.getActive() );
                tempMap.put( "create_date", c.getCreate_date() );
                tempMap.put( "payment_id", p.getPayment_id() );
                tempMap.put( "staff_id", p.getStaff_id() );
                tempMap.put( "rental_id", p.getRental_id() );
                tempMap.put( "amount", p.getAmount() );
                tempMap.put( "payment_date", p.getPayment_date() );
                tempMap.put( "last_update", p.getLast_update() );
                tempList.add( tempMap );
            }
        }
        return gson.toJson( tempList );
    }
}
