import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main{

    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        String w = "";
        int n = 0;

        // faccio scegliere all'utente la parola e il numero di anagrammi
        System.out.println("Inserisci una parola: ");
        w = scanner.next();
        System.out.println("Inserisci il numero di anagrammi che vuoi trovare di " + w + ":");
        n = scanner.nextInt();

        List<String> anagrammi = generaAnagrammi(w, n);
        
        System.out.println("Anagrammi di " + w + ":");
        for (String anagramma : anagrammi) {
            System.out.println(anagramma);
        }
    }
    
    public static List<String> generaAnagrammi(String w, int n){
        List<String> anagrammi = new ArrayList<>();
        generaAnagrammiRicorsivo("", w, anagrammi);
        
        // se ci sono più anagrammi richiesti, li mescoliamo casualmente
        Collections.shuffle(anagrammi);
        
        // ritorna solo i primi 'numeroAnagrammi' anagrammi
        return anagrammi.subList(0, Math.min(n, anagrammi.size()));
    }

    private static void generaAnagrammiRicorsivo(String prefisso, String suffisso, List<String> risultato) {
        int lunghezza = suffisso.length();
        if (lunghezza == 0) {
            risultato.add(prefisso);
        } else {
            for (int i = 0; i < lunghezza; i++) {
                generaAnagrammiRicorsivo(prefisso + suffisso.charAt(i),
                                          suffisso.substring(0, i) + suffisso.substring(i+1, lunghezza),
                                          risultato);
            }
        }
    }

}