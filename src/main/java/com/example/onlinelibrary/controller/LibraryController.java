package com.example.onlinelibrary.controller;

import com.example.onlinelibrary.data.LibraryData;
import com.example.onlinelibrary.model.Clan;
import com.example.onlinelibrary.service.AutorService;
import com.example.onlinelibrary.service.ClanService;
import com.example.onlinelibrary.service.KnjigaService;
import org.springframework.stereotype.Controller;
import com.example.onlinelibrary.data.LibraryData;
import com.example.onlinelibrary.model.Knjiga;
import com.example.onlinelibrary.model.Autor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class LibraryController {

    //ovdje ces povezati services i ne treba vise LibraryData

    private final AutorService autorServ;
    private final KnjigaService knjigaServ;
    private final ClanService clanServ;

    public LibraryController(ClanService clanServ, KnjigaService knjigaServ, AutorService autorServ) {
        this.clanServ = clanServ;
        this.knjigaServ = knjigaServ;
        this.autorServ = autorServ;
    }
/*
    private final LibraryData data;
    public LibraryController(LibraryData data) {
        this.data = data;
    }
    */


    @GetMapping("/")
    public String home(){
        return "redirect:/autori";
    }

    @GetMapping("/autori")
    public String autori(Model model) {
        model.addAttribute("autori", autorServ.findAll());
        model.addAttribute("noviAutor", new Autor());
        return "autori";
    }

    @PostMapping("/autori/add")
    public String addAutor(@ModelAttribute("noviAutor") Autor autor) {
        autorServ.save(autor);
        return "redirect:/autori";
    }

    @GetMapping("/autori/delete/{id}")
    public String deleteAutor(@PathVariable Long id){
        autorServ.delete(id);
        return "redirect:/autori";
    }

    @GetMapping("/knjige")
    public String knjige(@RequestParam(required = false) Long autorId, Model model) {
        if (autorId != null) {
            // prikazuje samo knjige autora po ID
            Autor autor = autorServ.findById(autorId);
            model.addAttribute("knjige", knjigaServ.findById(autorId));
            model.addAttribute("odabraniAutor", autor);
        } else {
            // prikazuje sve knjige ako autorId nije proslijedjen
            model.addAttribute("knjige", knjigaServ.findAll());
        }
        model.addAttribute("novaKnjiga", new Knjiga());
        model.addAttribute("sviAutori", autorServ.findAll());
        return "knjige";
    }

    @PostMapping("/knjige/add")
    public String addKnjiga(@ModelAttribute("novaKnjiga") Knjiga knjiga){
        knjigaServ.save(knjiga);
        return "redirect:/knjige";
    }

    @GetMapping("/knjige/delete/{id}")
    public String deleteKnjiga(@PathVariable Long id){
        knjigaServ.delete(id);
        return "redirect:/knjige";
    }



    @GetMapping("/clanovi")
    public String clanovi(Model model){
        model.addAttribute("clanovi", clanServ.findAll());
        model.addAttribute("noviClan", new Clan());
        return "clanovi";
    }

    @PostMapping("/clanovi/add")
    public String addClan(@ModelAttribute("noviClan") Clan clan){
        clanServ.save(clan);
        return "redirect:/clanovi";
    }

    @GetMapping("/clanovi/edit/{id}")
    public String showEditClanForm(@PathVariable Long id, Model model){
        Clan clan = clanServ.findById(id);
        model.addAttribute("clan", clan);
        return "edit-clan";
    }

    @PostMapping("/clanovi/update/{id}")
    public String updateClan(@PathVariable Long id, @ModelAttribute("clan")Clan clan){
        clan.setId(id);
        clanServ.save(clan);
        return "redirect:/clanovi";
    }

    @GetMapping("/clanovi/delete/{id}")
    public String deleteClan(@PathVariable Long id){
        clanServ.delete(id);
        return "redirect:/clanovi";
    }
}


