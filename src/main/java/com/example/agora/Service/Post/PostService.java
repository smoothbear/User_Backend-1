package com.example.agora.Service.Post;

import com.example.agora.Payload.Request.Post.ModifyRequest;
import com.example.agora.Payload.Request.Post.SearchRequest;
import com.example.agora.Payload.Request.Post.PostIdRequest;
import com.example.agora.Payload.Request.Post.WriteRequest;
import com.example.agora.Payload.Response.MessageResponse;
import com.example.agora.Payload.Response.Post.View.PreviewResponse;
import com.example.agora.Payload.Response.Post.Search.SearchResponse;
import com.example.agora.Payload.Response.Post.View.ViewResponse;

public interface PostService {
    public MessageResponse write(WriteRequest request);
    public PreviewResponse preview(PostIdRequest request);
    public ViewResponse view(PostIdRequest request);
    public SearchResponse search(SearchRequest request);
    public SearchResponse list();
    public MessageResponse modify(ModifyRequest request);
    public MessageResponse delete(PostIdRequest request);
}
