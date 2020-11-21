package com.example.agora.Payload.Request.Post;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ModifyCommentRequest {
    private int cmtId;
    private String comment;
}
