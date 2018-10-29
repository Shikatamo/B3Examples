package composite.coursestudentscomposite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CoursestudentscompositeApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoursestudentscompositeApplication.class, args);
	}
}
