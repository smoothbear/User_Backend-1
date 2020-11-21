package com.example.agora.Payload.Response.Post.Comment;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@AllArgsConstructor
@Getter
public class CommentResponse {
    private final int cmtId;
    private final String userId;
    private final String contents;
    private final Date createAt;
    private final Date modifyAt;
    private final int likes;
}
