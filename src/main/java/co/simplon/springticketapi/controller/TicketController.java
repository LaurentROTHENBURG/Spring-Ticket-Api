package co.simplon.springticketapi.controller;

import co.simplon.springticketapi.dao.TicketDao;
import co.simplon.springticketapi.model.Ticket;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Le point d'entree est api/tickets
@RequestMapping("/api/tickets")
@RestController

public class TicketController {

    private final TicketDao ticketDao;

    public TicketController(TicketDao ticketDao) {
        this.ticketDao = ticketDao;
    }

    //Affichage de tous les tickets à partir de /api/tickets - methode GET
    //************************************************************************
    @GetMapping
    public List<Ticket> getAllTickets() {
        return ticketDao.getAll();
    } //on va chercher la méthode getAll de la classe ticketDao

    //Affichage d'un ticket /api/tickets/{id} - methode GET
    //************************************************************************
    @GetMapping("/{id}")
    public Ticket getTicket(@PathVariable Long id) {
        return ticketDao.get(id);
    }

    //Affichage tickets en cours /api/tickets/inprogress - methode GET
    //************************************************************************
    @GetMapping("/inprogress")
    public List<Ticket> getTicketInProgress() {
        return ticketDao.getTicketInProgress();
    }

    //Affichage des tickets cloturés /api/tickets/closed - methode GET
    //************************************************************************
    @GetMapping("/closed")
    public List<Ticket> getTicketClosed() {
        return ticketDao.getTicketClosed();
    }

    //Suppression d'un ticket /api/tickets/delete/{id} - methode GET
    //************************************************************************
    @GetMapping("/delete/{id}")
    public Ticket deleteTicket(@PathVariable Long id) {
        return ticketDao.delete(id);
    }

    //Mise à jour d'un ticket /api/tickets/update/{id} - methode GET
    //************************************************************************
    @GetMapping("/update/{id}")
    public Ticket updateTicket(@PathVariable Long id) {
        return ticketDao.update(id);
    }

    //Création d'un ticket - méthode POST
    //************************************************************************
    @PostMapping
    public Ticket postTicket(@RequestBody Ticket ticket) {
        System.out.println(ticket);
        return ticketDao.save(ticket);
    }
}




