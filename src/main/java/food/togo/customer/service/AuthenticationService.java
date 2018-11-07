package food.togo.customer.service;

import food.togo.customer.controller.request.LoginRequest;
import food.togo.customer.mysqldao.entities.CustomerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import food.togo.platform.HashUtil;
import java.util.Optional;

@Service
public class AuthenticationService {

    @Autowired
    CustomerService customerService;

    public boolean authenticate(LoginRequest loginRequest) throws Exception {

        String email = loginRequest.getEmail();
        String password = loginRequest.getPassword();

        //get customer details by email
        CustomerEntity fetchedCustomer = null;
        Optional<CustomerEntity> customerEntity = customerService.getCustomerByEmail(email);
        if(customerEntity.isPresent()) {
            fetchedCustomer = customerEntity.get();
        }
        else {
            throw new Exception("CUSTOMER_NOT_FOUND");
        }

        String salt = fetchedCustomer.getSalt();
        String hashedPassword = HashUtil.hashPassword(password, salt);
        if(fetchedCustomer.getPassword()!=null && fetchedCustomer.getPassword().equals(hashedPassword)) {
           return true;
        }else {
            throw new Exception("AUTHENTICATION_FAILED");
        }
    }

}
