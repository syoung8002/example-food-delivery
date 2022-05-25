package fooddelivery.external;

import java.util.Date;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "front", url = "${api.path.front }")
public interface OrderService {
    @RequestMapping(method = RequestMethod.GET, path = "/orders/{id}")
    public Order getOrder(@PathVariable("id") Long id);
}
