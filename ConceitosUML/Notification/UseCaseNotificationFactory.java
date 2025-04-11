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
            return new SecureUseCaseNotificationProxy(original, userRole);
        }
    }
}