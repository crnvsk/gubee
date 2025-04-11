package ConceitosUML.Transaction;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Define que a anotação pode ser usada em métodos
@Target(ElementType.METHOD)
// Define que a anotação estará disponível em tempo de execução
@Retention(RetentionPolicy.RUNTIME)
public @interface Transaction {
}