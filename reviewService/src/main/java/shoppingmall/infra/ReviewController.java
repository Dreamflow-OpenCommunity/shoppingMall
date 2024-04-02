package shoppingmall.infra;

import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shoppingmall.domain.*;

//<<< Clean Arch / Inbound Adaptor

@RestController
// @RequestMapping(value="/reviews")
@Transactional
public class ReviewController {

    @Autowired
    ReviewRepository reviewRepository;

    @RequestMapping(
        value = "reviews/{id}/create",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Review reviewCreate(
        @PathVariable(value = "id") Long id,
        @RequestBody ReviewCreateCommand reviewCreateCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /review/reviewCreate  called #####");
        Optional<Review> optionalReview = reviewRepository.findById(id);

        optionalReview.orElseThrow(() -> new Exception("No Entity Found"));
        Review review = optionalReview.get();
        review.reviewCreate(reviewCreateCommand);

        reviewRepository.save(review);
        return review;
    }
}
//>>> Clean Arch / Inbound Adaptor
