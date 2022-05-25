package fooddelivery.domain;

import fooddelivery.FrontApplication;
import fooddelivery.domain.Paid;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import org.springframework.beans.BeanUtils;

@Entity
@Table(name = "Payment_table")
@Data
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long orderId;

    @PostPersist
    public void onPostPersist() {
        Paid paid = new Paid();
        BeanUtils.copyProperties(this, paid);
        paid.publishAfterCommit();
    }

    public static PaymentRepository repository() {
        PaymentRepository paymentRepository = FrontApplication.applicationContext.getBean(
            PaymentRepository.class
        );
        return paymentRepository;
    }

    public static void cancelPayment(Rejected rejected) {
        Payment payment = new Payment();
        /*
        LOGIC GOES HERE
        */
        // repository().save(payment);

    }

    public static void cancelPayment(OrderCanceled orderCanceled) {
        Payment payment = new Payment();
        /*
        LOGIC GOES HERE
        */
        // repository().save(payment);

    }
}
