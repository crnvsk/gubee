package com.exemplo.jms;

import javax.jms.*;
import org.apache.activemq.ActiveMQConnectionFactory;

public class Consumidor {
    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = new ActiveMQConnectionFactory("tcp://localhost:61616");
        Connection connection = factory.createConnection();
        connection.start();

        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Destination fila = session.createQueue("FILA.TESTE");
        MessageConsumer consumidor = session.createConsumer(fila);

        consumidor.setMessageListener(new MessageListener() {
            public void onMessage(Message mensagem) {
                if (mensagem instanceof TextMessage) {
                    try {
                        System.out.println("Recebido: " + ((TextMessage) mensagem).getText());
                    } catch (JMSException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("Mensagem recebida não é texto.");
                }
            }
        });

        System.out.println("Consumidor aguardando mensagens. Pressione Enter para sair...");
        System.in.read();

        session.close();
        connection.close();
    }
}