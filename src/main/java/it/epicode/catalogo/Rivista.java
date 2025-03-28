package it.epicode.catalogo;

import it.epicode.prestito.Prestito;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data

@NoArgsConstructor
public class Rivista extends ElementoPrestato {
    @Enumerated(EnumType.STRING)
    private Periodicità periodicità;

    public Rivista(Long isbn, String titolo, int annoPubblicazione, int numeroPagine, List<Prestito> prestiti, Periodicità periodicità) {
        super(isbn, titolo, annoPubblicazione, numeroPagine, prestiti);
        this.periodicità = periodicità;
    }

    public Rivista(Periodicità periodicità) {
        this.periodicità = periodicità;
    }
}
