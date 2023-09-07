package com.spring.blog.service.implementacao;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import com.spring.blog.model.Autor;
import com.spring.blog.model.Post;
import com.spring.blog.repository.AutorRepository;
import com.spring.blog.repository.PostRepository;
import com.spring.blog.service.PostService;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private AutorRepository autorRepository;
    
    public PostServiceImpl(PostRepository postRepository, AutorRepository autorRepository) {
        this.postRepository = postRepository;
        this.autorRepository = autorRepository;
    }

    @Override
    public List<Post> getAll() {
        return postRepository.findAll();
    }

    @Override
    public Post getById(int id) {
        return postRepository.findById(id).get();
    }

    @Override
    @Transactional
    public Post save(@RequestBody Post post) {
        post.setDataHora(LocalDateTime.now());
        return postRepository.save(post);
    }

    @Override
    public Post update(int id, int autorId, @RequestBody Post post) {
        Post postAtualizado = postRepository.findById(id).get();
        postAtualizado.setTitulo(post.getTitulo());
        postAtualizado.setTexto(post.getTexto());
        postAtualizado.setDataHora(LocalDateTime.now());
        postAtualizado.setEditavelPorOutrosAutores(post.isEditavelPorOutrosAutores());
        
        Autor autor = autorRepository.findById(autorId).get();
        List<Autor> autores = new ArrayList<>();
        autores.add(autor);
        postAtualizado.setAutores(autores);
        
        return postRepository.save(postAtualizado);
    }

    @Override
    public boolean delete(int id) {
        if (postRepository.existsById(id)) {
            postRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
