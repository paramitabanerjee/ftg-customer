package food.togo.customer.mysqldao.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "PaymentMethods")
@Setter
@Getter
public class CustomerPaymentInfo {
}
