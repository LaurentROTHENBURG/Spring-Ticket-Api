package co.simplon.springticketapi.dao;

import co.simplon.springticketapi.model.Promotion;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PromotionDao implements Dao<Promotion> {

    private final JdbcTemplate jdbcTemplate;
    private final RowMapper<Promotion> promotionRowMapper;

    public PromotionDao(JdbcTemplate jdbcTemplate, RowMapper<Promotion> promotionRowMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.promotionRowMapper = promotionRowMapper;
    }

    @Override
    public Promotion get(Long id) {
        return null;
    }

    //Affichage des promos
    public List<Promotion> getAll(){
        return jdbcTemplate.query("select * from promotion", promotionRowMapper);
    }

    @Override
    public Promotion save(Promotion promotion) {
        jdbcTemplate.execute("insert into promotion (description) values ('" + promotion.getDescription() +"') ");
    return promotion;
    }

    @Override
    public Promotion delete(Long id) {
        return null;
    }

}//fin classe

