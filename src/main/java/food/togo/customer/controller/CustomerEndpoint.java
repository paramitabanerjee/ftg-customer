package food.togo.customer.controller;


import food.togo.customer.mysqldao.entities.CustomerEntity;
import food.togo.customer.request.CustomerRequest;
import food.togo.customer.response.CustomerResponse;
import food.togo.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/customer")
public class CustomerEndpoint {


    @Autowired
    CustomerService customerService;

    @PostMapping(value = "/mongo")
    @ResponseBody
    public CustomerResponse createCustomer(@RequestBody CustomerRequest customerRequest) {
        CustomerResponse customerResponse = customerService.createCustomer(customerRequest);

        return customerResponse;
    }

    @PostMapping
    @ResponseBody
    public CustomerEntity createCustomer(@RequestBody CustomerEntity customerEntity) {
        CustomerEntity entity = customerService.createCustomer(customerEntity);

        return entity;
    }


    @GetMapping(value = "/{customerId}")
    @ResponseBody
    public CustomerResponse getCustomer(String customerId) {
        CustomerResponse customerResponse = customerService.getCustomer(customerId);

        return customerResponse;
    }

}
