package com.example.agora.Entity.Post;

import com.example.agora.Payload.Response.Post.Search.SearchData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
    List<Post> findAllByTitleContaining(String title);
    List<Post> findTop100ByOrderByModifyAtDescCreateAtDesc();
    int deleteByPostId(int postId);
}
