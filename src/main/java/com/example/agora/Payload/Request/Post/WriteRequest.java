package com.example.agora.Payload.Request.Post;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class WriteRequest {
    private String title;
    private String contents;
}
