package com.randomnumber.repository;

import com.randomnumber.model.Sequence;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SequenceRepository extends JpaRepository<Sequence, Long> {
}
