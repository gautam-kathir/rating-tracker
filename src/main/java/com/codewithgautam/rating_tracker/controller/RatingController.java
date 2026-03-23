package com.codewithgautam.rating_tracker.controller;

import com.codewithgautam.rating_tracker.model.RatingEntry;
import com.codewithgautam.rating_tracker.repository.RatingEntryRepository;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

//GET - IDEMPOTENT
//POST - NON IDEMPOTENT ( Create new object )

@RestController
public class RatingController {

    private final RatingEntryRepository ratingEntryRepository;

    public RatingController(RatingEntryRepository ratingEntryRepository) {
        this.ratingEntryRepository = ratingEntryRepository;
    }

    // Write a new endpoint that returns all the player rating
    @GetMapping("/v1/players")
    public List<RatingEntry> getRatings() {
        return ratingEntryRepository.findAll();
    }

    @PostMapping("/v1/players")
    public RatingEntry addNewRating(@RequestBody  RatingEntry entry) {
        return ratingEntryRepository.save(entry);
    }
}
