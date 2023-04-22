package srs.example.burgerCloudApplication.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import srs.example.burgerCloudApplication.domain.Burger;
import srs.example.burgerCloudApplication.domain.Ingredients;

import java.sql.Timestamp;
import java.sql.Types;
import java.util.Arrays;
import java.util.Date;

@Repository
public class JdbcBurgerRepository implements BurgerRepository {

    private JdbcTemplate jdbcTemplate;


    public JdbcBurgerRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public Burger save(Burger burger) {
        long burgerId = saveBurgerInfo(burger);
        burger.setId(burgerId);
        for (Ingredients ingredients : burger.getIngredients()) {
            saveIngredientToBurger(ingredients, burgerId);
        }
        return burger;
    }

    private long saveBurgerInfo(Burger burger) {
        burger.setCreatedAt(new Date());
        PreparedStatementCreator pst = new PreparedStatementCreatorFactory("insert into Burger(name , createdAt) values (?, ?)", Types.VARCHAR, Types.TIMESTAMP)
                .newPreparedStatementCreator(Arrays.asList(
                        burger.getName(),
                        new Timestamp(burger.getCreatedAt().getTime())
                ));
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(pst, keyHolder);
        return keyHolder.getKey().longValue();
    }

    private void saveIngredientToBurger(Ingredients ingredients, long burgerId) {
        jdbcTemplate.update("insert into Burger_Ingredients (burger, ingredients) values (?, ?)", burgerId, ingredients.getId());
    }
}
