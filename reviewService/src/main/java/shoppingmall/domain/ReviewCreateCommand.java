package shoppingmall.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class ReviewCreateCommand {

    private String reviewContent;
}
