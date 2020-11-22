package com.example.agora.Controller.Post;

import com.example.agora.Payload.Request.Post.*;
import com.example.agora.Payload.Response.MessageResponse;
import com.example.agora.Payload.Response.Post.View.PreviewResponse;
import com.example.agora.Payload.Response.Post.Search.SearchResponse;
import com.example.agora.Payload.Response.Post.View.ViewResponse;
import com.example.agora.Service.Comment.CommentService;
import com.example.agora.Service.Post.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/post")
@Slf4j
@CrossOrigin(origins = "*")
public class PostController {
    private final PostService postService;
    private final CommentService commentService;

    @PostMapping("/write")
    public MessageResponse write(@RequestBody WriteRequest request){
        log.info("\nPOST /post/write\nTitle : " + request.getTitle() + "\nContents : " + request.getContents());
        return postService.write(request);
    }

    @PostMapping("/preview")
    public PreviewResponse preview(@RequestBody PostIdRequest request){
        log.info("\nPOST /post/preview\nPostId : " + request.getPostId());
        return postService.preview(request);
    }

    @PostMapping("/view")
    public ViewResponse view(@RequestBody PostIdRequest request){
        log.info("\nPOST /post/view\nPostId : " + request.getPostId());
        return postService.view(request);
    }

    @PostMapping("/search")
    public SearchResponse search(@RequestBody SearchRequest request){
        log.info("\nPOST /post/search\nTitle : " + request.getTitle());
        return postService.search(request);
    }

    @GetMapping("/list")
    public SearchResponse list(){
        log.info("\nGET /post/list");
        return postService.list();
    }

    @PatchMapping("/modify")
    public MessageResponse modify(@RequestBody ModifyRequest request){
        log.info("\nPATCH /post/modify\nPostId : " + request.getPostId() + "\nTitle : " + request.getTitle() + "\nContents : " + request.getContents());
        return postService.modify(request);
    }

    @PatchMapping("/comment/modify")
    public MessageResponse commentModify(@RequestBody CommentModifyRequest request){
        log.info("\nPATCH /post/comment/modify\nCmtId : " + request.getCmtId() + "\nComment : " + request.getComment());
        return commentService.modifyComment(request);
    }

    @PostMapping("/delete")
    @Transactional
    public MessageResponse delete(@RequestBody PostIdRequest request){
        log.info("\nPOST /post/delete\nPostId : " + request.getPostId());
        return postService.delete(request);
    }

    @PostMapping("/comment")
    public MessageResponse comment(@RequestBody CommentRequest request){
        log.info("POST /post/comment\nPostId : " + request.getPostId() + "\nComment : " + request.getComment());
        return commentService.comment(request);
    }

    @PatchMapping("/like")
    public MessageResponse like(@RequestBody PostIdRequest request){
        log.info("PATCH /post/like\nPostId : " + request.getPostId());
        return postService.like(request);
    }

    @PatchMapping("/comment/like")
    public MessageResponse commentLike(@RequestBody CmtIdRequest request){
        log.info("Post /post/comment/like\nCmtId : " + request.getCmtId());
        return commentService.commentLike(request);
    }

}
