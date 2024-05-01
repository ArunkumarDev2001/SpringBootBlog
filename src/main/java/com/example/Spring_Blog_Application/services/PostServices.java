package com.example.Spring_Blog_Application.services;

import com.example.Spring_Blog_Application.entity.Post;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PostServices {
    Post savePost(Post post);
    List<Post> getAllPost();
    Post getById(String id);;
    void likePost(String postId);
    List<Post> searchPost(String name);
}
