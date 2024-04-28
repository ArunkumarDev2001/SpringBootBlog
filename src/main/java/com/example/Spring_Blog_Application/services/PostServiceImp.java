package com.example.Spring_Blog_Application.services;

import com.example.Spring_Blog_Application.Repository.PostRepo;
import com.example.Spring_Blog_Application.entity.Post;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
@Service
public class PostServiceImp implements PostServices{


    @Autowired
    private PostRepo postRepo;
    @Override
    public Post savePost(Post post){
        post.setLikeCount(0);
        post.setViewCount(0);
        post.setDate(new Date());

        return postRepo.save(post);

    }
    @Override
    public List<Post> getAllPost(){
        return postRepo.findAll();
    }


    @Override
    public Post  getById(ObjectId id){
        Optional<Post> op=postRepo.findById(id);
        if(op.isPresent()){
            Post post=op.get();
            post.setViewCount(post.getViewCount()+1);
            return postRepo.save(post);
        }else{
            throw new RuntimeException();
        }
    }
    @Override
    public void likePost(ObjectId postId){
        Optional<Post> op=postRepo.findById(postId);
        if(op.isPresent()){

            Post post=op.get();
            post.setLikeCount(post.getLikeCount()+1);

            postRepo.save(post);
        }else{
            throw new RuntimeException("post not found "+postId);
        }
    }
    @Override
    public List<Post> searchPost(String name){
        return postRepo.findAllByNameContaining(name);
    }
}


