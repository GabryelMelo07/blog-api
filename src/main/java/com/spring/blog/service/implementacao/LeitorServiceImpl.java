package com.spring.blog.service.implementacao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.blog.model.Endereco;
import com.spring.blog.model.Leitor;
import com.spring.blog.repository.EnderecoRepository;
import com.spring.blog.repository.LeitorRepository;
import com.spring.blog.service.LeitorService;

@Service
public class LeitorServiceImpl implements LeitorService {

    @Autowired
    private LeitorRepository leitorRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    public LeitorServiceImpl(LeitorRepository leitorRepository, EnderecoRepository enderecoRepository) {
        this.leitorRepository = leitorRepository;
        this.enderecoRepository = enderecoRepository;
    }
    
    @Override
    public List<Leitor> getAll() {
        return leitorRepository.findAll();
    }

    @Override
    public Leitor getById(int id) {
        return leitorRepository.findById(id).get();
    }

    @Override
    public Leitor save(Leitor leitor) {
        Endereco endereco = leitor.getEndereco();
        if (endereco != null) {
            endereco = enderecoRepository.save(endereco);
        }
        leitor.setEndereco(endereco);
        
        return leitorRepository.save(leitor);
    }

    @Override
    public Leitor update(int id, Leitor leitor) {
        Leitor leitorAtualizado = leitorRepository.findById(id).get();
        leitorAtualizado.setNome(leitor.getNome());
        leitorAtualizado.setEmail(leitor.getEmail());
        leitorAtualizado.setSenha(leitor.getSenha());

        Endereco endereco = leitor.getEndereco();
        if (endereco != null) {
            endereco = enderecoRepository.save(endereco);
        }
        leitorAtualizado.setEndereco(endereco);

        return leitorRepository.save(leitorAtualizado);
    }

    @Override
    public boolean delete(int id) {
        if (leitorRepository.existsById(id)) {
            leitorRepository.deleteById(id);
            return true;
        }
        return false;
    }
    
}
