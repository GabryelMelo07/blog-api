package com.spring.blog.service;

import java.util.List;

import com.spring.blog.model.Endereco;

public interface EnderecoService {
    List<Endereco> getAll();
    Endereco getById(int id);
    Endereco save(Endereco endereco);
    Endereco update(int id, Endereco endereco);
    boolean delete(int id);
}
