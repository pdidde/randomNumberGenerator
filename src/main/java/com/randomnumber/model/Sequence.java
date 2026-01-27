package com.randomnumber.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "sequences")
public class Sequence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private int currentValue;

    @Column(nullable = false)
    private LocalDate lastResetDate;

    public Sequence() {}

    public Sequence(int currentValue, LocalDate lastResetDate) {
        this.currentValue = currentValue;
        this.lastResetDate = lastResetDate;
    }

    public Long getId() { return id; }
    public int getCurrentValue() { return currentValue; }
    public void setCurrentValue(int currentValue) { this.currentValue = currentValue; }
    public LocalDate getLastResetDate() { return lastResetDate; }
    public void setLastResetDate(LocalDate lastResetDate) { this.lastResetDate = lastResetDate; }
}
