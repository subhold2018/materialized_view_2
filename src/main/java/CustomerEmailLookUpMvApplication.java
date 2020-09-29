import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.lumendata")
@EnableJpaRepositories(basePackages = "com.lumendata.repository")
@EntityScan(basePackages = "com.lumendata.entity")
public class CustomerEmailLookUpMvApplication {
	public static void main(String[] args) {
		SpringApplication.run(CustomerEmailLookUpMvApplication.class, args);
	}
}