package shoppingmall.domain;

import java.util.*;
import lombok.*;
import shoppingmall.domain.*;
import shoppingmall.infra.AbstractEvent;

@Data
@ToString
public class OrderConfirmed extends AbstractEvent {

    private Long id;
    private Long productId;
    private Long customerId;
    private Integer quantity;
    private String orderStatus;
    private String deliveryStatus;
}
