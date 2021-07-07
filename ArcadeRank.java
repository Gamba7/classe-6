/*Esercizio Arcade Rank 🏍

Scrivere un programma per gestire le classifiche di una sala-giochi. In particolare, è necessario gestire
sia la classifica "locale" di ogni videogioco presente, che quella "globale".
Ogni videogioco ha un id univoco, un nome e un coefficiente di difficoltà  (da 1 a 5)
Il piazzamento di un utente nella classifica globale è dato dalla somma del suo piazzamento in ciascun
videogioco moltiplicato per il coefficiente di difficoltà del videogioco. Se l'utente non ha giocato ad un
videogioco x, il suo punteggio per x è 0.
Ogni utente ha un id univoco e uno username, usato per le classifiche.

Implementare le seguenti operazioni:
- inserisci utente: crea un utente
- inserisci videogioco: crea e inserisce un videogioco nel sistema
- inserisci partita: dato l'id di un utente, l'id di un videogioco e un punteggio, aggiorna la classifica
- classifica di un videogioco: dato un id, restituisce la classifica (top 3) del videogioco con quell'id in formato
username:punteggio dei primi
- ultime N partite: restituisce le ultime N partite
PLUS  🏍 🏍 - classifica globale: restituisce la classifica globale (top 3) della sala-giochi

Potete assumere che la scala del punteggio sia uniforme per tutti i videogiochi */

import java.util.*;
import java.util.stream.Collectors;

public class ArcadeRank {

    private Map<String,Utente> usersmap = new HashMap<>();
    private Map<String,Videogioco> gamesmap= new HashMap<>();
    private List<Partita> listapartite = new ArrayList<>();

    public void InserisciUtente (Utente utente)
    {
        usersmap.put(utente.getID(), utente);
    }

    public void InserisciVideogioco(Videogioco gioco)
    {
        gamesmap.put(gioco.getID(),gioco);
    }

    public void InserisciPartita(String IDUtente, String IDGioco, int punteggio)
    {
        Partita nuova = new Partita(IDUtente,IDGioco,punteggio);
        listapartite.add(nuova);
        Utente user = usersmap.get(IDUtente);
        Videogioco gioco = gamesmap.get(IDGioco);
        if (gioco.getPunteggi().get(user)!= null && gioco.getPunteggi().get(user)>punteggio) return;
        gioco.getPunteggi().put(user,punteggio);
    }
    public Map<Utente,Integer> Top3Locale (String IDGioco)
    {
        return gamesmap.get(IDGioco).getPunteggi().entrySet().stream().sorted((a,b)-> -a.getValue().compareTo(b.getValue())).
                limit(3).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,(a,b)->a,LinkedHashMap::new));
    }
    public List<Partita> ultimeNpartite (int n)
    {
        if (listapartite.size()>n)  return listapartite.subList(listapartite.size()-n,listapartite.size());
        return listapartite;
    }

    public Map<Utente, Integer> ClassificaGlobale()
    {
        Map<Utente,Integer> nuova = new HashMap<>();
        gamesmap.values().stream().forEach(x->x.getPunteggi().entrySet().stream().forEach(y->nuova.put(y.getKey(),Optional.ofNullable(nuova.get(y.getKey())).orElse(0)+y.getValue()*x.getdifficolta())));
        return nuova.entrySet().stream().sorted((a,b)->-a.getValue().compareTo(b.getValue())).limit(3).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,(a,b)->a,LinkedHashMap::new));
    }
    private Integer nullornot(Integer x)
    {
        if (x==null) return 0;
        else return x;
    }

    public static void main(String[] args) {
        Utente Marco = new Utente("MarcoV");
        Utente Peppe = new Utente("Peppino");
        Utente Gamba = new Utente("Gamba7");
        Utente Melvin = new Utente("Melvin");
        Utente io = new Utente("BipedBoat");
        Videogioco Destiny = new Videogioco("Destiny",3);
        Videogioco MarioBros = new Videogioco("SuperMario",2);
        Videogioco SpaceInveders = new Videogioco("SpaceInvaders",2);
        Videogioco Warzone = new Videogioco("Warzone",5);
        Videogioco Fifa = new Videogioco("Fifa",1);
        ArcadeRank rank = new ArcadeRank();
        rank.InserisciUtente(Marco);
        rank.InserisciUtente(Peppe);
        rank.InserisciUtente(Gamba);
        rank.InserisciUtente(Melvin);
        rank.InserisciUtente(io);
        rank.InserisciVideogioco(Destiny);
        rank.InserisciVideogioco(MarioBros);
        rank.InserisciVideogioco(SpaceInveders);
        rank.InserisciVideogioco(Warzone);
        rank.InserisciVideogioco(Fifa);
        rank.InserisciPartita(Gamba.getID(),Destiny.getID(),600);
        rank.InserisciPartita(Gamba.getID(),MarioBros.getID(),50);
        rank.InserisciPartita(Gamba.getID(),SpaceInveders.getID(),1200);
        rank.InserisciPartita(Gamba.getID(),Warzone.getID(),2);
        rank.InserisciPartita(Gamba.getID(),Fifa.getID(),150);
        rank.InserisciPartita(Marco.getID(),Destiny.getID(),300);
        rank.InserisciPartita(Marco.getID(),MarioBros.getID(),25);
        rank.InserisciPartita(Marco.getID(),SpaceInveders.getID(),600);
        rank.InserisciPartita(Marco.getID(),Warzone.getID(),1);
        rank.InserisciPartita(Marco.getID(),Fifa.getID(),75);
        rank.InserisciPartita(Peppe.getID(),Destiny.getID(),1800);
        rank.InserisciPartita(Peppe.getID(),MarioBros.getID(),100);
        rank.InserisciPartita(Peppe.getID(),SpaceInveders.getID(),850);
        rank.InserisciPartita(Peppe.getID(),Warzone.getID(),66);
        rank.InserisciPartita(Peppe.getID(),Fifa.getID(),20);
        rank.InserisciPartita(Melvin.getID(),Destiny.getID(),10);
        rank.InserisciPartita(Melvin.getID(),MarioBros.getID(),50);
        rank.InserisciPartita(Melvin.getID(),SpaceInveders.getID(),2000);
        rank.InserisciPartita(Melvin.getID(),Warzone.getID(),50);
        rank.InserisciPartita(Melvin.getID(),Fifa.getID(),200);
        rank.InserisciPartita(io.getID(),Destiny.getID(),100);
        rank.InserisciPartita(io.getID(),MarioBros.getID(),500);
        rank.InserisciPartita(io.getID(),SpaceInveders.getID(),1000);
        rank.InserisciPartita(io.getID(),Warzone.getID(),1000);
        rank.InserisciPartita(io.getID(),Fifa.getID(),2500);


        System.out.println(rank.ClassificaGlobale());




    }



}
