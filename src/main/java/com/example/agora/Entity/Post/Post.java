package com.example.agora.Entity.Post;

import com.example.agora.Entity.Comment.Comment;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Post")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int postId;

    @NonNull
    @Column(length = 30)
    private String title;

    @NonNull
    @Length(max = 1000)
    private String contents;

    @NonNull
    private String userId;

    @CreationTimestamp
    private Date createAt;

    private Date modifyAt;

    @NonNull
    private int view;

    @NonNull
    private int likes;

    @OneToMany(mappedBy = "post", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Comment> comments;
}