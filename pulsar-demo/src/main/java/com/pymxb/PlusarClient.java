package com.pymxb;

import org.apache.pulsar.client.api.*;

import java.util.concurrent.CompletableFuture;

public class PlusarClient {
    public static void main(String[] args) {
        try {
            PulsarClient client = PulsarClient.builder()
                   // .serviceUrl("pulsar://192.168.1.52:6650").build();
                    .serviceUrl("pulsar://192.168.1.52:6650,192.168.1.53:6650,192.168.1.54:6650").build();
            System.out.println(client);

            Producer<byte[]> producer = client.newProducer()

                    .topic("pulsar_test1")
                    .create();
            System.out.println(producer);
            CompletableFuture<MessageId> future = producer.newMessage()
                    .key("pulsar_test1")
                    .value("hello pulsar message".getBytes()).sendAsync();

            future.handle((v, ex) -> {
                if (ex == null) {
                    System.out.println("Message persisted, MessageId:{}, data:{}"+ v + "hello pulsar message");
                } else {
                    System.out.println("发送消息失败msg:{} hello pulsar message:"+  ex);
                }
                return null;
            });
        } catch (PulsarClientException e) {
            e.printStackTrace();
        }
    }
}
