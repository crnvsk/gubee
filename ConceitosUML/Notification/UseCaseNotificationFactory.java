package ConceitosUML.Notification;

public abstract class UseCaseNotificationFactory {
    public abstract UseCaseNotification create(String userRole);

    public static UseCaseNotificationFactory getFactory() {
        return new SecureUseCaseNotificationFactory();
    }

    private static class SecureUseCaseNotificationFactory extends UseCaseNotificationFactory {
        @Override
        public UseCaseNotification create(String userRole) {
            UseCaseNotification original = new UseCaseNotification.PoolingUseCaseNotification();

            // Alternância entre Proxy via OO e Proxy dinâmico
            boolean useDynamicProxy = false;
            if (useDynamicProxy) {
                return SecurityProxy.createProxy(original, userRole); // Proxy dinâmico
            } else {
                return new SecureUseCaseNotificationProxy(original, userRole); // Proxy via OO
            }
        }
    }
}