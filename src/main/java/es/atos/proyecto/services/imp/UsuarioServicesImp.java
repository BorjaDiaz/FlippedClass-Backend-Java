package es.atos.proyecto.services.imp;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import es.atos.proyecto.controller.UsuarioController;
import es.atos.proyecto.converter.UsuarioConverter;
import es.atos.proyecto.dto.UsuarioDto;
import es.atos.proyecto.entity.Usuario;
import es.atos.proyecto.repository.UsuarioRepository;
import es.atos.proyecto.services.UsuarioServices;

@Service
public class UsuarioServicesImp implements UsuarioServices{
	static Logger log = Logger.getLogger(UsuarioServicesImp.class.getName());
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public boolean addUsuario(UsuarioDto usuarioDto) throws IOException {
		log.info("Realizando la operacion para agregrar usuario");
		Usuario usuario = UsuarioConverter.dtoToEntity(usuarioDto);
		Usuario user = usuarioRepository.save(usuario);
		
		if (user != null) {
			log.info("Usuario agregado");
			return true;
		}
		log.info("Error al agregar el usuario");
		return false;
	}

	@Override
	public UsuarioDto updateUsuario(UsuarioDto usuarioDto) {
		Usuario usuario = usuarioRepository.findById(usuarioDto.getDas()).get();
		log.debug(usuario);
		
		if(usuario == null)
			return null;
		
		if(usuarioDto.getNombre() != null)
			usuario.setNombre(usuarioDto.getNombre());
		usuario = usuarioRepository.save(usuario);
		return UsuarioConverter.entityToDto(usuario);
	}

	@Override
	public String deleteUsuario(String id) {
		
		//No tiene que borrar solo cambiar el estado.
		
		return null;
	}

}
