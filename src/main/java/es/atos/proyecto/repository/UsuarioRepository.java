package es.atos.proyecto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.atos.proyecto.entity.Usuario;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String>{
	
	List<Usuario> findByDas(Long das);
}
