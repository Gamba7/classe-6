/*Esercizio Supermercato versione 2 🛴

Scrivere un programma Java che permetta di gestire la coda di un supermercato.
In particolare, deve essere possibile eseguire le seguenti operazioni:

- inserimento in coda di un cliente
- rimozione dalla coda di un cliente
- ottenere prossimo cliente da servire
- ottenere il numero di clienti attualmente in coda

Ogni cliente ha nome, cognome, età e un id univoco.
La coda, ovviamente, va gestita secondo la politica FIFO.

PLUS 🏍 : Modificare la coda per favorire le persone più anziane

Suggerimento: scegliete bene la struttura dati (una possibile soluzione potrebbe
essere la PriorityQueue, che è un tipo di coda fornito da Java ad esempio...)*/
package eserciziClassi_Oggetti;

import java.util.PriorityQueue;

public class Supermercato {

    PriorityQueue<Cliente> listaClienti=new PriorityQueue<>();

    public void inseirmentoCliente (Cliente cliente){

            listaClienti.add(cliente);
    }

    public void rimozioneCliente (Cliente cliente){
        listaClienti.remove(cliente);
    }

    public Cliente ottenereProssimoCliente (){
        return listaClienti.poll(); //restituisce il primo elemento della coda e lo elimina
    }

    public int clientiInCoda(){
        return listaClienti.size();
    }

}

