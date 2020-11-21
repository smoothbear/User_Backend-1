package com.example.agora.Payload.Request.Post;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CommentModifyRequest {
    private String cmtId;
    private String comment;
}
