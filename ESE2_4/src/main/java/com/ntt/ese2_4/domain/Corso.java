package com.ntt.ese2_4.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "corso")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Corso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;
private String nomeCorso;
private String descrizione;
}
