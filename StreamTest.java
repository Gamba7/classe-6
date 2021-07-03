/*Scrivere un programma Java che restituisca, a partire da una lista di nomi, la somma totale
delle lettere contenute in ogni nome che inizia con la lettera "f"

Suggerimento: realizzatelo prima senza Stream, poi con Stream*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.IntStream;

public class StreamTest {

    public static void main(String[] args) {
        List<String> listaNomi = Arrays.asList("Marco", "Peppe", "Deg", "Gamba", "Ferdinando");
        int sommaTotale = listaNomi.stream().filter(x->x.toUpperCase(Locale.ROOT).startsWith("F")).mapToInt(String::length).sum();
        System.out.println(sommaTotale);

    }



}
