package com.example.Spring_Blog_Application.services;

import com.example.Spring_Blog_Application.Repository.CommentsRepo;
import com.example.Spring_Blog_Application.Repository.PostRepo;
import com.example.Spring_Blog_Application.entity.Comments;
import com.example.Spring_Blog_Application.entity.Post;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
@Service
public class CommentsServiceImp implements CommentsService{
    @Autowired
    private CommentsRepo comentRepo;
    @Autowired
    private PostRepo postRepo;
    @Override
    public Comments createComment(ObjectId postId, String postedBy, String contant) {
        Optional<Post> optionalPost=postRepo.findById(postId);
        if(optionalPost.isPresent()){
            Comments comment=new Comments();
            comment.setPost(optionalPost.get());
            comment.setContant(contant);
            comment.setPostedBy(postedBy);
            comment.setCreatedAt(new Date());
            return comentRepo.save(comment);



        }
        throw new RuntimeException("Post not found");
    }

    @Override
    public List<Comments> getCommentsById(ObjectId postId) {
        return comentRepo.findByPostId(postId);
    }

}
