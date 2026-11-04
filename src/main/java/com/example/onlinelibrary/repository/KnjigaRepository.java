package com.example.onlinelibrary.repository;

import com.example.onlinelibrary.model.Knjiga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


    @Repository
    public interface KnjigaRepository extends JpaRepository<Knjiga, Long>{
        List<Knjiga> findByAutorId(Long autorId);
    }

