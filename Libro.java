package eserciziClassi_Oggetti;

import java.util.Objects;
import java.util.UUID;

public class Libro implements Comparable<Libro>{
    private UUID id;
    private String titolo;
    private String sinossi;
    private Autore autore;

    public Libro( String titolo, String sinossi, Autore autore) {
        setId(UUID.randomUUID());
        setTitolo(titolo);
        setSinossi(sinossi);
        setAutore(autore);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getSinossi() {
        return sinossi;
    }

    public void setSinossi(String sinossi) {
        this.sinossi = sinossi;
    }

    public Autore getAutore() {
        return autore;
    }

    public void setAutore(Autore autore) {
        this.autore = autore;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Libro libro = (Libro) o;
        return Objects.equals(id, libro.id) && Objects.equals(titolo, libro.titolo) && Objects.equals(sinossi, libro.sinossi) && Objects.equals(autore, libro.autore);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, titolo, sinossi, autore);
    }

    @Override
    public String toString() {
        return "Libro{" +
                "id=" + id +
                ", titolo='" + titolo + '\'' +
                ", sinossi='" + sinossi + '\'' +
                ", autore='" + autore + '\'' +
                '}';
    }

    @Override
    public int compareTo(Libro o) {
        return titolo.compareTo(o.titolo);
    }
}
