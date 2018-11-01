package food.togo.customer.service;

import food.togo.customer.dao.CustomerDao;
import food.togo.customer.mongodao.entities.Customers;
import food.togo.customer.mysqldao.entities.CustomerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired CustomerDao customerDao;

    /*public CustomerResponse createCustomer(CustomerRequest customerRequest) {

        Customers customers = customerDao.createCustomer(customerRequest);

        CustomerResponse customerResponse = new CustomerResponse();

        return customerResponse;
    }*/

    public CustomerEntity createCustomer(CustomerEntity customerEntity) {
        CustomerEntity entity = customerDao.createCustomer(customerEntity);

        return entity;
    }

    public CustomerEntity getCustomer(Long customerId) {

        CustomerEntity customer = customerDao.getCustomer(customerId);

        return customer;
    }

    public CustomerEntity updateCustomer(CustomerEntity customerEntity) {

        CustomerEntity updatedCustomer = customerDao.createCustomer(customerEntity);
        return updatedCustomer;
    }

    public void deleteCustomer(Long customerId) {

        customerDao.deleteCustomer(customerId);
    }
}
