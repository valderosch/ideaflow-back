package com.idea.bakflow.controller;

import com.idea.bakflow.model.Post;
import com.idea.bakflow.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class PostController {

    @Autowired
    private PostService postService;
    @GetMapping("/posts")
    public List<Post> getAllPosts(){
        return postService.findAllPosts();
    }

    @GetMapping("posts/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable("id") Long id){
        Optional<Post> optPost = postService.findPost(id);

        if(optPost.isPresent()){
            Post post = optPost.get();
            return new ResponseEntity<Post>(post, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/posts")
    public ResponseEntity<Post> createPost(@RequestBody Post requestedPost){
        try{
            Post returnPost = postService.createPost(requestedPost);
            return new ResponseEntity<Post>(returnPost, HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PutMapping("/posts/{id}")
    public ResponseEntity<Post> editPost(@PathVariable("id") Long id, @RequestBody Post requestedPost){
        Optional<Post> optionalPost = postService.findPost(id);

        if(optionalPost.isPresent()){
            Post post = optionalPost.get();
            post.setTitle(requestedPost.getTitle());
            post.setDescription(requestedPost.getDescription());
            post.setAuthor(requestedPost.getAuthor());
            Post updatedPost = postService.editPost(post);
            return new ResponseEntity<Post>(updatedPost, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/posts/{id}")
    public ResponseEntity<HttpStatus> deletePost(@PathVariable("id") Long id){
        try{
            postService.deletePost(id);
            return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
}
