package com.ntt.demospringboot.repository;

import com.ntt.demospringboot.domain.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona, Long > {
}