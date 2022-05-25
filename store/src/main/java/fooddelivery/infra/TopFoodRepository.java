package fooddelivery.infra;

import fooddelivery.domain.*;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface TopFoodRepository extends CrudRepository<TopFood, Long> {
    List<TopFood> findByFooid(Long fooid);
}
