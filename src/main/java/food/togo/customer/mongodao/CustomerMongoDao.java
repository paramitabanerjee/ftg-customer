package food.togo.customer.mongodao;

import food.togo.customer.mongodao.entities.Customers;
import food.togo.customer.mongodao.repositories.CustomerMongoRepository;
import food.togo.customer.request.CustomerRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CustomerMongoDao {

    @Autowired
    CustomerMongoRepository customerMongoRepository;

    public Customers createCustomer(CustomerRequest customerRequest) {

        Customers customer = new Customers(customerRequest.getFirstName(), customerRequest.getLastName());

        Customers savedCustomers = customerMongoRepository.save(customer);

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
