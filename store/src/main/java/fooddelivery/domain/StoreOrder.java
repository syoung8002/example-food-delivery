package fooddelivery.domain;

import fooddelivery.StoreApplication;
import fooddelivery.domain.Accepted;
import fooddelivery.domain.Cooked;
import fooddelivery.domain.Rejected;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import org.springframework.beans.BeanUtils;

@Entity
@Table(name = "StoreOrder_table")
@Data
public class StoreOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String foodId;

    private String preference;

    private Long orderId;

    private String status;

    private String test;

    @PostPersist
    public void onPostPersist() {
        Cooked cooked = new Cooked();
        BeanUtils.copyProperties(this, cooked);
        cooked.publishAfterCommit();

        Accepted accepted = new Accepted();
        BeanUtils.copyProperties(this, accepted);
        accepted.publishAfterCommit();

        Rejected rejected = new Rejected();
        BeanUtils.copyProperties(this, rejected);
        rejected.publishAfterCommit();
    }

    public static StoreOrderRepository repository() {
        StoreOrderRepository storeOrderRepository = StoreApplication.applicationContext.getBean(
            StoreOrderRepository.class
        );
        return storeOrderRepository;
    }

    public void finishCook() {}

    public void accept() {}

    public void reject() {}

    public void startCook() {}

    public static void 주문목록에추가(Paid paid) {
        StoreOrder storeOrder = new StoreOrder();
        /*
        LOGIC GOES HERE
        */
        // repository().save(storeOrder);

    }

    public static void 주문취소알림(OrderCanceled orderCanceled) {
        StoreOrder storeOrder = new StoreOrder();
        /*
        LOGIC GOES HERE
        */
        // repository().save(storeOrder);

    }
}
