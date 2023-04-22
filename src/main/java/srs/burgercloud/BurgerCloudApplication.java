package srs.burgercloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class BurgerCloudApplication implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(BurgerCloudApplication.class, args);
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry){
		System.out.println("implemented home controller with view controllers");
		registry.addViewController("/").setViewName("home");
	}

}
