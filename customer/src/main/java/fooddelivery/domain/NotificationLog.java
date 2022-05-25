package fooddelivery.domain;

import fooddelivery.CustomerApplication;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import org.springframework.beans.BeanUtils;

@Entity
@Table(name = "NotificationLog_table")
@Data
public class NotificationLog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String customerId;

    private String message;

    public static NotificationLogRepository repository() {
        NotificationLogRepository notificationLogRepository = CustomerApplication.applicationContext.getBean(
            NotificationLogRepository.class
        );
        return notificationLogRepository;
    }

    public static void 카카오톡알림(Accepted accepted) {
        NotificationLog notificationLog = new NotificationLog();
        /*
        LOGIC GOES HERE
        */
        // repository().save(notificationLog);

    }

    public static void 카카오톡알림(Rejected rejected) {
        NotificationLog notificationLog = new NotificationLog();
        /*
        LOGIC GOES HERE
        */
        // repository().save(notificationLog);

    }

    public static void 카카오톡알림(Cooked cooked) {
        NotificationLog notificationLog = new NotificationLog();
        /*
        LOGIC GOES HERE
        */
        // repository().save(notificationLog);

    }

    public static void 카카오톡알림(Paid paid) {
        NotificationLog notificationLog = new NotificationLog();
        /*
        LOGIC GOES HERE
        */
        // repository().save(notificationLog);

    }

    public static void 카카오톡알림(OrderPlaced orderPlaced) {
        NotificationLog notificationLog = new NotificationLog();
        /*
        LOGIC GOES HERE
        */
        // repository().save(notificationLog);

    }

    public static void 카카오톡알림(DeliveryStarted deliveryStarted) {
        NotificationLog notificationLog = new NotificationLog();
        /*
        LOGIC GOES HERE
        */
        // repository().save(notificationLog);

    }
}
