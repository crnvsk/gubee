package ConceitosUML;

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
            throw new SecurityException("Access denied: User does not have the required role.");
        }
        System.out.println("Access granted for role: " + userRole);
        target.notifyEveryHour(customerId, presenter);
    }
}