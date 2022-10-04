package pro.sky.collections_and_set;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pro.sky.collections_and_set.model.Employee;

@SpringBootApplication
public class CollectionsAndSetApplication {

	public static void main(String[] args) {
		SpringApplication.run(CollectionsAndSetApplication.class, args);

		Employee employee = new Employee("Saha", "Ivanov");
	}

}
