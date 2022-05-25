package fooddelivery.domain;

import fooddelivery.domain.*;
import fooddelivery.infra.AbstractEvent;
import java.util.Date;
import lombok.Data;

@Data
public class Paid extends AbstractEvent {

    private Long id;
    private Long orderId;
}
