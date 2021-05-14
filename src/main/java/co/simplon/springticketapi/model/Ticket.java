package co.simplon.springticketapi.model;

import java.time.LocalDateTime;

public class Ticket {
    private Long id;
    private LocalDateTime date;
    private String description;
    private Boolean solved;
    private Integer learner_idx;


    public Ticket(LocalDateTime localDateTime) {
        this.date = localDateTime;
    }

    public Ticket(Long id, LocalDateTime date, String description, Boolean solved, Integer learner_idx) {
        this.id = id;
        this.date = date;
        this.description = description;
        this.solved = solved;
        this.learner_idx = learner_idx;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public String getSolved() {
        return "N";
    }

    public Integer getLearner_idx() {
        return learner_idx;
    }

    @Override
    public String toString() {
        return "Ticket{" + "id = " + id + ", date = " + date +
                ", description = " + description + ", resolution = " + solved +
                '}';
    }
}