package com.example.onlinelibrary.data;

import com.example.onlinelibrary.model.Autor;
import com.example.onlinelibrary.model.Knjiga;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Component
public class LibraryData {
    private final Map<Long, Autor> autori = new LinkedHashMap<>();
    private final Map<Long, Knjiga> knjige = new LinkedHashMap<>();
    private long autorSeq = 1;
    private long knjigaSeq = 1;

    public LibraryData() {

        saveAutor(new Autor(null, "Ivo", "Andric", 1892));
        saveAutor(new Autor(null, "Mesa", "Selimovic", 1910));
        saveAutor(new Autor(null, "J.K.", "Rowling", 1965));
        saveAutor(new Autor(null, "Branko", "Copic", 1915));
        saveAutor(new Autor(null, "George", "Orwell", 1903));
        saveAutor(new Autor(null, "Fyodor", "Dostoevsky", 1821));
        saveAutor(new Autor(null, "Agatha", "Christie", 1890));
        saveAutor(new Autor(null, "Stephen", "King", 1947));


        saveKnjiga(new Knjiga(null, "Na Drini cuprija", "Roman", 1945),1L);
        saveKnjiga(new Knjiga(null, "Dervis i smrt", "Roman", 1966), 2L);
        saveKnjiga(new Knjiga(null, "Harry Potter", "Fantastika", 1977), 3L);
        saveKnjiga(new Knjiga(null, "Prokleta avlija", "Roman", 1954), 1L);
        saveKnjiga(new Knjiga(null, "Tvrdjava", "Roman", 1970), 2L);
        saveKnjiga(new Knjiga(null, "Orlovi rano lete", "Deciji roman", 1957), 4L);
        saveKnjiga(new Knjiga(null, "Magarece godine", "Deciji roman", 1960), 4L);
        saveKnjiga(new Knjiga(null, "1984", "Dystopian", 1949), 5L);
        saveKnjiga(new Knjiga(null, "Zivotinjska farma", "Politicka satira", 1945), 5L);
        saveKnjiga(new Knjiga(null, "Zlocin i kazna", "Psiholoski roman", 1866), 6L);
        saveKnjiga(new Knjiga(null, "Braca Karamazovi", "Psiholoski roman", 1880), 6L);
        saveKnjiga(new Knjiga(null, "Ubistvo u Orient Expressu", "Kriminalisticki", 1934), 7L);
        saveKnjiga(new Knjiga(null, "Isijavanje", "Horor", 1977), 8L);
    }

    public Autor saveAutor(Autor autor){
        if(autor.getId()==null){
            autor.setId(autorSeq++);
        }
        autori.put(autor.getId(), autor); //greska jer smo pozivali objekat autor a put se koristi za mape
        return autor;
    }

    public List<Autor> findAllAuthors(){
        return new ArrayList<>(autori.values());
    }

    public Autor findAuthorById(Long id){
        return autori.get(id);
    }

    public Knjiga saveKnjiga(Knjiga knjiga){
        if(knjiga.getId()==null){
            knjiga.setId(knjigaSeq++);
        }
        knjige.put(knjiga.getId(), knjiga); //greska jer smo pozivali objekat autor a put se koristi za mape
        return knjiga;
    }

    public List<Knjiga> findAllBooks(){
        return new ArrayList<>(knjige.values());
    }

    public Knjiga findBookById(Long id) {
        return knjige.get(id);
    }

    //pomocna metoda za spremanje knjiga i dodjeljivanje autoru
    public Knjiga saveKnjiga(Knjiga knjiga, Long autorId) {
        Autor autor = findAuthorById(autorId);
        knjiga.setAutor(autor);
        autor.getKnjige().add(knjiga); // dodaje knjigu u listu autora ovo je zbog prikaza knjiga po autorId
        return saveKnjiga(knjiga);
    }
}




