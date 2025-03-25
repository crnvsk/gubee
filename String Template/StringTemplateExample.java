import static java.lang.StringTemplate.STR;

public class StringTemplateExample {
    public static void main(String[] args) {
        String nome = "Carlos";
        int idade = 25;

        // Uso de String Template (preview feature)
        String mensagem = STR."Olá, meu nome é \{nome} e eu tenho \{idade} anos.";

        System.out.println(mensagem); // Saída: Olá, meu nome é Carlos e eu tenho 25 anos.
    }
}
