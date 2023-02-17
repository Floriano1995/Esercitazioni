package com.ntt.demo1.controller;


import com.ntt.demo1.domain.Canale;
import com.ntt.demo1.domain.Tv;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/TV")
public class TVController {
    @GetMapping("/")
    public ResponseEntity<Tv> returnTV() {
        Tv tv = new Tv();
        ArrayList<Canale> canali = new ArrayList<>();
        Canale ch = new Canale("Rai1", 1, false);
        Canale ch1 = new Canale("Rai2", 2, false);
        Canale ch2 = new Canale("Rai3", 3, false);
        canali.add(ch);
        canali.add(ch1);
        canali.add(ch2);
        tv.setId(24);
        tv.setColore("nero");
        tv.setMarca("Oppo");
        tv.setCanale(canali);
        return new ResponseEntity<>(tv, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<?> createTV(@RequestBody Tv tv) {
        Tv tv1 = tv;
        return new ResponseEntity<>(tv1, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateMU(@PathVariable long id, @RequestBody Tv tv) {
        Tv tv2 = new Tv();
        Canale ch = new Canale("Rai1", 1, false);
        Canale ch1 = new Canale("Rai2", 2, false);
        Canale ch2 = new Canale("Rai3", 3, false);
        ArrayList<Canale> canali = new ArrayList<>();
        canali.add(ch);
        canali.add(ch1);
        canali.add(ch2);
        tv2.setId(25);
        tv2.setColore("nero");
        tv2.setMarca("Oppo");
        tv2.setCanale(canali);
        if (tv2.getId()==id)
            return new ResponseEntity<>(tv, HttpStatus.CREATED);
        return new ResponseEntity<>(tv, HttpStatus.NO_CONTENT);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMU(@PathVariable long id, @RequestBody Tv tv) {
        System.out.println("Monitor Tv" + id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}
