package com.spring.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.blog.model.Leitor;

public interface LeitorRepository extends JpaRepository<Leitor, Integer> {
    
}
