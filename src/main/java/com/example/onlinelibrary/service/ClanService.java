package com.example.onlinelibrary.service;

import com.example.onlinelibrary.model.Clan;
import com.example.onlinelibrary.model.Knjiga;
import com.example.onlinelibrary.repository.ClanRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClanService {
    private final ClanRepository repo;

    public ClanService(ClanRepository repo) {
        this.repo = repo;
    }

    public List<Clan> findAll() {
        return repo.findAll();
    }

    public Clan findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Clan save(Clan clan) {
        return repo.save(clan);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}

