package com.ntt.demospringboot.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "persona")
@Data
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;
    private String nome;
    private String cognome;
}


