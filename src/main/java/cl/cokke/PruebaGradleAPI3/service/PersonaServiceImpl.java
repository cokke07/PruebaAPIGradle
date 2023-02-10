package cl.cokke.PruebaGradleAPI3.service;

import cl.cokke.PruebaGradleAPI3.model.Persona;
import cl.cokke.PruebaGradleAPI3.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PersonaServiceImpl implements PersonaService{
    @Autowired
    private PersonaRepository personaRepository;
    @Override
    public List<Persona> findAll() {
        return personaRepository.findAll();
    }

    @Override
    public Persona create(Persona p) {
        return personaRepository.save(p);
    }
}
