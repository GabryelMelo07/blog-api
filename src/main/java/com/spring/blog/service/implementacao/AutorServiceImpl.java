package com.spring.blog.service.implementacao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.blog.model.Autor;
import com.spring.blog.repository.AutorRepository;
import com.spring.blog.service.AutorService;

@Service
public class AutorServiceImpl implements AutorService {

    @Autowired
    private AutorRepository autorRepository;

    public AutorServiceImpl(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }
    
    @Override
    public List<Autor> getAll() {
        return autorRepository.findAll();
    }

    @Override
    public Autor getById(int id) {
        return autorRepository.findById(id).get();
    }

    @Override
    public Autor save(Autor autor) {
        return autorRepository.save(autor);
    }

    @Override
    public Autor update(int id, Autor autor) {
        Autor autorAtualizado = autorRepository.findById(id).get();
        autorAtualizado.setNome(autor.getNome());
        autorAtualizado.setEmail(autor.getEmail());
        autorAtualizado.setSenha(autor.getSenha());
        if (autor.getPosts() != null) {
            autorAtualizado.setPosts(autor.getPosts());
        }
        return autorRepository.save(autorAtualizado);
    }

    @Override
    public boolean delete(int id) {
        if (autorRepository.existsById(id)) {
            autorRepository.deleteById(id);
            return true;
        }
        return false;
    }
    
}
