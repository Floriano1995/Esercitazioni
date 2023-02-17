package com.ntt.demo0.controller;

import com.ntt.demo0.domain.Gruppo;
import com.ntt.demo0.domain.Persona;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/persona")
public class PersonaController {

    @GetMapping("/ciao")
    public ResponseEntity<String> returnCiao() {
        return new ResponseEntity<>("ciao", HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<Persona> returnPersona() {
        Persona persona = new Persona();
        persona.setName("Ale");
        persona.setSurname("Sall");
        return new ResponseEntity<>(persona, HttpStatus.OK);

    }

    @GetMapping("/ciao3")
    public ResponseEntity<Map<String, String>> returnMap() {
        Map<String, String> mappa = new HashMap<>();
        mappa.put("ciao", "ciao");
        ResponseEntity<Map<String, String>> responseEntity = new ResponseEntity<>(mappa, HttpStatus.OK);
        return responseEntity;
    }

    @PostMapping("/")
    public ResponseEntity<?> createPersona(@RequestBody Persona persona) {
        Persona persona1 = persona;
        return new ResponseEntity<>(persona1, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePersona(@PathVariable("id") long id_persona,@RequestBody  Persona persona) {
        Persona persona2 = new Persona(1, "Flo", "Prete");
        if (persona2.getId() == id_persona)
            return new ResponseEntity<>(persona, HttpStatus.CREATED);
        return new ResponseEntity<>(persona, HttpStatus.NO_CONTENT);
    }


    @DeleteMapping("/{id}")
public ResponseEntity<?> deletePersona(@PathVariable long id){
//Map<String, String> mappa = new HashMap<>();
//mappa.put("Persona" , "" + id);
return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/gruppo")
    public ResponseEntity<?> returnGruppo(){
        Gruppo gruppo = new Gruppo();
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "Flo" , "Prete"));
        personas.add(new Persona(2, "Floo" , "Pretee"));
        gruppo.setPersone(personas);
        return new ResponseEntity<>(gruppo , HttpStatus.OK);
    }
    @PostMapping("/gruppo")
    public ResponseEntity<?> createPersona(@RequestBody Gruppo gruppo) {
        return new ResponseEntity<>(gruppo, HttpStatus.CREATED);
    }
}
