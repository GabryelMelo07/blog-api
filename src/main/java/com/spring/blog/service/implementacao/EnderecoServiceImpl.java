package com.spring.blog.service.implementacao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.blog.model.Endereco;
import com.spring.blog.repository.EnderecoRepository;
import com.spring.blog.service.EnderecoService;

@Service
public class EnderecoServiceImpl implements EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    public EnderecoServiceImpl(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }
    
    @Override
    public List<Endereco> getAll() {
        return enderecoRepository.findAll();
    }

    @Override
    public Endereco getById(int id) {
        return enderecoRepository.findById(id).get();
    }

    @Override
    public Endereco save(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

    @Override
    public Endereco update(int id, Endereco endereco) {
        Endereco enderecoAtualizado = enderecoRepository.findById(id).get();
        enderecoAtualizado.setBairro(endereco.getBairro());
        enderecoAtualizado.setRua(endereco.getRua());
        enderecoAtualizado.setNumero(endereco.getNumero());
        enderecoAtualizado.setComplemento(endereco.getComplemento());
        enderecoAtualizado.setCep(endereco.getCep());
        return enderecoRepository.save(enderecoAtualizado);
    }

    @Override
    public boolean delete(int id) {
        if (enderecoRepository.existsById(id)) {
            enderecoRepository.deleteById(id);
            return true;
        }
        return false;
    }
    
}
