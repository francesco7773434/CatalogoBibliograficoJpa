package it.epicode.catalogo;

import it.epicode.prestito.Prestito;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data

@NoArgsConstructor
public class Libro extends ElementoPrestato{
    @Column(length = 100)
    private String autore;
    @Column(length = 100)
    private String genere;

    public Libro(Long isbn, String titolo, int annoPubblicazione, int numeroPagine, List<Prestito> prestiti, String autore, String genere) {
        super(isbn, titolo, annoPubblicazione, numeroPagine, prestiti);
        this.autore = autore;
        this.genere = genere;
    }

    public Libro(String autore, String genere) {
        this.autore = autore;
        this.genere = genere;
    }
}
