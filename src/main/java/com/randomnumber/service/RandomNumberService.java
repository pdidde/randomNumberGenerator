package com.randomnumber.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.randomnumber.model.RandomNumberResponse;
import com.randomnumber.model.Sequence;
import com.randomnumber.model.SequenceRequest;
import com.randomnumber.repository.SequenceRepository;
import com.randomnumber.repository.SequenceRequestRepository;

@Service
public class RandomNumberService {

    @Autowired
    private SequenceRepository sequenceRepository;

    @Autowired
    private SequenceRequestRepository sequenceRequestRepository;

    private static final int START_NUMBER = 7000;

    /**
     * Generate a sequence number starting from 7000, increment by 1, reset daily
     * Capture userName and store request details
     */
    public RandomNumberResponse generateRandomNumber(String requester) {
        LocalDate today = LocalDate.now();
        Sequence sequence = sequenceRepository.findAll().stream().findFirst().orElse(null);

        if (sequence == null) {
            sequence = new Sequence(START_NUMBER, today);
        } else if (!sequence.getLastResetDate().isEqual(today)) {
            sequence.setCurrentValue(START_NUMBER);
            sequence.setLastResetDate(today);
        } else {
            sequence.setCurrentValue(sequence.getCurrentValue() + 1);
        }

        sequenceRepository.save(sequence);

        // Store request details
        SequenceRequest request = new SequenceRequest(requester, sequence.getCurrentValue(), java.time.LocalDateTime.now());
        sequenceRequestRepository.save(request);

        return new RandomNumberResponse(sequence.getCurrentValue(), System.currentTimeMillis());
    }

    /**
     * Reset the sequence to 7000 (does not change lastResetDate)
     */
    public void resetSequence() {
        Sequence sequence = sequenceRepository.findAll().stream().findFirst().orElse(null);
        if (sequence != null) {
            sequence.setCurrentValue(START_NUMBER);
            sequenceRepository.save(sequence);
        } else {
            sequenceRepository.save(new Sequence(START_NUMBER, java.time.LocalDate.now()));
        }
    }
}
