package shoppingmall.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import lombok.Data;
import shoppingmall.UserServiceApplication;

import javax.persistence.*;

@Entity
@Table(name = "User_table")
@Data
//<<< DDD / Aggregate Root
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String email;

    private String name;

    private String address;

    public static UserRepository repository() {
        UserRepository userRepository = UserServiceApplication.applicationContext.getBean(
            UserRepository.class
        );
        return userRepository;
    }
}
//>>> DDD / Aggregate Root
