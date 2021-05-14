package co.simplon.springticketapi.dao;

import co.simplon.springticketapi.model.Learner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LearnerDao implements Dao<Learner> {

    private final JdbcTemplate jdbcTemplate;
    private final RowMapper<Learner> learnerRowMapper;

    public LearnerDao(JdbcTemplate jdbcTemplate, RowMapper<Learner> learnerRowMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.learnerRowMapper = learnerRowMapper;
    }

    @Override
    public Learner get(Long id) {
        // A vous de jouer
        return null;
    }

    @Override
    public List<Learner> getAll() { return jdbcTemplate.query("select * from learner",learnerRowMapper);}

        @Override
    public Learner save(Learner learner) {
        jdbcTemplate.execute("insert into learner (name, promotion_idx) values ('"+ learner.getName() + "','"+ learner.getPromotion_idx() +"')");
        //jdbcTemplate.execute("insert into learner (name) values ('toto')");
        return learner;
    }

    @Override
    public Learner delete(Long id) {
      jdbcTemplate.update("delete from learner where id=?",id); //? indique qu'il s'agit d'un paramètre à récupérer qui est dans ce cas l'ID
        System.out.println("Suppression effectuée de l'id learner : " + id);
        return null;
    }


}
