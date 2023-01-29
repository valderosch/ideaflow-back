package com.idea.bakflow;

import com.idea.bakflow.model.Post;
import com.idea.bakflow.repository.PostRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BakflowApplication {

	public static void main(String[] args) {
		SpringApplication.run(BakflowApplication.class, args);
	}

	@Bean
	CommandLineRunner loadData(PostRepository postRepository){
		return (args) -> {
		};
	}
}
