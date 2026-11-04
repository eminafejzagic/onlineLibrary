package com.example.onlinelibrary.controller;

import com.example.onlinelibrary.model.Clan;
import com.example.onlinelibrary.service.ClanService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clanovi")
public class ClanRestController {
    private final ClanService service;

    public ClanRestController(ClanService service) {
        this.service = service;
    }

    @GetMapping
    public List<Clan> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Clan getOne(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public Clan add(@RequestBody Clan c) {
        return service.save(c);
    }

    @PutMapping("/{id}")
    public Clan update(@PathVariable Long id, @RequestBody Clan c) {
        c.setId(id);
        return service.save(c);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
