import java.util.Arrays;
import java.util.List;

public class FiltersWithLambda {
    public static void main(String[] args) {
        List<String> nomes = Arrays.asList("Ana", "Bruno", "Carlos", "Daniel");

        // Filtrando nomes que começam com "B" e imprimindo-os
        nomes.stream()
             .filter(nome -> nome.startsWith("B"))
             .forEach(System.out::println);
    }
}


