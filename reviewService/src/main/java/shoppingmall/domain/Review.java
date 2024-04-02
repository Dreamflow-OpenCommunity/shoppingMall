package shoppingmall.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import shoppingmall.ReviewServiceApplication;

@Entity
@Table(name = "Review_table")
@Data
//<<< DDD / Aggregate Root
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long orderId;

    private Long productId;

    private String reivewContent;

    private Integer score;

    private Long customerId;

    @PostPersist
    public void onPostPersist() {}

    public static ReviewRepository repository() {
        ReviewRepository reviewRepository = ReviewServiceApplication.applicationContext.getBean(
            ReviewRepository.class
        );
        return reviewRepository;
    }

    //<<< Clean Arch / Port Method
    public void reviewCreate(ReviewCreateCommand reviewCreateCommand) {
        //implement business logic here:

        ReviewCreated reviewCreated = new ReviewCreated(this);
        reviewCreated.publishAfterCommit();
    }

    //<<< Clean Arch / Port Method
    public static void addReviewList(OrderConfirmed orderConfirmed) {

        Review review = new Review();
        review.setCustomerId(orderConfirmed.getCustomerId());
        review.setProductId(orderConfirmed.getProductId());
        repository().save(review);

    }

}
//>>> DDD / Aggregate Root
