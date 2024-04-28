package com.example.Spring_Blog_Application.controller;





import com.example.Spring_Blog_Application.services.CommentsService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
@CrossOrigin
public class CommentController {
    @Autowired
    private CommentsService commentService;

    @PostMapping("comments/created")

    public ResponseEntity<?> createPostComment(@RequestParam ObjectId postId, @RequestParam String postedBy, @RequestBody String contant){

        try{

            return ResponseEntity.ok(commentService.createComment(postId,postedBy,contant));


        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(e.getMessage());
        }
    }
    @GetMapping("comments/{postId}")
    public ResponseEntity<?> getCommetsByPostId(@PathVariable ObjectId postId){
        try{
            return ResponseEntity.ok(commentService.getCommentsById(postId));


        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("something went wrong");
        }
    }
}
