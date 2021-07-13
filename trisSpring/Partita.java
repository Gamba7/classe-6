/*Implementare un’applicazione Spring che permette di gestire una partita di tris.
Gli endpoint devono permettere le seguenti funzioni
● Iniziare una partita (/new)
● Resettare una partita (/reset/{matchID})
● Fare una mossa (/move/{X/O}/{pos_i}/{pos_j})
● Annullare l’ultima mossa fatta (/back)
Punto bonus
Implementare il concetto di utente/giocatore
Invece di passare X o O nel path dell’endpoint per la mossa, usare gli header per mantenere l’ID
dell’utente che sta facendo la mossa e sapere quindi quale simbolo usare (se X o O)
Punto bonus 2
Permettere all’applicazione di gestire più partite contemporaneamente*/

package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

public class Partita {

    private int riga = 3;
    private int colonna = 3;
    private String[][] tavolaGioco;
    private String idPartita;
    private statoPartita stato;
    private tipoGiocatore giocatore1;
    private tipoGiocatore giocatore2;
    private int ultimaRiga;
    private int ultimaColonna;
    private String idGiocatore1;
    private String idGiocatore2;


    public Partita(String idGiocatore1, String idGiocatore2) {

        setIdGiocatore1(idGiocatore1);
        setIdGiocatore2(idGiocatore2);
        setGiocatore1(tipoGiocatore.X);
        setGiocatore2(tipoGiocatore.O);
        setStato(statoPartita.inCorso);
        setIdPartita(UUID.randomUUID().toString());
        tavolaGioco = new String[riga][colonna];
        for (int i = 0; i < riga; i++) {
            for (int j = 0; j < colonna; j++) {
                tavolaGioco[i][j] = " ";
            }
        }
    }

    public int getRiga() {
        return riga;
    }

    public void setRiga(int riga) {
        this.riga = riga;
    }

    public String[][] getTavolaGioco() {
        return tavolaGioco;
    }

    public void setTavolaGioco(String[][] tavolaGioco) {
        this.tavolaGioco = tavolaGioco;
    }

    public String getIdPartita() {
        return idPartita;
    }

    public void setIdPartita(String idPartita) {
        this.idPartita = idPartita;
    }

    public statoPartita getStato() {
        return stato;
    }

    public void setStato(statoPartita stato) {
        this.stato = stato;
    }

    public tipoGiocatore getGiocatore1() {
        return giocatore1;
    }

    public void setGiocatore1(tipoGiocatore giocatore1) {
        this.giocatore1 = giocatore1;
    }

    public tipoGiocatore getGiocatore2() {
        return giocatore2;
    }

    public void setGiocatore2(tipoGiocatore giocatore2) {
        this.giocatore2 = giocatore2;
    }

    public String getIdGiocatore1() {
        return idGiocatore1;
    }

    public void setIdGiocatore1(String idGiocatore1) {
        this.idGiocatore1 = idGiocatore1;
    }

    public String getIdGiocatore2() {
        return idGiocatore2;
    }

    public void setIdGiocatore2(String idGiocatore2) {
        this.idGiocatore2 = idGiocatore2;
    }

    public void restGriglia() {
        for (int i = 0; i < riga; i++) {
            for (int j = 0; j < colonna; j++) {
                tavolaGioco[i][j] = " ";
            }
        }
    }

    public void inserimentoSimbolo(String idGiocatore, int i, int j){
        tipoGiocatore tipo;
        if (idGiocatore.equals(idGiocatore1)){
            tipo = giocatore1;
        } else if (idGiocatore.equals(idGiocatore2)){
            tipo = giocatore2;
        } else
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "L'utente non fa parte di questa partita");

        if (!tavolaGioco[i][j].equals(" "))
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "La cella è già occupata");

        tavolaGioco[i][j] = tipo.name();
        ultimaRiga = i;
        ultimaColonna = j;
    }

    public void back (){
        tavolaGioco[ultimaRiga][ultimaColonna] = " ";
    }

    public statoPartita controllaVittoria(String idPartita){
        int k = 0;
        int h = 0;
        for (int i = 0; i < riga; i++) {
            for (int j = 0; j < colonna; j++) {
                if (tavolaGioco[i][j].equals(tipoGiocatore.X){
                    k++;
                   if (k==3)
                       return statoPartita.vinto;
                } else {
                    if (tavolaGioco[i][j].equals(tipoGiocatore.O){
                        h++;
                        if (h==3)
                            return statoPartita.vinto;
                    }
                }
            }
             k = 0;
             h = 0;
        }

        for (int i = 0; i < colonna; i++) {
            for (int j = 0; j < riga; j++) {
                if (tavolaGioco[i][j].equals(tipoGiocatore.X){
                    k++;
                    if (k==3)
                        return statoPartita.vinto;
                } else {
                    if (tavolaGioco[i][j].equals(tipoGiocatore.O){
                        h++;
                        if (h==3)
                            return statoPartita.vinto;
                    }
                }
            }
             k = 0;
             h = 0;
        }

        for (int i = 0; i < riga; i++) {
            int j = i;
            if (tavolaGioco[i][j].equals(tipoGiocatore.X)){
                k++;
                if (k==3)
                    return statoPartita.vinto;
            } else {
                if (tavolaGioco[i][j].equals(tipoGiocatore.O)){
                    h++;
                    if (h==3)
                        return statoPartita.vinto;
                     }
                }
            }
                k = 0;
                h = 0;
                int j = 2;
        for (int i = 0; i <riga ; i++) {
            if (tavolaGioco[i][j].equals(tipoGiocatore.X)){
                k++;
                if (k==3)
                    return statoPartita.vinto;
            } else {
                if (tavolaGioco[i][j].equals(tipoGiocatore.O)){
                    h++;
                    if (h==3)
                        return statoPartita.vinto;
                }
            }
        }
        j--;
    }
}

