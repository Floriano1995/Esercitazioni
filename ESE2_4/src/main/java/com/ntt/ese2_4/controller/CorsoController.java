package com.ntt.ese2_4.controller;

import com.ntt.ese2_4.domain.Corso;
import com.ntt.ese2_4.repository.CorsoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
public class CorsoController {
    @Autowired
    CorsoRepository corsoRepository;

    @PostMapping("/corso")
    public ResponseEntity<?> createCorso(@RequestBody Corso corso) {

        List<Corso> lista = corsoRepository.findAll();
        boolean b = false;

        for (Corso c : lista) {
            if (c.getId() == corso.getId()) {
                b = true;
            }
        }
        if (b) {
            return new ResponseEntity<>("Errore duplicato", HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            Corso corso1 = corsoRepository.save(corso);
            return new ResponseEntity<>(corso1, HttpStatus.CREATED);
        }
    }

    @GetMapping("/corso")
    public ResponseEntity<?> findAll() {
        List<Corso> corsi = corsoRepository.findAll();
        return new ResponseEntity<>(corsi, HttpStatus.OK);
    }
    @GetMapping("/checkNumeri")
    public ResponseEntity<?> getNum() {
        List<Corso> lista = corsoRepository.findAll();
        int i = lista.size();
        return new ResponseEntity<>(i , HttpStatus.OK);
    }
    @GetMapping("/campi")
    public ResponseEntity<?> getCampi() {
        List<Corso> lista = corsoRepository.findAll();
        String campiC = null;
        String sc;
        for(Corso c: lista){
            sc = c.toString();
            campiC = campiC +sc;
        }
        return new ResponseEntity<>(campiC , HttpStatus.OK);
    }
    @GetMapping("/campi2")
    public ResponseEntity<?> getCampi2() {
        List<Corso> lista = corsoRepository.findAll();
        String campiC = null;
        String sc;
        for(Corso c: lista){
            sc = c.toString();
            campiC = campiC +sc;
        }
        return new ResponseEntity<>(campiC , HttpStatus.OK);
    }
    @GetMapping("/desc")
    public ResponseEntity<?> getCourses() {
        List<Corso> corsi = corsoRepository.findAll();
        List<Corso> corsi1 = new ArrayList<>();
        int i=0;
        for(Corso corso: corsi){

           if(corso.getDescrizione().length() > 20){
               corsi1.add(corso);
            }

        }
        return new ResponseEntity<>(corsi1 , HttpStatus.OK);
    }

    @GetMapping("/corsi_")
    public ResponseEntity<?> getCourses1(){

       int conta = 0;
        List<Corso> corsi = corsoRepository.findAll();



        for(Corso c : corsi) {
            if (c.getNomeCorso().substring(0, 6).equals("corso_")) {
                conta++;
            }
        }
        return new ResponseEntity<>(conta, HttpStatus.OK);
    }


    @PutMapping("/corso/{id}")
    public ResponseEntity<?> updateCorso(@PathVariable long id, @RequestBody Corso corso) {
        Corso corso2 = corsoRepository.save(corso);
        if (corso2.getId() == id)
            return new ResponseEntity<>(corso2, HttpStatus.CREATED);
        return new ResponseEntity<>(corso2, HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/corso/{id}")
    public ResponseEntity<?> deleteCorso(@PathVariable long id) {
        corsoRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @PostMapping("/corso1")
    public ResponseEntity<?> createCorso1(@RequestBody Corso corso) {
        if (corso.getNomeCorso().substring(0, 6).equals("corso_") && corso.getNomeCorso().length() >= 8) {
            Corso corso1 = corsoRepository.save(corso);
            return new ResponseEntity<>(corso1, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Nome errato", HttpStatus.INTERNAL_SERVER_ERROR);
        }
}
}

