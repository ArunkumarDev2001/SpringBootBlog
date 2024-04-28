package com.example.Spring_Blog_Application.Repository;

import com.example.Spring_Blog_Application.entity.Post;
import com.mongodb.client.MongoClient;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepo extends MongoRepository<Post, ObjectId> {
    List<Post> findAllByNameContaining(String name);
}
