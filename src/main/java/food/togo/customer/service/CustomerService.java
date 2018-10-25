package food.togo.customer.service;

import food.togo.customer.request.CustomerRequest;
import food.togo.customer.response.CustomerResponse;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    public CustomerResponse createCustomer(CustomerRequest customerRequest) {

        CustomerResponse customerResponse = new CustomerResponse();

        return customerResponse;
    }

    public CustomerResponse getCustomer(String customerId) {

        CustomerResponse customerResponse = new CustomerResponse();

        return customerResponse;
    }
}
