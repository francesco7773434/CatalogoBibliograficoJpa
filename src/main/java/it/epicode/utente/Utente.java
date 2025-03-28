package it.epicode.utente;

import it.epicode.prestito.Prestito;
import jakarta.persistence.*;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;


@Entity
@Table(name = "utenti")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Utente {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long numeroDiTessera;
    @Column(length = 100, nullable = false)
    private String nome;
    @Column(length = 100, nullable = false)
    private String cognome;
    @Column(length = 100)
    private String dataDiNascita;
    @OneToMany(mappedBy = "utente")
    private List<Prestito> prestiti;


}
