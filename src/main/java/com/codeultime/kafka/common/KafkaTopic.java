package com.codeultime.kafka.common;

public enum KafkaTopic {
    KAFKA_FORMATION("kafka-formation");
private String value;
    KafkaTopic(String s) {
        this.value =s;
    }

    public String getValue() {
        return value;
    }
}
