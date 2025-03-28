package it.epicode.prestito;

import it.epicode.catalogo.ElementoPrestato;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PrestitoDAO {
    EntityManager em;

    public void save(Prestito prestito){

        em.persist(prestito);

    }

    public Prestito getByUtente(Long numeroDiTessera){
        return em.find(Prestito.class, numeroDiTessera);
    }

    public void delete(Prestito prestito){

        em.remove(prestito);

    }

    public void deleteByUtente(Long numeroDiTessera){
        delete(getByUtente(numeroDiTessera));
    }

    public void update(Prestito prestito){

        em.merge(prestito);

    }
    public void getById(Long id){
        em.find(Prestito.class, id);
    }



}
