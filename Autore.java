package eserciziClassi_Oggetti;

import java.util.HashSet;
import java.util.Objects;
import java.util.UUID;

public class Autore implements Comparable<Autore>{
    private UUID id;
    private String nome;
    private String cognome;
    private HashSet <Libro> libri;

    public Autore( String nome, String cognome) {
        setId(UUID.randomUUID());
        setNome(nome);
        setCognome(cognome);
        setLibri(libri);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public HashSet<Libro> getLibri() {
        return libri;
    }

    public void setLibri(HashSet<Libro> libri) {
        this.libri = libri;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Autore autore = (Autore) o;
        return Objects.equals(id, autore.id) && Objects.equals(nome, autore.nome) && Objects.equals(cognome, autore.cognome) && Objects.equals(libri, autore.libri);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, cognome, libri);
    }

    @Override
    public String toString() {
        return "Autore{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", libri=" + libri +
                '}';
    }

    @Override
    public int compareTo(Autore o) {
        return nome.compareTo(o.nome);
    }
}
