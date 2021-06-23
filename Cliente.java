package eserciziClassi_Oggetti;

import java.util.Objects;

public class Cliente implements Comparable<Cliente>{
    private String nome;
    private String cognome;
    private int eta;
    private String id;

    public Cliente(String nome, String cognome, int eta, String id) {
        setNome(nome);
        setCognome(cognome);
        setEta(eta);
        setId(id);
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

    public int getEta() {
        return eta;
    }

    public void setEta(int eta) {
        this.eta = eta;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return eta == cliente.eta && Objects.equals(nome, cliente.nome) && Objects.equals(cognome, cliente.cognome) && Objects.equals(id, cliente.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, cognome, eta, id); //era da fare solo con l'id xche è UNIVOCO!!!!
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", eta=" + eta +
                ", id='" + id + '\'' +
                '}';
    }


    @Override
    public int compareTo(Cliente o) {
        if (this.getEta() > o.getEta()) {
            return -1;
        } else if (this.getEta() < o.getEta()) {
            return 1;
        }
            return this.getId().compareTo(o.getId());
    }
}
