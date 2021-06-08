/*Scrivere un programma che permetta di gestire una Biblioteca semplificata, in grado di gestire un array di indici (interi) dei libri
che contiene. La Biblioteca viene costruita a partire da un array di indici di libri.
In particolare, implementare i seguenti metodi:
- esisteLibro: prende un indice e restituisce true se esiste il libro con questo indice, false altrimenti
- getIndiciLibriOrdinati: ritorna la lista degli indici di libri presenti nella library, in ordine ascendente*/
package eserciziClassi_Oggetti;
import java.util.Arrays;

import static java.util.Arrays.*;

public class Biblioteca {
    private int [] array;


    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }


    public Biblioteca(int [] array) {
       this.array=array;
    }

    public boolean esisteLibro (int a){

        for (int i =0; i<array.length;i++){
            if (array[i]==a){
               return true;
            }
        }
        return false;
    }

    public int [] getIndiciLibriOrdinati (){

         Arrays.sort(array);
         return array;
    }


    public static void main(String[] args) {


            int[] values = new int[7];
            values[0] = 123;
            values[1] = 4;
            values[2] = 98;
            values[3] = 33;
            values[4] = 76;
            values[5] = 2;
            values[6] = 235;
            Biblioteca library = new Biblioteca(values);
            System.out.println(library.esisteLibro(76));
            int[] libriOrdinati = library.getIndiciLibriOrdinati();
            System.out.println(libriOrdinati[0] == 2);
            System.out.println(libriOrdinati[1] == 4);
            System.out.println(libriOrdinati[2] == 33);
            System.out.println(libriOrdinati[3] == 76);
            System.out.println(libriOrdinati[4] == 98);
            System.out.println(libriOrdinati[5] == 123);
            System.out.println(libriOrdinati[6] == 235);
        }

}
