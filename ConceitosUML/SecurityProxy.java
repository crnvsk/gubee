package ConceitosUML;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class SecurityProxy {

    public static UseCaseNotification createProxy(UseCaseNotification target, String userRole) {
        return (UseCaseNotification) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                new Class[] { UseCaseNotification.class },
                new SecurityHandler(target, userRole));
    }

    private static class SecurityHandler implements InvocationHandler {
        private final UseCaseNotification target;
        private final String userRole;

        public SecurityHandler(UseCaseNotification target, String userRole) {
            this.target = target;
            this.userRole = userRole;
        }

        @Override
        public Object invoke(Object proxy, java.lang.reflect.Method method, Object[] args) throws Throwable {
            if (!"admin".equals(userRole)) {
                throw new SecurityException("Access denied: User does not have the required role.");
            }
            System.out.println("Access granted for role: " + userRole);
            return method.invoke(target, args);
        }
    }
}