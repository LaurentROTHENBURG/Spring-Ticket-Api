package co.simplon.springticketapi.model;

public class Promotion {
    private Long id;
    private String description;

    //Constructeur
    public Promotion(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    //Accesseurs

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    //toString
    @Override
    public String toString() {
        return "Promotion{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }

}//fin classe