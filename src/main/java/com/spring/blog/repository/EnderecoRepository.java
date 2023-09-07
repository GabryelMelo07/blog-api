package com.spring.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.blog.model.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {
    
}
