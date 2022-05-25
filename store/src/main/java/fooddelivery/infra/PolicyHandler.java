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
    StoreOrderRepository storeOrderRepository;

    @Autowired
    MenuRepository menuRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverPaid_주문목록에추가(@Payload Paid paid) {
        if (!paid.validate()) return;
        Paid event = paid;
        System.out.println(
            "\n\n##### listener 주문목록에추가 : " + paid.toJson() + "\n\n"
        );

        // Sample Logic //
        StoreOrder.주문목록에추가(event);
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverOrderCanceled_주문취소알림(
        @Payload OrderCanceled orderCanceled
    ) {
        if (!orderCanceled.validate()) return;
        OrderCanceled event = orderCanceled;
        System.out.println(
            "\n\n##### listener 주문취소알림 : " +
            orderCanceled.toJson() +
            "\n\n"
        );

        // Sample Logic //
        StoreOrder.주문취소알림(event);
    }
}
