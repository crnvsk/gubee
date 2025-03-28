package PatternMatching;

public class PatternMatchingSwitch {
    public static void main(String[] args) {
        Object obj = 42;

        String resultado = switch (obj) {
            case String s -> "É uma String com " + s.length() + " caracteres";
            case Integer i -> "É um Integer com valor " + i;
            case Double d -> "É um Double com valor " + d;
            case null -> "O valor é null";
            default -> "Tipo desconhecido";
        };

        System.out.println(resultado);
    }
}
