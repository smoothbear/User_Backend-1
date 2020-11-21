package com.example.agora.Service.Comment;

import com.example.agora.Entity.Comment.Comment;
import com.example.agora.Entity.Comment.CommentRepository;
import com.example.agora.Entity.Post.PostRepository;
import com.example.agora.Exception.PostNotFoundException;
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
}
