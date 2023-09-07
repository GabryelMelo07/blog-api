package com.spring.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.blog.model.Leitor;
import com.spring.blog.service.LeitorService;

@RestController
@RequestMapping("/leitor")
public class LeitorController {

    @Autowired
    private LeitorService leitorService;

    public LeitorController(LeitorService leitorService) {
        this.leitorService = leitorService;
    }

    @GetMapping
    public ResponseEntity<List<Leitor>> getAll() {
        List<Leitor> leitor = leitorService.getAll();
        return ResponseEntity.ok().body(leitor);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Leitor> getById(@PathVariable int id) {
        Leitor leitor = leitorService.getById(id);
        return ResponseEntity.ok().body(leitor);
    }

    @PostMapping
    public ResponseEntity<Leitor> save(@RequestBody Leitor leitor) {
        leitorService.save(leitor);
        return ResponseEntity.ok().body(leitor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Leitor> update(@PathVariable int id, @RequestBody Leitor leitor) {
        leitorService.update(id, leitor);
        return ResponseEntity.ok().body(leitor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable int id) {
        boolean deletado = leitorService.delete(id);
        if (deletado) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
        }
    }
    
}
