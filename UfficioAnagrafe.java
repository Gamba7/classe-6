import java.util.*;
import java.util.stream.Collectors;

/*Scrivere un programma che permetta di gestire un ufficio dell'anagrafe. In particolare, bisogna
gestire una lista di persone, ognuna con nome, cognome, età, codice fiscale e indirizzo di residenza.
Inoltre, devono essere possibili le seguenti operazioni:

- inserisci persona: inserisce la persona nel sistema
- rimuovi persona da codice fiscale: rimuove una persona con il corrispondente codice fiscale dal sistema
- ottieni persone per nome: dato un nome, ritorna le persone che hanno un nome che corrisponde
 o inizia con quello in input
- ottieni le 3 persone più anziane: ritorna le 3 persone più anziane presenti nel sistema
- ottieni indirizzi per nome: dato un nome, ritorna l'indirizzo di tutte le persone con nome
corrispondente a quello in input

PLUS 🏍: gestire, per ogni persona, la lista dei figli ed implementare un metodo getFigli(nome)
 che ritorna la lista di persone il cui genitore ha il nome che corrisponde o inizia con quello in input
 Esempio:

 ```
 andrea rossi -> [cristina, giorgio]
 andrea bianchi -> [mario]
 getFigli("andrea") -> [cristina, giorgio, mario]*/

public class UfficioAnagrafe {
    Set<Persona> listaPersone = new HashSet<>();


    public void inserisciPersona(Persona p) {
        listaPersone.add(p);
    }

    public void rimuoviPersona(String codiceFiscale) {
        for (Persona p : listaPersone) {
            if (p.getCodiceFiscale().equals(codiceFiscale)) {
                listaPersone.remove(p);
            }
        }
    }

    public Set<Persona> ritornaPerNome(String nome) {
        return listaPersone.stream().filter(x -> x.getNome().startsWith(nome)).collect(Collectors.toSet());
    }

    public Set<Persona> ottieniVecchi(int eta) {
        return listaPersone.stream().sorted(Comparator.comparing(Persona::getEta).reversed()).limit(3).collect(Collectors.toSet());
    }

    public Set<String> ottieniIndirizzo (String nome){
        Set<String> indirizzi = new HashSet<>();
        for (Persona p : listaPersone) {
            if (p.getNome().equals(nome)){
                indirizzi.add(p.getIndirizzo());
            }

        }
        return indirizzi;

    }

    public Set<String> getFigli(String nome){
        Set<String> figli = new HashSet<>();
        for (Persona p : listaPersone) {
            if (p.getNome().equals(nome)){
                figli.addAll(p.getFigli());
            }
        }

        return figli;
    }

    public static void main(String[] args) {
        Set<String> figliMarco = new HashSet<>();
        Set<String> figliMarco2 = new HashSet<>();
        figliMarco.add("Kevin");
        figliMarco.add("Giulia");
        figliMarco2.add("Giacomo");

        Persona marco = new Persona("Marco","Gambuti",30,"GMBMRC90R18H294Y","Via lazio 700",figliMarco);
        Persona marco2 = new Persona("Marco","Martinesi",28,"SLFKN96SLDJN89LSDJN897L","Via Martin 12", figliMarco2);

        Set<Persona> listaPersone = new HashSet<>();
        listaPersone.add(marco);
        listaPersone.add(marco2);

        UfficioAnagrafe ufficioAnagrafe = new UfficioAnagrafe();
        ufficioAnagrafe.inserisciPersona(marco);
        ufficioAnagrafe.inserisciPersona(marco2);
        ufficioAnagrafe.ottieniIndirizzo("Mario");
        ufficioAnagrafe.ottieniVecchi(30);
        ufficioAnagrafe.ritornaPerNome("Martina");
        ufficioAnagrafe.getFigli("Marco");

        System.out.println(ufficioAnagrafe.getFigli("Marco"));

    }

}




