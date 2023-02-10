package cl.cokke.PruebaGradleAPI3.controller;

import cl.cokke.PruebaGradleAPI3.model.Persona;
import cl.cokke.PruebaGradleAPI3.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/")
public class PersonaController {

    @Autowired
    PersonaService personaService;

    @GetMapping("personas")
    public ResponseEntity<?> buscarTodos(){
        List<Persona> personasList = personaService.findAll();

        return new ResponseEntity<>(personasList, HttpStatus.OK);
    }

    @PostMapping("create")
    public ResponseEntity<?> crearPersona(@RequestBody Persona p){

        return new ResponseEntity<>(personaService.create(p), HttpStatus.CREATED);
    }
}
