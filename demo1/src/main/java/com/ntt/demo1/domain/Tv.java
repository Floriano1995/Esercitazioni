package com.ntt.demo1.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tv extends Monitor{
    private ArrayList<Canale> canale = new ArrayList<>();
    public void risintonizza(ArrayList<Canale> channels){
        for(Canale ch : channels){
            if(ch.getNCanale() == 1){
                ch.setStatus(true);
            }
        }
    }
}
