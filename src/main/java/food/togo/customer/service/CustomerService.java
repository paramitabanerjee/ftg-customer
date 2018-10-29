package food.togo.customer.service;

import food.togo.customer.mongodao.CustomerMongoDao;
import food.togo.customer.mongodao.entities.Customers;
import food.togo.customer.mysqldao.CustomerDao;
import food.togo.customer.mysqldao.entities.CustomerEntity;
import food.togo.customer.request.CustomerRequest;
import food.togo.customer.response.CustomerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    CustomerMongoDao customerMongoDao;
    @Autowired
    CustomerDao customerDao;

    public CustomerResponse createCustomer(CustomerRequest customerRequest) {

        Customers customers = customerMongoDao.createCustomer(customerRequest);

        CustomerResponse customerResponse = new CustomerResponse();

        return customerResponse;
    }

    public CustomerEntity createCustomer(CustomerEntity customerEntity) {
        CustomerEntity entity = customerDao.createCustomer(customerEntity);

        return entity;
    }

    public CustomerResponse getCustomer(String customerId) {

        Customers customers = customerMongoDao.getCustomer(Long.parseLong(customerId));

        CustomerResponse customerResponse = new CustomerResponse();

        return customerResponse;
    }
}
