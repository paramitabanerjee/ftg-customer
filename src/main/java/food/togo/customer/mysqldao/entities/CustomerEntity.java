package food.togo.customer.mysqldao.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
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

    //@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    //@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String pin;

    private String address1;

    private String address2;

    private String city;

    private String state;

    private Integer zip;

    private Integer status;

    //@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name="stripecustomerid")
    private String stripeCustomerID;

    //@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private byte[] salt;

    //@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private byte[] iv;


}
