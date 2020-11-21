package com.example.agora.Service.Comment;

import com.example.agora.Payload.Request.Post.CommentRequest;
import com.example.agora.Payload.Request.Post.ModifyCommentRequest;
import com.example.agora.Payload.Response.MessageResponse;

public interface CommentService {
    public MessageResponse comment(CommentRequest request);
    public MessageResponse modifyComment(ModifyCommentRequest request);
}
