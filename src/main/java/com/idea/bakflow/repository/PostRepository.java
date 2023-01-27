package com.idea.bakflow.repository;

import com.idea.bakflow.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {

}
