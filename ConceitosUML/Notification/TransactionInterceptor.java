package ConceitosUML.Notification;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import ConceitosUML.Notification.UseCaseNotification.PresenterNotification;

public class TransactionInterceptor {

    public static void executeWithTransaction(Object target, String methodName, Object... args) {
        try {
            Method method = target.getClass().getMethod(methodName, getParameterTypes(args));
            if (method.isAnnotationPresent(Transaction.class)) {
                System.out.printf("Iniciando execução do método %s.%s%n", target.getClass().getSimpleName(), methodName);
                try {
                    method.invoke(target, args);
                    System.out.printf("Finalizando execução do método %s.%s com sucesso%n", target.getClass().getSimpleName(), methodName);
                } catch (InvocationTargetException e) {
                    Throwable cause = e.getCause();
                    System.out.printf("Finalizando execução do método %s.%s com erro: %s%n", target.getClass().getSimpleName(), methodName, cause.getMessage());
                }
            } else {
                method.invoke(target, args);
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro ao executar método com transação: " + e.getMessage(), e);
        }
    }

    private static Class<?>[] getParameterTypes(Object[] args) {
        return args == null ? new Class<?>[0]
                : java.util.Arrays.stream(args)
                        .map(arg -> arg instanceof PresenterNotification ? PresenterNotification.class : arg.getClass())
                        .toArray(Class<?>[]::new);
    }
}