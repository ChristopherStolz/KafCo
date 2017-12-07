package Display;

import edu.nyit.CSCI455.MeterProject.Data.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;

@Configuration
@EnableMongoRepositories(basePackageClasses=UserRepository.class)
class UserDatabaseConfiguration extends AbstractMongoConfiguration{
	@Override
	protected String getDatabaseName() {
		return "KafCo";
	}
	
	@Override
	public @Bean Mongo mongo() throws Exception {
		return new MongoClient("127.0.0.1", 27017);
	}
	
	@Override
	protected String getMappingBasePackage() {
		return "edu.nyit.CSCI455.MeterProject.Data";
	}
}
