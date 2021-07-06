/*Realizzare una classe "Tripleton" che può avere fino a 3 istanze in memoria.
Testare il codice e verificare che non possono esistere più di 3 istanze di quella classe*/

public class Tripleton {


    private static Tripleton [] internalInstance = new Tripleton[3];
    private String nome;

    private Tripleton(String nome) {
        this.nome=nome;
    }

    @Override
    public String toString() {
        return "Tripleton{" +
                "nome='" + nome + '\'' +
                '}';
    }
    
    public static Tripleton getInstance(int numero, String nome) {
        if (numero >= 0 && numero <= 2) {
            if (internalInstance[numero] == null) {
                Tripleton nuovo = new Tripleton(nome);
                internalInstance[numero] = nuovo;
            }
            return internalInstance[numero];
        }
        return null;
    }


    public static void main(String[] args) {

        Tripleton marco = getInstance(2, "Marco");
        Tripleton emilio = getInstance(0, "Emilio");
        Tripleton peppe = getInstance(1, "Peppe");
        Tripleton deg = getInstance(2, "Deg");

        System.out.println(marco);
        System.out.println(emilio);
        System.out.println(peppe);
        System.out.println(deg);


    }
}
