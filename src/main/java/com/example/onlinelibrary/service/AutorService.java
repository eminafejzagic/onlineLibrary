package com.example.onlinelibrary.service;

import com.example.onlinelibrary.model.Autor;
import com.example.onlinelibrary.repository.AutorRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AutorService{
    private final AutorRepository repo;

    public AutorService(AutorRepository repo) {
        this.repo = repo;
    }
    public List<Autor> findAll() {
        return repo.findAll();
    }

    public Autor findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Autor save(Autor autor) {
        return repo.save(autor);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
