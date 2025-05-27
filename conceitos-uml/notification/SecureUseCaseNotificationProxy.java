package ConceitosUML.Notification;

public class SecureUseCaseNotificationProxy implements UseCaseNotification {
    private final UseCaseNotification target;
    private final String userRole;

    public SecureUseCaseNotificationProxy(UseCaseNotification target, String userRole) {
        this.target = target;
        this.userRole = userRole;
    }

    @Override
    public void notifyEveryHour(String customerId, PresenterNotification presenter) {
        if (!"admin".equals(userRole)) {
            throw new SecurityException("Acesso negado: Usuario nao possui cargo necessario.");
        }
        System.out.println("Acesso garantido para cargo: " + userRole);
        target.notifyEveryHour(customerId, presenter);
    }
}