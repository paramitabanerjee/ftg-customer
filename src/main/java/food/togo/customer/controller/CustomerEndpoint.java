package food.togo.customer.controller;


import food.togo.customer.mysqldao.entities.CustomerEntity;
import food.togo.customer.request.CustomerRequest;
import food.togo.customer.response.CustomerResponse;
import food.togo.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> createCustomer(@RequestBody CustomerEntity customerEntity) {
        CustomerEntity entity = customerService.createCustomer(customerEntity);
        return new ResponseEntity(entity, HttpStatus.CREATED);
    }

    @PutMapping
    @ResponseBody
    public ResponseEntity<?>  updateCustomer(@RequestBody CustomerEntity customerEntity) {
        CustomerEntity entity = customerService.updateCustomer(customerEntity);

        return new ResponseEntity(entity, HttpStatus.OK);
    }

    @DeleteMapping(value="/{customerId}")
    @ResponseBody
    public ResponseEntity<?> deleteCustomer(Long customerId) {
        customerService.deleteCustomer(customerId);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }


    @GetMapping(value = "/{customerId}")
    @ResponseBody
    public ResponseEntity<?> getCustomer(@PathVariable("customerId") Long customerId) {
        System.out.println("CustomerId = "+customerId);
        CustomerEntity entity = customerService.getCustomer(customerId);

        return new ResponseEntity(entity, HttpStatus.OK);
    }


}
