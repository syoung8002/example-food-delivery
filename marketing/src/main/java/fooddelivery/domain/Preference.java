package fooddelivery.domain;

import fooddelivery.MarketingApplication;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import org.springframework.beans.BeanUtils;

@Entity
@Table(name = "Preference_table")
@Data
public class Preference {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long foodId;

    private Integer count;

    public static PreferenceRepository repository() {
        PreferenceRepository preferenceRepository = MarketingApplication.applicationContext.getBean(
            PreferenceRepository.class
        );
        return preferenceRepository;
    }

    public static void 주문내역수집(OrderPlaced orderPlaced) {
        Preference preference = new Preference();
        /*
        LOGIC GOES HERE
        */
        // repository().save(preference);

    }

    public static void 추천(오후_12시 오후_12시) {
        Preference preference = new Preference();
        /*
        LOGIC GOES HERE
        */
        // repository().save(preference);

    }
}
