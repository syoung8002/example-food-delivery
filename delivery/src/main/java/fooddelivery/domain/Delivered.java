package fooddelivery.domain;

import fooddelivery.domain.*;
import fooddelivery.infra.AbstractEvent;
import java.util.Date;
import lombok.Data;

@Data
public class Delivered extends AbstractEvent {

    private Long id;

    public Delivered() {
        super();
    }
}
