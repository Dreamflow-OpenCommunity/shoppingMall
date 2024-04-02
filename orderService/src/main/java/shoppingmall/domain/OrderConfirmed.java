package shoppingmall.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import shoppingmall.domain.*;
import shoppingmall.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class OrderConfirmed extends AbstractEvent {

    private Long id;
    private Long productId;
    private Long customerId;
    private Integer quantity;
    private String orderStatus;
    private String deliveryStatus;

    public OrderConfirmed(Order aggregate) {
        super(aggregate);
    }

    public OrderConfirmed() {
        super();
    }
}
//>>> DDD / Domain Event
