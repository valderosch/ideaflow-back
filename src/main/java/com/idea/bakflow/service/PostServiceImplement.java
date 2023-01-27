package com.idea.bakflow.service;

import com.idea.bakflow.model.Post;
import com.idea.bakflow.repository.PostRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;


@Service
@Transactional(readOnly = true)
public class PostServiceImplement implements PostService{

    @Resource
    private PostRepository postRepository;

    @Override
    public List<Post> findAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public Optional<Post> findPost(Long id) {
        return Optional.empty();
    }

    @Transactional(readOnly = false)
    @Override
    public Post createPost(Post post) {
        return null;
    }

    @Transactional(readOnly = false)
    @Override
    public Post editPost(Post post) {
        return null;
    }

    @Transactional(readOnly = false)
    @Override
    public Post deletePost(Post post) {
        return null;
    }
}
