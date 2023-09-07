package com.spring.blog.service;

import java.util.List;

import com.spring.blog.model.Autor;

public interface AutorService {
    List<Autor> getAll();
    Autor getById(int id);
    Autor save(Autor autor);
    Autor update(int id, Autor autor);
    boolean delete(int id);
}
