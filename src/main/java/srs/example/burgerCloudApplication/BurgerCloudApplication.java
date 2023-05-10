package srs.example.burgerCloudApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@SpringBootApplication(scanBasePackages = {"srs.example.burgerCloudApplication.data","srs.example.burgerCloudApplication.domain", "srs.example.burgerCloudApplication.web","srs.example.burgerCloudApplication.security","srs.example.burgerCloudApplication.service"})
public class BurgerCloudApplication {

	public static void main(String[] args) {
		SpringApplication.run(BurgerCloudApplication.class, args);
	}

}
