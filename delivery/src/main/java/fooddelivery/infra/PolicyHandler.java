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
    DeliveryRepository deliveryRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @Autowired
    fooddelivery.external.OrderService orderService;

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverCooked_Delivery목록에추가(@Payload Cooked cooked) {
        if (!cooked.validate()) return;
        Cooked event = cooked;
        System.out.println(
            "\n\n##### listener Delivery목록에추가 : " +
            cooked.toJson() +
            "\n\n"
        );

        // REST Request Sample

        // orderService.getOrder(/** mapping value needed */);

        // Sample Logic //
        Delivery.delivery목록에추가(event);
    }
}
