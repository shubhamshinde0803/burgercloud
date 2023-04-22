package srs.example.burgerCloudApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;


@SpringBootApplication(exclude = {JpaRepositoriesAutoConfiguration.class})
public class BurgerCloudApplication {

	public static void main(String[] args) {
		SpringApplication.run(BurgerCloudApplication.class, args);
	}

}
