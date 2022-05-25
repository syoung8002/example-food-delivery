package fooddelivery.domain;

import fooddelivery.FrontApplication;
import fooddelivery.domain.OrderCanceled;
import fooddelivery.domain.OrderPlaced;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import org.springframework.beans.BeanUtils;

@Entity
@Table(name = "Order_table")
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String foodId;

    private String customerId;

    private String preference;

    private String options;

    private Address address;

    private String status;

    @PostPersist
    public void onPostPersist() {
        OrderPlaced orderPlaced = new OrderPlaced();
        BeanUtils.copyProperties(this, orderPlaced);
        orderPlaced.publishAfterCommit();

        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.

        fooddelivery.external.Payment payment = new fooddelivery.external.Payment();
        // mappings goes here
        FrontApplication.applicationContext
            .getBean(fooddelivery.external.PaymentService.class)
            .pay(payment);
    }

    @PostRemove
    public void onPostRemove() {
        OrderCanceled orderCanceled = new OrderCanceled();
        BeanUtils.copyProperties(this, orderCanceled);
        orderCanceled.publishAfterCommit();
    }

    @PrePersist
    public void onPrePersist() {}

    @PreRemove
    public void onPreRemove() {}

    public static OrderRepository repository() {
        OrderRepository orderRepository = FrontApplication.applicationContext.getBean(
            OrderRepository.class
        );
        return orderRepository;
    }

    public static void updateStatus(Accepted accepted) {
        Order order = new Order();
        /*
        LOGIC GOES HERE
        */
        // repository().save(order);

    }

    public static void updateStatus(Rejected rejected) {
        Order order = new Order();
        /*
        LOGIC GOES HERE
        */
        // repository().save(order);

    }
}
