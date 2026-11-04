package com.example.onlinelibrary.repository;

import com.example.onlinelibrary.model.Clan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


    @Repository
    public interface ClanRepository extends JpaRepository<Clan, Long>{}

