package com.idea.bakflow.service;

import com.idea.bakflow.model.Post;

import java.util.List;
import java.util.Optional;

public interface PostService {
    List<Post> findAllPosts();

    Optional<Post> findPost(Long id);

    Post createPost(Post post);

    Post editPost(Post post);

    void deletePost(Long id);
}
