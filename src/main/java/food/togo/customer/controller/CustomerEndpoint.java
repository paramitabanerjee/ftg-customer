package food.togo.customer.controller;


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

    @PostMapping
    @ResponseBody
    public CustomerResponse createCustomer(@RequestBody CustomerRequest customerRequest) {
        CustomerResponse customerResponse = customerService.createCustomer(customerRequest);

        return customerResponse;
    }

    @GetMapping(value = "/{customerId}")
    @ResponseBody
    public CustomerResponse getCustomer(String customerId) {
        CustomerResponse customerResponse = customerService.getCustomer(customerId);

        return customerResponse;
    }

}
