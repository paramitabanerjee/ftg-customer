package food.togo.customer.dao.repositories;

import food.togo.customer.dao.entities.Customers;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends MongoRepository<Customers, String> {
}
