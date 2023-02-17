package com.ntt.demo0.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Gruppo {
    private List<Persona> persone = new ArrayList<>();
}
