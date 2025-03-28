package it.epicode;

import it.epicode.catalogo.*;
import it.epicode.prestito.Prestito;
import it.epicode.prestito.PrestitoDAO;
import it.epicode.utente.Utente;
import it.epicode.utente.UtenteDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("epicode");
        EntityManager em = emf.createEntityManager();

        em.find(Libro.class, 1L);

        Libro libro = new Libro(null, "Harry Potter", 1997, 300,null, "J.K. Rowling", "Fantasy");
        Libro libro2 = new Libro(null, "Gli androidi sognano pecore elettriche?", 1999, 400, null, "Philip K. Dick", "Fantasy");

        Rivista rivista = new Rivista(null, "Pippo", 2022, 10, null, Periodicità.MENSILE);
        Rivista rivista2 = new Rivista(null, "Pluto", 2023, 20, null, Periodicità.SETTIMANALE);


        Utente utente = new Utente(null, "Giuseppe", "Verdi", "01/01/2000", null);
        Utente utente1 = new Utente(null, "Francesco", "Orbello", "03/06/1995", null);
        Utente utente2 = new Utente(null, "Francesco", "Orbello", "03/06/1995", null);

        Prestito prestito = new Prestito(null, utente, libro, "01/05/2018", "01/06/2018", null);
        Prestito prestito1 = new Prestito(null, utente1, rivista, "01/07/2018", "01/08/2018", null);
        Prestito prestito2 = new Prestito(null, utente2, rivista2, "01/07/2018", "01/08/2018", null);




        ElementoPrestatoDAO dao = new ElementoPrestatoDAO(em);
        UtenteDAO utenteDAO = new UtenteDAO(em);
        PrestitoDAO prestitoDAO = new PrestitoDAO(em);

        em.getTransaction().begin();
        dao.save(libro);
        dao.save(libro2);
        dao.save(rivista);
        dao.save(rivista2);


        utenteDAO.save(utente);
        utenteDAO.save(utente1);
        utenteDAO.save(utente2);


        prestitoDAO.save(prestito);
        prestitoDAO.save(prestito1);
        prestitoDAO.save(prestito2);


        System.out.println("Ricerca per ISBN - libro1:");
        Libro libroTrovato = (Libro) dao.getByISBN(libro.getIsbn());

        System.out.println("Rimozione dell'elemento con ISBN " + libro2.getIsbn());
        dao.deleteByISBN(libro2.getIsbn());

        System.out.println("Ricerca per Anno di Pubblicazione - 1997 (Harry Potter):");
        List<ElementoPrestato> prestitiPerAnno = dao.getByAnnoPubblicazione(1997);
        for (ElementoPrestato p : prestitiPerAnno) {
            System.out.println(p);
        }

        System.out.println("Ricerca per Autore - J.K. Rowling:");
        List<ElementoPrestato> prestitiPerAutore = dao.getByAutore("J.K. Rowling");
        for (ElementoPrestato p : prestitiPerAutore) {
            System.out.println(p);
        }
        System.out.println("Ricerca per Titolo - contiene 'Harry':");
        List<ElementoPrestato> prestitiPerTitolo = dao.getByTitolo("Harry");
        for (ElementoPrestato p : prestitiPerTitolo) {
            System.out.println(p);
        }

        Long numeroDiTessera = 1L;
        List<Prestito> prestitiAttivi = prestitoDAO.getPrestitiAttiviByNumeroDiTessera(String.valueOf(numeroDiTessera));

        System.out.println("Prestiti attivi per numero di tessera " + numeroDiTessera + ":");
        for (Prestito p : prestitiAttivi) {
            System.out.println(p.getElementoPrestato().getTitolo());
        }






        em.getTransaction().commit();

        em.close();
        emf.close();




    }
}
