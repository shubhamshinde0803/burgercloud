package srs.example.burgerCloudApplication.data;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import srs.example.burgerCloudApplication.domain.Burger;
import srs.example.burgerCloudApplication.domain.Order;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class JdbcOrderRepository implements OrderRepository{

    private SimpleJdbcInsert orderBurgerInserter;
    private SimpleJdbcInsert orderInserter;
    private ObjectMapper objectMapper;

    @Autowired
    public JdbcOrderRepository(JdbcTemplate jdbcTemplate){
        this.orderInserter = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName("Burger_Order")
                .usingGeneratedKeyColumns("id");
        this.orderBurgerInserter = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName("Burger_Order_Burgers");
        this.objectMapper = new ObjectMapper();

    }

    @Override
    public Order save(Order order) {
        order.setPlacedAt(new Date());
        long orderId = saveOrderDetails(order);
        order.setId(orderId);
        List<Burger> burgers = order.getBurgers();
        for(Burger burger : burgers){
            saveBurgerToOrder(burger, orderId);
        }
        return order;
    }

    private long saveOrderDetails(Order order){
        @SuppressWarnings("unchecked")
        Map<String, Object> values = objectMapper.convertValue(order, Map.class);
        values.put("placedAt", order.getPlacedAt());
        long orderId = orderInserter
                .executeAndReturnKey(values)
                .longValue();
        return orderId;
    }

    private void saveBurgerToOrder(Burger burger, long orderId){
        Map<String, Object> values = new HashMap<>();
        values.put("burgerOrder", orderId);
        values.put("burger", burger.getId());
        orderBurgerInserter.execute(values);
    }
}
