package com.example.agora.Service.Comment;

import com.example.agora.Entity.Comment.Comment;
import com.example.agora.Entity.Comment.CommentRepository;
import com.example.agora.Entity.Post.PostRepository;
import com.example.agora.Exception.NoAuthorityException;
import com.example.agora.Exception.PostNotFoundException;
import com.example.agora.Payload.Request.Post.ModifyCommentRequest;
import com.example.agora.Payload.Response.MessageResponse;
import com.example.agora.Security.Jwt.Auth.AuthDetails;
import com.example.agora.Payload.Request.Post.CommentRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService{
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

    @Override
    public MessageResponse comment(CommentRequest request) {
        return postRepository.findById(Integer.parseInt(request.getPostId()))
                .map(post->{
                    AuthDetails AuthDetails = (AuthDetails)(SecurityContextHolder.getContext().getAuthentication().getPrincipal());

                    Comment comment = Comment.builder()
                            .contents(request.getComment())
                            .userId(AuthDetails.getUsername())
                            .post(post)
                            .createAt(new Date())
                            .build();
                    commentRepository.save(comment);
                    return new MessageResponse("댓글 작성 성공");
                }).orElseThrow(PostNotFoundException::new);
    }

    @Override
    public MessageResponse modifyComment(ModifyCommentRequest request) {
        AuthDetails authDetails = (AuthDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        commentRepository.findById(request.getCmtId())
                .map(comment->{
                    if(!authDetails.getUsername().equals(comment.getUserId()))
                        throw new NoAuthorityException();
                    return commentRepository.save(modify(request, comment));
                });
        return new MessageResponse("댓글 수정 완료!");
    }

    public Comment modify(ModifyCommentRequest request, Comment comment){
        return Comment.builder()
                .post(comment.getPost())
                .createAt(comment.getCreateAt())
                .cmtId(comment.getCmtId())
                .contents(request.getComment())
                .likes(comment.getLikes())
                .modifyAt(new Date())
                .userId(comment.getUserId())
                .build();
    }
}
