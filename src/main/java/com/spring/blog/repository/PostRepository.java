package com.spring.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.blog.model.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {
    
}
