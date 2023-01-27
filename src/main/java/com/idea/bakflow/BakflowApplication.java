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
			Post post1 = new Post();
			post1.setAuthor("Vlad");
			post1.setTitle("Very cool course");
			post1.setDescription("This is how works java");

			Post post2 = new Post();
			post2.setAuthor("Gabriel");
			post2.setTitle("Very cool video about Dogs");
			post2.setDescription("I love Dogs. This is very funny and friendly animals");

			postRepository.save(post1);
			postRepository.save(post2);
		};
	}
}
