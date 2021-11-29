package com.example.rabbitrouting;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;


public class EmitLogDirect {
    private static final String NAME_EXCHANGE = "logs_direct";

    public static void main(String[] argv) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        factory.setUsername("guest");
        factory.setPassword("guest");

        try (
            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel()
        ) {
            channel.exchangeDeclare(NAME_EXCHANGE, "direct");
            String binding = "string";
            String message = "Rafael Oliveira Batista";

            channel.basicPublish(NAME_EXCHANGE, binding, null, message.getBytes("UTF-8"));
            System.out.println("Enviando '" + message + "': binding: '" + message + "'");
        }
    }


}
