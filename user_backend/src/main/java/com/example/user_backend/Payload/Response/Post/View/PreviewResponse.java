package com.example.agora.Payload.Response.Post.View;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@AllArgsConstructor
@Getter
public class PreviewResponse {
    private final String postId;
    private final String title;
    private final String userId;
    private final Date createAt;
    private final Date modifyAt;
}
