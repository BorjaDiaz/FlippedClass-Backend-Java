package es.atos.proyecto.controller;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import es.atos.proyecto.dto.UsuarioDto;
import es.atos.proyecto.services.UsuarioServices;


@RestController
public class UsuarioController {
	static Logger log = Logger.getLogger(UsuarioController.class.getName());
	
	@Autowired
	private UsuarioServices servicio;
	
	@RequestMapping(value = { "/newUsuario" }, method = RequestMethod.POST, consumes = "application/json")
	@ResponseBody
	public Boolean addAnimal(@RequestBody UsuarioDto usuarioDto) throws IOException {
		log.info("Agregando usuario");
		servicio.addUsuario(usuarioDto);
		return true;
	}
	
	@RequestMapping(value = { "/updateUsuario" }, method = RequestMethod.POST, consumes = "application/json")
	@ResponseBody
	public Boolean updateUsuario(@RequestBody UsuarioDto usuarioDto) throws IOException {
		log.info("Actualizando usuario");
		servicio.updateUsuario(usuarioDto);
		return true;
	}
}
