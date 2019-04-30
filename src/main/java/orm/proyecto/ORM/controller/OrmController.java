package orm.proyecto.ORM.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import orm.proyecto.ORM.dto.UsuarioDto;
import orm.proyecto.ORM.services.UsuarioServices;


@RestController
public class OrmController {
	
	@Autowired
	private UsuarioServices servicio;
	
	@RequestMapping(value = { "/newUsuario" }, method = RequestMethod.POST, consumes = "application/json")
	@ResponseBody
	public Boolean addAnimal(@RequestBody UsuarioDto usuarioDto) throws IOException {
		servicio.addUsuario(usuarioDto);
		return true;
	}
}
