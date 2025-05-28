package com.exemplo.jms;

import javax.jms.*;
import org.apache.activemq.ActiveMQConnectionFactory;

public class Produtor {
    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = new ActiveMQConnectionFactory("tcp://localhost:61616");
        Connection connection = factory.createConnection();
        connection.start();

        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Destination fila = session.createQueue("FILA.TESTE");
        MessageProducer produtor = session.createProducer(fila);

        TextMessage mensagem = session.createTextMessage("Ola, JMS!");
        produtor.send(mensagem);

        System.out.println("Mensagem enviada!");

        session.close();
        connection.close();
    }
}
