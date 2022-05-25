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
    PreferenceRepository preferenceRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverOrderPlaced_주문내역수집(
        @Payload OrderPlaced orderPlaced
    ) {
        if (!orderPlaced.validate()) return;
        OrderPlaced event = orderPlaced;
        System.out.println(
            "\n\n##### listener 주문내역수집 : " + orderPlaced.toJson() + "\n\n"
        );

        // Sample Logic //
        Preference.주문내역수집(event);
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenever오후_12시_추천(@Payload 오후_12시 오후_12시) {
        if (!오후_12시.validate()) return;
        오후_12시 event = 오후_12시;
        System.out.println(
            "\n\n##### listener 추천 : " + 오후_12시.toJson() + "\n\n"
        );

        // Sample Logic //
        Preference.추천(event);
    }
}
