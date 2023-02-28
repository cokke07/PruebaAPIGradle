package cl.cokke.PruebaGradleAPI3.service;

import cl.cokke.PruebaGradleAPI3.model.Persona;
import cl.cokke.PruebaGradleAPI3.repository.PersonaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j
@Service
public class PersonaServiceImpl implements PersonaService{
    @Autowired
    private PersonaRepository personaRepository;
    @Override
    public List<Persona> findAll() {
        log.info("Se llaman todas las personas");
        return personaRepository.findAll();
    }

    @Override
    public Persona create(Persona p) {

        return personaRepository.save(p);
    }

    @Override
    public Persona findByID(Long id) {
        return personaRepository.findById(id).orElseThrow();
    }

    @Override
    public Persona updatePersona(Persona p) {
        return personaRepository.save(p);
    }

    @Override
    public HttpStatus deletePersonaPorId(Long id) {
        personaRepository.deleteById(id);

        return HttpStatus.OK;
    }
}
