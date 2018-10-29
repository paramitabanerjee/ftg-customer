package food.togo.customer.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CustomerRequest {

    String firstName;
    String lastName;
    String email;
    String phone;
    String password;
    String pin;
    String address1;
    String address2;
    String city;
    String state;
    Integer zip;

}
