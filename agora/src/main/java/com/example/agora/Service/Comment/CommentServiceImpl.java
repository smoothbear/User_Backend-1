package com.example.agora.Service.Comment;

import com.example.agora.Entity.Comment.Comment;
import com.example.agora.Entity.Comment.CommentRepository;
import com.example.agora.Entity.Post.PostRepository;
import com.example.agora.Exception.CommentNotFoundException;
import com.example.agora.Exception.NoAuthorityException;
import com.example.agora.Exception.PostNotFoundException;
import com.example.agora.Payload.Request.Post.CmtIdRequest;
import com.example.agora.Payload.Request.Post.CommentModifyRequest;
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
    public MessageResponse modifyComment(CommentModifyRequest request) {
        AuthDetails user = (AuthDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return commentRepository.findById(Integer.parseInt(request.getCmtId()))
                .map(comment->{
                    if(!user.getUsername().equals(comment.getUserId()))
                        throw new NoAuthorityException();
                    commentRepository.save(modify(request, comment));
                    return new MessageResponse("댓글 수정 완료");
                }).orElseThrow(CommentNotFoundException::new);
    }

    @Override
    public MessageResponse commentLike(CmtIdRequest request) {
        return commentRepository.findById(Integer.parseInt(request.getCmtId()))
                .map(comment->{
                    commentRepository.save(like(comment));
                    return new MessageResponse("성공!");
                }).orElseThrow(CommentNotFoundException::new);
    }

    private Comment like(Comment comment){
        return Comment.builder()
                .post(comment.getPost())
                .createAt(comment.getCreateAt())
                .cmtId(comment.getCmtId())
                .contents(comment.getContents())
                .likes(comment.getLikes() + 1)
                .modifyAt(comment.getModifyAt())
                .userId(comment.getUserId())
                .build();
    }

    private Comment modify(CommentModifyRequest request, Comment comment){
        return Comment.builder()
                .userId(comment.getUserId())
                .modifyAt(new Date())
                .likes(comment.getLikes())
                .contents(request.getComment())
                .cmtId(comment.getCmtId())
                .createAt(comment.getCreateAt())
                .post(comment.getPost())
                .build();
    }
}
