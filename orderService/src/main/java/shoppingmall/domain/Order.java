package shoppingmall.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PostPersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import shoppingmall.OrderServiceApplication;
@Entity
@Table(name = "Order_table")
@Getter
@Setter
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long productId;

    private Long customerId;

    private Integer quantity;

    private String orderStatus;

    private String deliveryStatus;

    @PostPersist
    public void onPostPersist() {
        OrderPlaced orderPlaced = new OrderPlaced(this);
        this.setOrderStatus("주문 완료");
        orderPlaced.publishAfterCommit();
    }

    @PreUpdate
    public void onPreUpdate() {}

    public static OrderRepository repository() {
        OrderRepository orderRepository = OrderServiceApplication.applicationContext.getBean(
            OrderRepository.class
        );
        return orderRepository;
    }


    public void orderCancel() {

        OrderCanceled orderCanceled = new OrderCanceled(this);
        this.setOrderStatus("주문 취소");
        orderCanceled.publishAfterCommit();
    }

    public void orderConfirm() {

        OrderConfirmed orderConfirmed = new OrderConfirmed(this);
        this.setOrderStatus("구매 확정");
        orderConfirmed.publishAfterCommit();
    }


    public static void updateDeliveryInfo(DeliveryStarted deliveryStarted) {

        repository().findById(deliveryStarted.getOrderId()).ifPresent(order->{
            
            order.setDeliveryStatus("배송 시작");
            repository().save(order);

         });
    }


    public static void updateDeliveryInfo(DeliveryCompleted deliveryCompleted) {

        repository().findById(deliveryCompleted.getOrderId()).ifPresent(order->{

            order.setDeliveryStatus("배송 시작");
            repository().save(order);

        });

    }

}

