package food.togo.customer.mongodao.repositories;

import food.togo.customer.mongodao.entities.Customers;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerMongoRepository extends MongoRepository<Customers, String> {
}
