package it.epicode.catalogo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ElementoPrestatoDAO {
    EntityManager em;

    public void save(ElementoPrestato elementoPrestato){

        em.persist(elementoPrestato);

    }

    // ricerca per isbn
    public ElementoPrestato getByISBN(Long isbn){
        return em.find(ElementoPrestato.class, isbn);
    }




    public List<ElementoPrestato> getByAnnoPubblicazione(int annoPubblicazione) {
        TypedQuery<ElementoPrestato> query = em.createNamedQuery("ElementoPrestato.findByAnnoPubblicazione", ElementoPrestato.class);
        query.setParameter("annoPubblicazione", annoPubblicazione);
        return query.getResultList();
    }



    public List<ElementoPrestato> getByAutore(String autore) {
        TypedQuery<ElementoPrestato> query = em.createNamedQuery("ElementoPrestato.findByAutore", ElementoPrestato.class);
        query.setParameter("autore", autore);
        return query.getResultList();
    }

    public List<ElementoPrestato> getByTitolo(String titolo) {
        TypedQuery<ElementoPrestato> query = em.createNamedQuery("ElementoPrestato.findByTitolo", ElementoPrestato.class);
        query.setParameter("titolo", "%" + titolo + "%");  // Usato % per la ricerca parziale
        return query.getResultList();
    }

   



    public void delete(ElementoPrestato elementoPrestato){

        em.remove(elementoPrestato);

    }
    public void deleteByISBN(Long isbn){
        delete(getByISBN(isbn));
    }
    public void update(ElementoPrestato elementoPrestato){

        em.merge(elementoPrestato);

    }
    public void updateByISBN(Long isbn, String newTitle){
        ElementoPrestato elementoPrestato = getByISBN(isbn);
        elementoPrestato.setTitolo(newTitle);
        update(elementoPrestato);
    }

}
