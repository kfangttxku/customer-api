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

    @GetMapping("/{id}")
    public Customer getOne(@PathVariable int id){
        return customerRepository.findById(id).get();
    }

    @PostMapping
    public Customer create(@RequestBody Customer customer) {
        Customer record = customerRepository.save(customer);
        customerRepository.flush();
        return record;
    }

    @PutMapping("/{id}")
    public Customer update(@PathVariable int id, @RequestBody Customer customer) {
        Customer record = customerRepository.findById(id).get();
        record.setCustomerName(customer.getCustomerName());
        customerRepository.save(record);
        return record;
    }

    @DeleteMapping("/{id}")
    public Customer delete(@PathVariable int id) {
        Customer record = customerRepository.findById(id).get();
        customerRepository.deleteById(id);
        return record;
    }

}
