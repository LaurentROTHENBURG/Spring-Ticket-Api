package co.simplon.springticketapi.controller;

import co.simplon.springticketapi.dao.LearnerDao;
import co.simplon.springticketapi.model.Learner;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/learner")
@RestController

public class LearnerController {

    private final LearnerDao learnerDao;

    public LearnerController(LearnerDao learnerDao) {
        this.learnerDao = learnerDao;
    }

    //Affichage de l'ensemble des apprenants - méthode GET sous api/learner
    @GetMapping
    public List<Learner> getAllLearner() {
        return learnerDao.getAll();
    }

    //Ajout d'apprenant - méthode POST pour inserer dans la table learner
    @PostMapping
    public Learner saveLearner(@RequestBody Learner learner) {
        System.out.println(learner);
        return learnerDao.save(learner);
    }

    //Suppression d'un apprenant à partir de api/learner/delete/id
    @GetMapping("/delete/{id}")
    public Learner deleteLearner(@PathVariable Long id) {
        return learnerDao.delete(id);
    }
}

