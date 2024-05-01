package com.example.Spring_Blog_Application.services;

import com.example.Spring_Blog_Application.entity.Comments;
import org.bson.types.ObjectId;

import java.util.List;

public interface CommentsService {
    Comments createComment(String postId, String postedBy, String contant);
    List<Comments> getCommentsById(String postId);
}
