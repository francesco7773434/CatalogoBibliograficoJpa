package it.epicode.catalogo;

import it.epicode.prestito.Prestito;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "elemento_prestato")
@Data
@AllArgsConstructor
@NoArgsConstructor
@NamedQueries({

        @NamedQuery(name = "ElementoPrestato.findByAnnoPubblicazione", query = "SELECT e FROM ElementoPrestato e WHERE e.annoPubblicazione = :annoPubblicazione"),
        @NamedQuery(name = "ElementoPrestato.findByAutore", query = "SELECT e FROM ElementoPrestato e WHERE e.autore = :autore"),
        @NamedQuery(name = "ElementoPrestato.findByTitolo", query = "SELECT e FROM ElementoPrestato e WHERE e.titolo LIKE :titolo"),

})
public abstract class ElementoPrestato {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long isbn;
    @Column(length = 100, nullable = false)
    private String titolo;
    private int annoPubblicazione;
    private int numeroPagine;
    @OneToMany(mappedBy = "elementoPrestato")
    private List<Prestito> prestiti;
}
