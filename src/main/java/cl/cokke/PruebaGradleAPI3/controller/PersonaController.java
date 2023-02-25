package cl.cokke.PruebaGradleAPI3.controller;

import cl.cokke.PruebaGradleAPI3.exception.BadRequestException;
import cl.cokke.PruebaGradleAPI3.model.Persona;
import cl.cokke.PruebaGradleAPI3.service.PersonaService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Slf4j
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
        if (p.getNombre() == null || p.getNombre().isEmpty()) {
            throw new BadRequestException("Persona con nombre es requerida");
        }
        log.info("Usuario creado "+ personaService.create(p));
        return new ResponseEntity<>(personaService.create(p), HttpStatus.CREATED);
    }
}
