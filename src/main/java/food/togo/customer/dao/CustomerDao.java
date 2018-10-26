package food.togo.customer.dao;

import food.togo.customer.dao.entities.Customers;
import food.togo.customer.dao.repositories.CustomerRepository;
import food.togo.customer.request.CustomerRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CustomerDao {

    @Autowired
    CustomerRepository customerRepository;

    public Customers createCustomer(CustomerRequest customerRequest) {

        Customers customer = new Customers(customerRequest.getFirstName(), customerRequest.getLastName());

        Customers savedCustomers = customerRepository.save(customer);

        return savedCustomers;
    }


    public Customers getCustomer(Long customerId) {

        Optional<Customers> fetchedCustomerEntity = null;//customerRepository.findById(customerId);
        if(fetchedCustomerEntity.isPresent()) {
            return fetchedCustomerEntity.get();
        }

        return null;
    }
}
