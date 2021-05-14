package co.simplon.springticketapi.model;

public class Learner {

    private Long id;
    private String name;
    private int promotion_idx;

    @Override
    public String toString() {
        return "Learner{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", promotion_idx=" + promotion_idx +
                '}';
    }

    //Constructeur
    public Learner(Long id, String name, int promotion_idx) {
        this.id = id;
        this.name = name;
        this.promotion_idx = promotion_idx;
    }

    //Accesseurs
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getPromotion_idx() {
        return promotion_idx;
    }
    public void setPromotion_idx(int promotion_idx) {
        this.promotion_idx = promotion_idx;
    }
 }

