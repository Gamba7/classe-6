package com.example.demo;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
public class MyService {

  private int contatore;
  private List<Partita> partite;

    public MyService() {
      partite = new ArrayList<>();
    }

    public void setContatore(int contatore) {
        this.contatore = contatore;
    }

    public int incrementa(){
      return ++contatore;
  }

  public int decrementa(){
      return --contatore;
  }

  public int conteggioAttuale(){
      return contatore;
  }

    public parola conteggioParola(String parola) {
        return new parola(parola.toUpperCase(Locale.ROOT), parola.length());
  }

  public Partita nuovaPartita(){
        Partita p = new Partita("a", "b");
        partite.add(p);
        return p;
  }

  public Partita resetPartita(String idPartita){
    Partita partita = ricercaPartita(idPartita);
    partita.restGriglia();
    return partita;
  }

  public Partita movimento(String idPartita, String idGiocatore, int i, int j){
        Partita partita = ricercaPartita(idPartita);
        partita.inserimentoSimbolo(idGiocatore,i,j);
        return partita;
  }

  public Partita back (String idPartita){
    Partita partita = ricercaPartita(idPartita);
        partita.back();
        return partita;
  }

  public Partita ricercaPartita(String idPartita){
      return   partite.stream().filter(x->x.getIdPartita().equals(idPartita)).findFirst().orElse(null);
  }

  public Partita controlloVittoria(String idPartita){
     Partita partita = controlloVittoria(idPartita);
      partita.controllaVittoria(idPartita);
      return partita;
  }

}