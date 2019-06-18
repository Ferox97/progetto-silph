package it.uniroma3.siw.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.uniroma3.siw.model.Fotografo;
import it.uniroma3.siw.model.Funzionario;

@Repository
public interface FunzionarioRepository extends JpaRepository<Funzionario,Long> {
	
	public Funzionario findByUsername(String username);

}
