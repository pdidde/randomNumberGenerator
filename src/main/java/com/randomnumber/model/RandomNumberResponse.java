package com.randomnumber.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RandomNumberResponse {
    
    @JsonProperty("random_number")
    private int randomNumber;

    @JsonProperty("generated_at")
    private long generatedAt;

    public RandomNumberResponse(int randomNumber, long generatedAt) {
        this.randomNumber = randomNumber;
        this.generatedAt = generatedAt;
    }

    public int getRandomNumber() {
        return randomNumber;
    }

    public void setRandomNumber(int randomNumber) {
        this.randomNumber = randomNumber;
    }

    public long getGeneratedAt() {
        return generatedAt;
    }

    public void setGeneratedAt(long generatedAt) {
        this.generatedAt = generatedAt;
    }
}
