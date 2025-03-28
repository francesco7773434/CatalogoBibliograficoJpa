package it.epicode.utente;

import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UtenteDAO {
    EntityManager em;

    public void save(Utente utente){

        em.persist(utente);

    }

    public Utente getByNumeroDiTessera(Long numeroDiTessera){
        return em.find(Utente.class, numeroDiTessera);
    }
    public void delete(Utente utente){

        em.remove(utente);

    }
    public void deleteByNumeroDiTessera(Long numeroDiTessera){
        delete(getByNumeroDiTessera(numeroDiTessera));
    }
    public void update(Utente utente){

        em.merge(utente);

    }

    public void getById(Long id){
        em.find(Utente.class, id);
    }

}
