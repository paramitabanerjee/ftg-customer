package food.togo.customer.service;

import food.togo.customer.dao.CustomerDao;
import food.togo.customer.mysqldao.entities.CustomerEntity;
import food.togo.platform.HashUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import food.togo.platform.EncryptionUtil;

import java.util.Optional;

@Service
public class CustomerService {

    @Autowired CustomerDao customerDao;

    /*public CustomerResponse createCustomer(CustomerRequest customerRequest) {

        Customers customers = customerDao.createCustomer(customerRequest);

        CustomerResponse customerResponse = new CustomerResponse();

        return customerResponse;
    }*/

    public CustomerEntity createCustomer(CustomerEntity customerEntity) throws Exception {

        String password = customerEntity.getPassword();

        String salt = EncryptionUtil.getSalt();
        customerEntity.setSalt(salt);

        String passwordHash = HashUtil.hashPassword(password, salt.getBytes());

        customerEntity.setPassword(passwordHash);
        CustomerEntity entity = customerDao.createCustomer(customerEntity);

        return entity;
    }

    public CustomerEntity getCustomer(Long customerId) {

        CustomerEntity customer = customerDao.getCustomer(customerId);

        return customer;
    }

    public Optional<CustomerEntity> getCustomerByEmail(String email) {

        return customerDao.getCustomerByEmail(email);
    }

    public CustomerEntity updateCustomer(CustomerEntity customerEntity) {

        CustomerEntity updatedCustomer = customerDao.createCustomer(customerEntity);
        return updatedCustomer;
    }

    public void deleteCustomer(Long customerId) {

        customerDao.deleteCustomer(customerId);
    }
}
