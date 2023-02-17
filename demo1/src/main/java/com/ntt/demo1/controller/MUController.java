package com.ntt.demo1.controller;

import com.ntt.demo1.domain.MonitorUfficio;
import org.apache.logging.log4j.util.Strings;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/MonitorUfficio")
public class MUController {
    @GetMapping("/")
    public ResponseEntity<MonitorUfficio> returnMonitorUfficio(){
        Set<String> inputs = new HashSet<>();
        inputs.add("awt");
        inputs.add("hdm");
        MonitorUfficio mu = new MonitorUfficio();
        mu.setId(10);
        mu.setColore("nero");
        mu.setMarca("Oppo");
        mu.setInput("hdmi");
        mu.setInputs(inputs);
        return new ResponseEntity<>(mu , HttpStatus.OK);
    }
    @PostMapping("/")
    public ResponseEntity<?> createMU(@RequestBody MonitorUfficio mu){
        MonitorUfficio mu1 = mu;
        return new ResponseEntity<>(mu1, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateMU(@PathVariable long id, @RequestBody MonitorUfficio mu){
        Set<String> inputs1 = new HashSet<>();
        inputs1.add("awt");
        inputs1.add("hdm");
        MonitorUfficio mu1 = new MonitorUfficio();
        mu1.setId(23);
        mu1.setColore("nero");
        mu1.setMarca("Oppo");
        mu1.setInput("hdmi");
        mu1.setInputs(inputs1);
        if(mu1.getId()==id)
            return new ResponseEntity<>(mu, HttpStatus.CREATED);
        return new ResponseEntity<>(mu, HttpStatus.NO_CONTENT);
    }
@DeleteMapping("/{id}")
public ResponseEntity<?> deleteMU(@PathVariable long id,@RequestBody MonitorUfficio mu){
        System.out.println("Monitor Ufficio " + id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
}
}




