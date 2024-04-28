package com.example.Spring_Blog_Application.entity;




import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document(collection = "Posts")
@Data
@AllArgsConstructor
@NoArgsConstructor


public class Post {
    @Id
    private ObjectId id;
    private String name;

    private String contant;
    private String postedBy;
    private String image;
    private Date date;
    private int LikeCount;
    private int viewCount;
    private List<String> tags;


}
