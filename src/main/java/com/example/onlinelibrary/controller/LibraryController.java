package com.example.onlinelibrary.controller;

import com.example.onlinelibrary.data.LibraryData;
import org.springframework.stereotype.Controller;
import com.example.onlinelibrary.data.LibraryData;
import com.example.onlinelibrary.model.Knjiga;
import com.example.onlinelibrary.model.Autor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class LibraryController {
    private final LibraryData data;

    public LibraryController(LibraryData data) {
        this.data = data;
    }

    @GetMapping("/")
    public String home(){
        return "redirect:/autori";
    }

    @GetMapping("/autori")
    public String autori(Model model) {
        model.addAttribute("autori", data.findAllAuthors());
        return "autori";
    }

    @GetMapping("/knjige")
    public String knjige(@RequestParam(required = false) Long autorId, Model model) {
        if (autorId != null) {
            // prikazuje samo knjige autora po ID
            Autor autor = data.findAuthorById(autorId);
            model.addAttribute("knjige", autor != null ? autor.getKnjige() : List.of());
            model.addAttribute("odabraniAutor", autor);
        } else {
            // prikazuje sve knjige ako autorId nije proslijedjen
            model.addAttribute("knjige", data.findAllBooks());
        }
        return "knjige";
    }

}
