package com.randomnumber.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "sequence_requests")
public class SequenceRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "requester", nullable = false)
    private String requester;

    @Column(nullable = false)
    private int numberGenerated;

    @Column(nullable = false)
    private LocalDateTime requestTime;

    public SequenceRequest() {}

    public SequenceRequest(String requester, int numberGenerated, LocalDateTime requestTime) {
        this.requester = requester;
        this.numberGenerated = numberGenerated;
        this.requestTime = requestTime;
    }

    // Getters and setters
    public Long getId() { return id; }
    public String getRequester() { return requester; }
    public void setRequester(String requester) { this.requester = requester; }
    public int getNumberGenerated() { return numberGenerated; }
    public void setNumberGenerated(int numberGenerated) { this.numberGenerated = numberGenerated; }
    public LocalDateTime getRequestTime() { return requestTime; }
    public void setRequestTime(LocalDateTime requestTime) { this.requestTime = requestTime; }
}
