package spring.study.springrest;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRestApplication.class, args);
		}

	@Bean
	public ModelMapper modelMapper() { // Теперь этот бин находится в контексте спринга
		return new ModelMapper();

	}

}

