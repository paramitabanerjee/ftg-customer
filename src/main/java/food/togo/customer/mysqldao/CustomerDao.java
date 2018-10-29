package food.togo.customer.mysqldao;

import food.togo.customer.mysqldao.entities.CustomerEntity;
import food.togo.customer.mysqldao.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerDao {

    @Autowired
    CustomerRepository customerRepository;

    public CustomerEntity createCustomer(CustomerEntity customerEntity) {
        CustomerEntity savedCustomers = customerRepository.save(customerEntity);

        return savedCustomers;
    }
}
