package br.com.iacademy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EntityScan(basePackages= {"br.com.iacademy.model"})
@ComponentScan(basePackages= {"br.com.iacademy.*"})
@EnableJpaRepositories(basePackages = {"br.com.iacademy.repository"})
@EnableTransactionManagement

public class IAcademyApplication {

	public static void main(String[] args) throws Exception{
		SpringApplication.run(IAcademyApplication.class, args);
	}
}