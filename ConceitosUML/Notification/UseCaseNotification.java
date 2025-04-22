package ConceitosUML.Notification;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public interface UseCaseNotification {
    void notifyEveryHour(String customerId, PresenterNotification presenter);

    @FunctionalInterface
    interface PresenterNotification {
        void notification(String message);
    }

    class PoolingUseCaseNotification implements UseCaseNotification {

        @Override
        @Transaction
        public void notifyEveryHour(String customerId, PresenterNotification presenter) {
            System.out.println("processando regra de negocio");
            presenter.notification(
                    String.format("mensagem a ser enviada para %s: %s", customerId, new Random().nextInt()));
        }
    }

    public static void main(String[] args) {
        ScheduledExecutorService controller = Executors.newSingleThreadScheduledExecutor();

        UseCaseNotificationFactory factory = UseCaseNotificationFactory.getFactory();
        var notificationUseCase = factory.create("admin");

        PresenterNotification emailPresenter = (message) -> System.out.printf("email %s%n", message);
        PresenterNotification whatsAppPresenter = (message) -> System.out.printf("whatApp %s%n", message);
        PresenterNotification smsPresenter = (message) -> System.out.printf("sms %s%n", message);
        PresenterNotification[] notifications = { emailPresenter, whatsAppPresenter, smsPresenter };

        controller.scheduleAtFixedRate(() -> {
            System.out.println("Executando tarefa agendada...");
            var nextPos = Math.abs(new Random().nextInt()) % 3;
            TransactionInterceptor.executeWithTransaction(
                    notificationUseCase,
                    "notifyEveryHour",
                    UUID.randomUUID().toString(),
                    (PresenterNotification) notifications[nextPos]);
            System.out.println("Tarefa concluída.");
        }, 1, 1, TimeUnit.SECONDS);
    }
}
