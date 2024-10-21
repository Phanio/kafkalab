
# kafkalab

Mise en place d'un client kafka avec Spring

## Pour utiliser ce client
Step 1: Installer le server Apache Kafka (https://kafka.apache.org/downloads)
Step 2: Mettre à jour les paramètres de configuration du serveur kafka dans application.properties:

```
spring.kafka.bootstrap-servers=localhost:9092
spring.kafka.consumer.group-id=GROUP_KAFKALAB_EVENT
spring.kafka.consumer.auto-offset-reset=earliest
spring.kafka.consumer.key-deserializer=org.apache.kafka.common.serialization.StringDeserializer
spring.kafka.consumer.value-deserializer=org.apache.kafka.common.serialization.StringDeserializer
spring.kafka.producer.key-deserializer=org.apache.kafka.common.serialization.StringDeserializer
spring.kafka.producer.value-deserializer=org.apache.kafka.common.serialization.StringDeserializer

```

Topic par defaut: formation-topic
