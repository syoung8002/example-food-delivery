package fooddelivery.domain;

import fooddelivery.domain.*;
import fooddelivery.infra.AbstractEvent;
import java.util.Date;
import lombok.Data;

@Data
public class 오후_12시 extends AbstractEvent {

    private Long id;

    public 오후_12시() {
        super();
    }
}
