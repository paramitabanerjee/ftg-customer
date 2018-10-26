package food.togo.customer.service;

import food.togo.customer.dao.CustomerDao;
import food.togo.customer.dao.entities.Customers;
import food.togo.customer.request.CustomerRequest;
import food.togo.customer.response.CustomerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    CustomerDao customerDao;

    public CustomerResponse createCustomer(CustomerRequest customerRequest) {

        Customers customers = customerDao.createCustomer(customerRequest);

        CustomerResponse customerResponse = new CustomerResponse();

        return customerResponse;
    }

    public CustomerResponse getCustomer(String customerId) {

        Customers customers = customerDao.getCustomer(Long.parseLong(customerId));

        CustomerResponse customerResponse = new CustomerResponse();

        return customerResponse;
    }
}
