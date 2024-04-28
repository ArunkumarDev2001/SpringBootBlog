package com.example.Spring_Blog_Application.Repository;

import com.example.Spring_Blog_Application.entity.Comments;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentsRepo extends MongoRepository<Comments, ObjectId> {
    List<Comments> findByPostId(ObjectId postId);
}
