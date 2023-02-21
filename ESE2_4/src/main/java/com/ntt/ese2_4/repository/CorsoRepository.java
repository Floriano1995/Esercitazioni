package com.ntt.ese2_4.repository;

import com.ntt.ese2_4.domain.Corso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CorsoRepository extends JpaRepository<Corso, Long> {
}