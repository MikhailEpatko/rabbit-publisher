package ru.epatko.rabbitpublisher;

import ru.epatko.rabbitpublisher.publisher.RabbitMessagePublisher;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	CommandLineRunner sendMessage(RabbitMessagePublisher publisher) {
		return args -> {
			for(int i = 0; i < 10; i++) {
				publisher.sendMessage(String.format("message %s", i));
				Thread.sleep(1000);
			}
		};
	}
}