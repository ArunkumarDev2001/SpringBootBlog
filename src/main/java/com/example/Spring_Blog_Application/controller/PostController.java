package com.example.Spring_Blog_Application.controller;





import com.example.Spring_Blog_Application.entity.Post;
import com.example.Spring_Blog_Application.services.PostServices;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/posts")
@CrossOrigin(origins = "*")
public class PostController {

    @Autowired
    private PostServices postServices;

    @PostMapping
    public ResponseEntity<?>createPost(@RequestBody Post post){
        try{
            Post createdPost=postServices.savePost(post);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdPost);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Post>> getAll(){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(postServices.getAllPost());


        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?>getPostById(@PathVariable ObjectId id){
        try{
            Post post=postServices.getById(id);
            return ResponseEntity.ok(post);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

    }

    @PutMapping("/{postId}/like")
    public ResponseEntity<?> likePost(@PathVariable ObjectId postId){
        try {
            postServices.likePost(postId);
            return ResponseEntity.ok(new String[]{"Post liked successfully."});

        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

    }

    @GetMapping("/search/{name}")

    public ResponseEntity<?> searchPost(@PathVariable String name){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(postServices.searchPost(name));

        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

        }

    }

}

