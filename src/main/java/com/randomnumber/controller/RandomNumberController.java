package com.randomnumber.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.randomnumber.model.RandomNumberResponse;
import com.randomnumber.service.RandomNumberService;

@RestController
@RequestMapping("/api/random")
public class RandomNumberController {

    @Autowired
    private RandomNumberService randomNumberService;

    /**
     * Generate and return the next sequence number (starting from 7000, resets daily)
     * GET /api/random/generate
     */
    @GetMapping("/generate")
    public RandomNumberResponse generateNumber(@RequestParam("requester") String requester) {
        System.out.println("[REQUEST] /api/random/generate called by requester: " + requester);
        RandomNumberResponse response = randomNumberService.generateRandomNumber(requester);
        System.out.println("[RESPONSE] Number generated: " + response.getRandomNumber());
        return response;
    }

    /**
     * Reset the sequence to 7000
     * POST /api/random/reset
     */
    @GetMapping("/reset")
    public String resetSequence() {
        randomNumberService.resetSequence();
        return "Sequence reset to 7000";
    }
}
