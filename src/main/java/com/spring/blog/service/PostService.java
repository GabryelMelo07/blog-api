package com.spring.blog.service;

import java.util.List;

import com.spring.blog.model.Post;

public interface PostService {
    List<Post> getAll();
    Post getById(int id);
    Post save(Post post);
    Post update(int id, int autorId, Post post);
    boolean delete(int id);
}
