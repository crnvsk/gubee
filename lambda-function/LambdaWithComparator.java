package LambdaFunction;

import java.util.*;

public class LambdaWithComparator {
    public static void main(String[] args) {
        List<String> lista = Arrays.asList("banana", "maçã", "abacaxi", "uva");

        // Ordenando a lista de frutas
        lista.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));

        System.out.println(lista);
    }
}
