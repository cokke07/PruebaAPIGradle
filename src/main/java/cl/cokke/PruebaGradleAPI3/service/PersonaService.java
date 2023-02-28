package cl.cokke.PruebaGradleAPI3.service;

import cl.cokke.PruebaGradleAPI3.model.Persona;
import org.springframework.http.HttpStatus;

import java.util.List;

public interface PersonaService {

    public List<Persona> findAll();
    public Persona create(Persona p);
    public Persona findByID(Long id);
    public Persona updatePersona(Persona p);
    public HttpStatus deletePersonaPorId(Long id);
}
