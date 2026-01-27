package com.randomnumber.repository;

import com.randomnumber.model.SequenceRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SequenceRequestRepository extends JpaRepository<SequenceRequest, Long> {
}
