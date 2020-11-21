package com.example.agora.Payload.Response.Post.Search;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class SearchResponse {
    private final List<SearchData> searchData;
}
