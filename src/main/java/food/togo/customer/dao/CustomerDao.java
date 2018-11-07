package food.togo.customer.dao;


import food.togo.customer.mysqldao.entities.CustomerEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import food.togo.customer.mysqldao.repositories.CustomerRepository;
import food.togo.customer.mongodao.repositories.CustomerMongoRepository;

import java.util.Optional;

@Component
public class CustomerDao {

    @Autowired CustomerRepository customerRepository;
    @Autowired CustomerMongoRepository customerMongoRepository;

    /*public Customers createCustomer(CustomerRequest customerRequest) {

        Customers customer = new Customers(customerRequest.getFirstName(), customerRequest.getLastName());

        Customers savedCustomers = customerMongoRepository.save(customer);

        return savedCustomers;
    }*/

    public CustomerEntity getCustomer(Long customerId) {

        Optional<CustomerEntity> fetchedCustomerEntity = customerRepository.findById(customerId);
        if(fetchedCustomerEntity.isPresent()) {
            return fetchedCustomerEntity.get();
        }

        return null;
    }

    public CustomerEntity createCustomer(CustomerEntity customerEntity) {
        CustomerEntity savedCustomers = customerRepository.save(customerEntity);

        return savedCustomers;
    }

    public void deleteCustomer(Long customerId) {
        CustomerEntity customerEntity = getCustomer(customerId);
        customerEntity.setStatus(0); //TODO
        customerRepository.save(customerEntity);


    }

    public Optional<CustomerEntity> getCustomerByEmail(String email) {
        return customerRepository.findByEmail(email);
    }
}
