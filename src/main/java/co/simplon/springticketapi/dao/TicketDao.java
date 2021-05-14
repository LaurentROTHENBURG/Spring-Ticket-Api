package co.simplon.springticketapi.dao;

import co.simplon.springticketapi.model.Ticket;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TicketDao<ticket> implements Dao<Ticket> {

    private final JdbcTemplate jdbcTemplate;
    private final RowMapper<Ticket> ticketRowMapper;

    public TicketDao(JdbcTemplate jdbcTemplate, RowMapper<Ticket> ticketRowMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.ticketRowMapper = ticketRowMapper;
    }

    @Override
    public Ticket get(Long id) {
        return jdbcTemplate.queryForObject("select * from ticket where id = ?", ticketRowMapper, id);
    }
    //Affichage de tous les Tickets
    @Override
    public List<Ticket> getAll() {
        return jdbcTemplate.query("select * from ticket", ticketRowMapper);
    }

    //Affichage des Tickets en cours
    public List<Ticket> getTicketInProgress() {
        return jdbcTemplate.query("select * from ticket where solved='N'", ticketRowMapper);
    }

    //Affichage des Tickets resolus
    public List<Ticket> getTicketClosed(){
        return jdbcTemplate.query("select * from ticket where solved='Y'",ticketRowMapper);
    }


    //Création d'un ticket - insert dans  la table TICKET
    @Override
    public Ticket save(Ticket ticket) {
        jdbcTemplate.execute("INSERT INTO ticket (date, description, solved, learner_idx) VALUES" +
                "('" + ticket.getDate() + "','" + ticket.getDescription() + "','" + ticket.getSolved() + "','" + ticket.getLearner_idx() + "')");
        return ticket;
    }

    //Suppression d'un ticket - delete dans la table ticket
    @Override
    public Ticket delete(Long id) {
        jdbcTemplate.update("delete from ticket where id = ?",id); //? indique qu'il s'agit d'un paramètre à récupérerqui est dans ce cas l'ID
        System.out.println("Suppression effectuée de l'id ticket : " + id);
        return null;
    }

    //Mise à jour d'un ticket - update dans la table ticket du champ solved

    public Ticket update(Long id) {
        jdbcTemplate.update("update ticket set solved='Y' where id = ?", id); //? indique qu'il s'agit d'un paramètre à récupérerqui est dans ce cas l'ID
        System.out.println("Mise à jour  de l'id ticket : " + id);
        return null;
    }

}
