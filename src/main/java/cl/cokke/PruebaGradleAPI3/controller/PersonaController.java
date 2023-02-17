package cl.cokke.PruebaGradleAPI3.controller;

import cl.cokke.PruebaGradleAPI3.exception.BadRequestException;
import cl.cokke.PruebaGradleAPI3.model.Persona;
import cl.cokke.PruebaGradleAPI3.service.PersonaService;
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

@RestController
@RequestMapping("/")
public class PersonaController {

    @Autowired
    PersonaService personaService;

    private static final Logger log= LoggerFactory.getLogger(PersonaController.class);
    @GetMapping("personas")
    public ResponseEntity<?> buscarTodos(){
        List<Persona> personasList = personaService.findAll();

        return new ResponseEntity<>(personasList, HttpStatus.OK);
    }

    @PostMapping("create")
    public ResponseEntity<?> crearPersona(@RequestBody Persona p){
        if (p == null) {
            throw new BadRequestException("Persona es requerida");
        }
        log.info("Usuario creado "+ personaService.create(p));
        return new ResponseEntity<>(personaService.create(p), HttpStatus.CREATED);
    }
}
