package com.spring.blog.service;

import java.util.List;

import com.spring.blog.model.Leitor;

public interface LeitorService {
    List<Leitor> getAll();
    Leitor getById(int id);
    Leitor save(Leitor leitor);
    Leitor update(int id, Leitor leitor);
    boolean delete(int id);
}
