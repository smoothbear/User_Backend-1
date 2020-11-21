package com.example.agora.Payload.Request.Post;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ModifyRequest {
    private String postId;
    private String title;
    private String contents;
}
