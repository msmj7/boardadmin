package com.boardadmin.board.repository;

import com.boardadmin.board.model.Likes;
import com.boardadmin.board.model.Post;
import com.boardadmin.user.model.User;

import jakarta.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeRepository extends JpaRepository<Likes, Long> {
    boolean existsByUserAndPost(User user, Post post);
    Likes findByUserAndPost(User user, Post post);
    
    @Modifying
    @Transactional
    void deleteByPost_PostId(Long postId);
}
