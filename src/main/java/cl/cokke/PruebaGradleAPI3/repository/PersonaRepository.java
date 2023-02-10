package cl.cokke.PruebaGradleAPI3.repository;

import cl.cokke.PruebaGradleAPI3.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {

}
