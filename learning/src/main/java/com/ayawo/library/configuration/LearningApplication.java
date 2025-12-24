package com.ayawo.library.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan("com.ayawo.library.book.model")
@EnableJpaRepositories(basePackages = "com.ayawo.library.book.persistence")
@SpringBootApplication(scanBasePackages = {
        "com.ayawo.library"
})
public class LearningApplication {

	public static void main(String[] args) {
        SpringApplication.run(LearningApplication.class, args);
	}

}
