package com.spring.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.blog.model.Autor;

public interface AutorRepository extends JpaRepository<Autor, Integer> {

}
