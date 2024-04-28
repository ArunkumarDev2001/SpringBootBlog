package com.example.Spring_Blog_Application.entity;






import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.Date;


@Document(collection = "comments")
@AllArgsConstructor
@NoArgsConstructor
@Data

public class Comments {
    @Id

    private ObjectId id;
    private String Contant;
    private Date createdAt;
    private String postedBy;

    //    @ManyToOne
//    @JoinColumn(name = "post-Id",nullable = false)
    @DocumentReference
    private Post post;

}

