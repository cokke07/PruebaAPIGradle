package cl.cokke.PruebaGradleAPI3.service;

import cl.cokke.PruebaGradleAPI3.model.Persona;

import java.util.List;

public interface PersonaService {

    public List<Persona> findAll();
    public Persona create(Persona p);
}
