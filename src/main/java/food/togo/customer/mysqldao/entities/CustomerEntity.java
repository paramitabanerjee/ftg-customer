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
    @Column(name="customerid")
    private Long customerID;
    @Column(name="firstname")
    private String firstName;
    @Column(name="lastname")
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
    @Column(name="stripecustomerid")
    private String stripeCustomerID;
    private String salt;
    private String IV;


}
