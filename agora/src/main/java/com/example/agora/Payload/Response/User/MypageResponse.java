package com.example.agora.Payload.Response.User;

import com.example.agora.Payload.Response.Post.Search.SearchData;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class MypageResponse {
    private final String userId;
    private final List<SearchData> postList;
}
