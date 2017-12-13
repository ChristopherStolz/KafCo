package Display;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.nyit.CSCI455.MeterProject.Data.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{

/**
 * TODO: Define database calls available
 * Update
 */
	public List<User> findAll();
	public User findByEmail(String email);
}
