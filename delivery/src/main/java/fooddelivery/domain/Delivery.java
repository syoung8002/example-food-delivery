package fooddelivery.domain;

import fooddelivery.DeliveryApplication;
import fooddelivery.domain.Delivered;
import fooddelivery.domain.DeliveryStarted;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import org.springframework.beans.BeanUtils;

@Entity
@Table(name = "Delivery_table")
@Data
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String address;

    private Long orderId;

    @PostPersist
    public void onPostPersist() {
        Delivered delivered = new Delivered();
        BeanUtils.copyProperties(this, delivered);
        delivered.publishAfterCommit();

        DeliveryStarted deliveryStarted = new DeliveryStarted();
        BeanUtils.copyProperties(this, deliveryStarted);
        deliveryStarted.publishAfterCommit();
    }

    public static DeliveryRepository repository() {
        DeliveryRepository deliveryRepository = DeliveryApplication.applicationContext.getBean(
            DeliveryRepository.class
        );
        return deliveryRepository;
    }

    public static void delivery목록에추가(Cooked cooked) {
        Delivery delivery = new Delivery();
        /*
        LOGIC GOES HERE
        */
        // repository().save(delivery);

    }
}
