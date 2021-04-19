package th.ac.ku.customer.controller;

import org.springframework.web.bind.annotation.*;
import th.ac.ku.customer.data.CustomerRepository;
import th.ac.ku.customer.model.Customer;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class CustomerRestController {
    private CustomerRepository customerRepository;

    public CustomerRestController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping
    public List<Customer> getAll(){
        return customerRepository.findAll();
    }

    @GetMapping("/{customerId}")
    public Customer getOne(@PathVariable int customerId){
        return customerRepository.findById(customerId).get();
    }

    @GetMapping("/customer/{customerId}")
    public List<Customer> getAllCustomerId(@PathVariable int customerId) {
        return customerRepository.findByCustomerId(customerId);
    }

    @PostMapping
    public Customer create(@RequestBody Customer customer) {
        Customer record = customerRepository.save(customer);
        customerRepository.flush();
        return record;
    }

    @PutMapping("/{customerId}")
    public Customer update(@PathVariable int customerId, @RequestBody Customer customer) {
        Customer record = customerRepository.findById(customerId).get();
        record.setCustomerName(customer.getCustomerName());
        customerRepository.save(record);
        return record;
    }

    @DeleteMapping("/{customerId}")
    public Customer delete(@PathVariable int customerId) {
        Customer record = customerRepository.findById(customerId).get();
        customerRepository.deleteById(customerId);
        return record;
    }

}
