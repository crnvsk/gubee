package PatternMatching;

public class PatternMatchingInstanceof {
    public static void main(String[] args) {
        Object obj = "Olá, mundo!";

        if (obj instanceof String s) { // Verifica e faz o cast automaticamente
            System.out.println("O comprimento da string é: " + s.length());
        } else {
            System.out.println("O objeto não é uma String.");
        }
    }
}
