package th.ac.ku.customer.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import th.ac.ku.customer.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
