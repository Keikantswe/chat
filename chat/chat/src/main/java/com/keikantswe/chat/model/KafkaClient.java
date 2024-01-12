//package com.keikantswe.chat.model;
//
//import org.apache.kafka.clients.consumer.ConsumerConfig;
//import org.apache.kafka.clients.consumer.KafkaConsumer;
//import org.apache.kafka.clients.producer.KafkaProducer;
//import org.apache.kafka.clients.producer.ProducerConfig;
//import org.apache.kafka.clients.producer.ProducerRecord;
//import org.apache.kafka.common.serialization.StringDeserializer;
//import org.apache.kafka.common.serialization.StringSerializer;
//
//import java.util.Arrays;
//import java.util.Properties;
//
//import static java.lang.System.getProperty;
//
//public class KafkaClient {
//
//    private static final String BOOSTRAP_SEVERS  = getProperty("server", "localhost:9092");
//    private static final String TOPIC = getProperty("topic" , "Chat");
//    private static final String GROUP_ID = getProperty("user" , "my-group");
//
//    private static KafkaClient INSTANCE = null;
//
//    private final KafkaConsumer<String, String> consumer;
//    private final KafkaProducer<String , String> producer;
//
//    //
//    public KafkaClient() {
//        Properties properties = new Properties();
//        properties.put("boostrap.servers" , BOOSTRAP_SEVERS);
//        properties.put("group_id", GROUP_ID);
//        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
//        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
//        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
//        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
//
//        consumer = new KafkaConsumer<>(properties);
//        consumer.subscribe(Arrays.asList(TOPIC));
//
//        producer = new KafkaProducer<>(properties);
//    }
//
//    //Methods for sending message
//    public void sendMessage(String message){
//        ProducerRecord<String, String > producerRecord = new ProducerRecord<>(TOPIC, GROUP_ID, message);
//        producer.send(producerRecord);
//        producer.flush();
//    }
//    static  KafkaClient getInstance(){
//        if(INSTANCE== null){
//                INSTANCE = new KafkaClient();
//        }
//        return  INSTANCE;
//    }
//
//}
