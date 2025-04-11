package ConceitosUML.Transaction;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TransactionProxy {

    @SuppressWarnings("unchecked")
    public static <T> T createProxy(T target) {
        // Verifica se o target implementa pelo menos uma interface
        if (target.getClass().getInterfaces().length == 0) {
            throw new IllegalArgumentException("O objeto alvo deve implementar pelo menos uma interface.");
        }

        return (T) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new TransactionHandler(target)
        );
    }

    private static class TransactionHandler implements InvocationHandler {
        private final Object target;

        public TransactionHandler(Object target) {
            this.target = target;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            Method targetMethod = target.getClass().getMethod(method.getName(), method.getParameterTypes());

            // Verifica se o método está anotado com @Transaction
            if (targetMethod.isAnnotationPresent(Transaction.class)) {
                String methodName = method.getName();
                String className = target.getClass().getSimpleName();
                System.out.printf("Iniciando execução do método %s.%s%n", className, methodName);

                try {
                    // Executa o método original
                    Object result = method.invoke(target, args);
                    System.out.printf("Finalizando execução do método %s.%s com sucesso%n", className, methodName);
                    return result;
                } catch (Throwable throwable) {
                    System.out.printf("Finalizando execução do método %s.%s com erro: %s%n", className, methodName,
                            throwable.getMessage());
                    throw throwable;
                }
            }

            // Se o método não estiver anotado, executa normalmente
            return method.invoke(target, args);
        }
    }
}