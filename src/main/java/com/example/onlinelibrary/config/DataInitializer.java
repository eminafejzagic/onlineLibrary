package com.example.onlinelibrary.config;


import com.example.onlinelibrary.model.Autor;
import com.example.onlinelibrary.model.Clan;
import com.example.onlinelibrary.model.Knjiga;
import com.example.onlinelibrary.service.AutorService;
import com.example.onlinelibrary.service.ClanService;
import com.example.onlinelibrary.service.KnjigaService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {
    private final AutorService autorService;
    private final KnjigaService knjigaService;
    private final ClanService clanService;

    public DataInitializer(AutorService autorService, KnjigaService knjigaService, ClanService clanService) {
        this.autorService = autorService;
        this.knjigaService = knjigaService;
        this.clanService = clanService;
    }

    @Override
    public void run(String... args) throws Exception{
        if(autorService.findAll().isEmpty()) {
            Autor a1 = autorService.save(new Autor(null, "Ivo", "Andric", 1892));
            Autor a2 = autorService.save(new Autor(null, "Mesa", "Selimovic", 1910));
            Autor a3 = autorService.save(new Autor(null, "J.K.", "Rowling", 1965));
            Autor a4 = autorService.save(new Autor(null, "Branko", "Copic", 1915));
            Autor a5 = autorService.save(new Autor(null, "George", "Orwell", 1903));
            Autor a6 = autorService.save(new Autor(null, "Fyodor", "Dostoevsky", 1821));
            Autor a7 = autorService.save(new Autor(null, "Agatha", "Christie", 1890));
            Autor a8 = autorService.save(new Autor(null, "Stephen", "King", 1947));


            Clan c1 = clanService.save(new Clan(null, "Marko", "Markovic", "marko@gmail.com", "MEM-1001"));

            saveKnjiga("Na Drini cuprija", "Roman", 1945, a1, c1);
            saveKnjiga("Dervis i smrt", "Roman", 1966, a2, c1);
            saveKnjiga("Harry Potter", "Fantastika", 1977, a3, null);
            saveKnjiga("Prokleta avlija", "Roman", 1954, a1, null);
            saveKnjiga("Tvrdjava", "Roman", 1970, a2, null);
            saveKnjiga("Orlovi rano lete", "Deciji roman", 1957, a4, null);
            saveKnjiga("Magarece godine", "Deciji roman", 1960, a4, null);
            saveKnjiga("1984", "Dystopian", 1949, a5, null);
            saveKnjiga("Zivotinjska farma", "Politicka satira", 1945, a5, null);
            saveKnjiga("Zlocin i kazna", "Psiholoski roman", 1866, a6, null);
            saveKnjiga("Braca Karamazovi", "Psiholoski roman", 1880, a6, null);
            saveKnjiga("Ubistvo u Orient Expressu", "Kriminalisticki", 1934, a7, null);
            saveKnjiga("Isijavanje", "Horor", 1977, a8, null);
        }
    }

    private void saveKnjiga(String naslov, String zanr, int godinaIzdanja, Autor autor,Clan clan){
        Knjiga k = new Knjiga();
        k.setNaslov(naslov);
        k.setZanr(zanr);
        k.setGodinaIzdanja(godinaIzdanja);
        k.setAutor(autor);
        k.setClan(clan);
        knjigaService.save(k);
    }
}
