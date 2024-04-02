package shoppingmall.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import shoppingmall.ProductServiceApplication;

@Entity
@Table(name = "Product_table")
@Data
//<<< DDD / Aggregate Root
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String productName;

    private Integer stock;

    private String productInfo;

    public static ProductRepository repository() {
        ProductRepository productRepository = ProductServiceApplication.applicationContext.getBean(
            ProductRepository.class
        );
        return productRepository;
    }

    //<<< Clean Arch / Port Method
    public static void decreaseStock(OrderPlaced orderPlaced) {

        repository().findById(orderPlaced.getProductId()).ifPresent(product->{
            
            product.setStock(product.getStock() - orderPlaced.getQuantity());
            repository().save(product);


         });


    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void increaseStock(OrderCanceled orderCanceled) {

        repository().findById(orderCanceled.getProductId()).ifPresent(product->{
            
            product.setStock(product.getStock() + orderCanceled.getQuantity());
            repository().save(product);


         });

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
