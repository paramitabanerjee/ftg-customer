package food.togo.customer.mysqldao.entities;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Customer")
@Setter
@Getter
public class CustomerEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerID;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String password;
    private String pin;
    private String address1;
    private String address2;
    private String city;
    private String state;
    private Integer zip;
    private Integer status;
    private String stripeCustomerID;


}
