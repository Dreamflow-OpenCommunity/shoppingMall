package shoppingmall.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import shoppingmall.DeliveryServiceApplication;

@Entity
@Table(name = "Delivery_table")
@Getter
@Setter
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String deliveryStatus;

    private Long orderId;

    @PostPersist
    public void onPostPersist() {}

    public static DeliveryRepository repository() {
        DeliveryRepository deliveryRepository = DeliveryServiceApplication.applicationContext.getBean(
            DeliveryRepository.class
        );
        return deliveryRepository;
    }

    public void deliveryStart() {

        DeliveryStarted deliveryStarted = new DeliveryStarted(this);
        this.setDeliveryStatus("배송 시작");
        deliveryStarted.publishAfterCommit();
    }


    public void deliveryComplete() {
        //implement business logic here:

        DeliveryCompleted deliveryCompleted = new DeliveryCompleted(this);
        this.setDeliveryStatus("배송 완료");
        deliveryCompleted.publishAfterCommit();
    }

    public static void addDeliveryInfo(OrderPlaced orderPlaced) {

        Delivery delivery = new Delivery();
        delivery.setOrderId(orderPlaced.getId());
        repository().save(delivery);

    }
}

