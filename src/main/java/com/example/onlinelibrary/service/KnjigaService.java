package com.example.onlinelibrary.service;

import com.example.onlinelibrary.model.Autor;
import com.example.onlinelibrary.model.Knjiga;
import com.example.onlinelibrary.repository.KnjigaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KnjigaService {

    private final KnjigaRepository repo;

    public KnjigaService(KnjigaRepository repo) {
        this.repo = repo;
    }

    public List<Knjiga> findAll() {
        return repo.findAll();
    }

    public Knjiga findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Knjiga save(Knjiga knjiga) {
        return repo.save(knjiga);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public List<Knjiga> findByAutorId (Long autorId){
        return repo.findByAutorId(autorId);
    }

}
