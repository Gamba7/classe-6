/*Scrivere un programma Java che permetta di creare e gestire
 una biblioteca. La classe Biblioteca dovrà permettere la gestione di un
  archivio di libri.
  Ogni Libro ha un codice (univoco), un titolo, una sinossi e un Autore.

Ogni Autore possiede un codice (univoco), un nome, un cognome e una lista di Libri scritti

Realizzare i metodi della classe Biblioteca che permettano le seguenti azioni:
- inserimento di un Libro
- cancellazione di un Libro
- ricerca di un Libro a partire da codice, titolo o Autore
- stampa di “titolo: sinossi” di tutti i titoli di un determinato Autore, ordinati
in ordine lessicografico ascendente (in base al titolo) usando "\n" come carattere separatore

Suggerimento: Effettuare l’override dei metodi equals, hashcode e toString dove necessario*/

package eserciziClassi_Oggetti;

import java.util.*;

public class Biblioteca2 {

    TreeMap<Autore, TreeSet<Libro>> libreria = new TreeMap<>();

    public void inserimentoLibro (Libro libro){
       if (libreria.containsKey(libro.getAutore())){
           libreria.get(libro.getAutore()).add(libro);
       }
       else {
          TreeSet<Libro> listaLibri = new TreeSet<>();
           listaLibri.add(libro);
           libreria.put(libro.getAutore(), listaLibri);
       }
    }

    public void cancellaLibro (String id){
        for (Autore i: libreria.keySet()) {
            for (Libro l: libreria.get(i)) {
                if (l.getId().toString().equals(id)){
                    libreria.get(i).remove(l);
                    return;
                }
            }
        }
    }

    public Libro ricercaLibro(String titolo){
        for (Autore autore: libreria.keySet()) {
            for (Libro l: libreria.get(autore)) {
                if (l.getTitolo().equals(titolo)) {
                    System.out.println(l.getTitolo() + " " + l.getSinossi());
                    return l;
                }

            }
        }
        return null;
    }

    public void stampaLibriOrdinati () {
        for (Autore autore : libreria.keySet()) {
            for (Libro l : libreria.get(autore)) {
                System.out.println("L'Autore e': " + autore.getNome() + autore.getCognome() + l.getTitolo() + " " + l.getSinossi());
            }
        }
    }
    public static void main(String[] args) {

        Biblioteca2 nuovaBiblioteca = new Biblioteca2();
        Autore Gamba7 = new Autore("Marco", "Gambuti");
        Libro Pascoli = new Libro("Notte stellata", "la notte piena di stelle con accanto me medesimo",Gamba7);
        nuovaBiblioteca.inserimentoLibro(Pascoli);
        nuovaBiblioteca.ricercaLibro("Notte stellata");

        nuovaBiblioteca.stampaLibriOrdinati();

    }
}
