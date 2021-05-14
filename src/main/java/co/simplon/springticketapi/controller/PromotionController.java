package co.simplon.springticketapi.controller;


import co.simplon.springticketapi.dao.PromotionDao;
import co.simplon.springticketapi.model.Promotion;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/promotion")
@RestController

public class PromotionController {
    private final PromotionDao promotionDao;

    public PromotionController(PromotionDao promotionDao) {
        this.promotionDao = promotionDao;
    }

    //Methode GET pour afficher les promos
    @GetMapping
    public List<Promotion> getAllPromotion() {
        return promotionDao.getAll();
    }

    //Methode POST pour créer une promo
    @PostMapping
    public Promotion savePromotion(@RequestBody Promotion promotion) {
        return promotionDao.save(promotion);
    }

}
