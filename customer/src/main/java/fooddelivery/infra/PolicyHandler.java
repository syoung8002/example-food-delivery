package fooddelivery.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import fooddelivery.config.kafka.KafkaProcessor;
import fooddelivery.domain.*;
import javax.naming.NameParser;
import javax.naming.NameParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class PolicyHandler {

    @Autowired
    NotificationLogRepository notificationLogRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverAccepted_카카오톡알림(@Payload Accepted accepted) {
        if (!accepted.validate()) return;
        Accepted event = accepted;
        System.out.println(
            "\n\n##### listener 카카오톡알림 : " + accepted.toJson() + "\n\n"
        );

        // Sample Logic //
        NotificationLog.카카오톡알림(event);
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverRejected_카카오톡알림(@Payload Rejected rejected) {
        if (!rejected.validate()) return;
        Rejected event = rejected;
        System.out.println(
            "\n\n##### listener 카카오톡알림 : " + rejected.toJson() + "\n\n"
        );

        // Sample Logic //
        NotificationLog.카카오톡알림(event);
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverCooked_카카오톡알림(@Payload Cooked cooked) {
        if (!cooked.validate()) return;
        Cooked event = cooked;
        System.out.println(
            "\n\n##### listener 카카오톡알림 : " + cooked.toJson() + "\n\n"
        );

        // Sample Logic //
        NotificationLog.카카오톡알림(event);
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverPaid_카카오톡알림(@Payload Paid paid) {
        if (!paid.validate()) return;
        Paid event = paid;
        System.out.println(
            "\n\n##### listener 카카오톡알림 : " + paid.toJson() + "\n\n"
        );

        // Sample Logic //
        NotificationLog.카카오톡알림(event);
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverOrderPlaced_카카오톡알림(
        @Payload OrderPlaced orderPlaced
    ) {
        if (!orderPlaced.validate()) return;
        OrderPlaced event = orderPlaced;
        System.out.println(
            "\n\n##### listener 카카오톡알림 : " + orderPlaced.toJson() + "\n\n"
        );

        // Sample Logic //
        NotificationLog.카카오톡알림(event);
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverDeliveryStarted_카카오톡알림(
        @Payload DeliveryStarted deliveryStarted
    ) {
        if (!deliveryStarted.validate()) return;
        DeliveryStarted event = deliveryStarted;
        System.out.println(
            "\n\n##### listener 카카오톡알림 : " +
            deliveryStarted.toJson() +
            "\n\n"
        );

        // Sample Logic //
        NotificationLog.카카오톡알림(event);
    }
}
