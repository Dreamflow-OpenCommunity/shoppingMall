package shoppingmall.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import shoppingmall.config.kafka.KafkaProcessor;
import shoppingmall.domain.*;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    ReviewRepository reviewRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='OrderConfirmed'"
    )
    public void wheneverOrderConfirmed_AddReviewList(
        @Payload OrderConfirmed orderConfirmed
    ) {
        OrderConfirmed event = orderConfirmed;
        System.out.println(
            "\n\n##### listener AddReviewList : " + orderConfirmed + "\n\n"
        );

        // Sample Logic //
        Review.addReviewList(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
