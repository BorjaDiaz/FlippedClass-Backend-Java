package orm.proyecto.ORM.services.imp;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import orm.proyecto.ORM.converter.UsuarioConverter;
import orm.proyecto.ORM.dto.UsuarioDto;
import orm.proyecto.ORM.entity.Usuario;
import orm.proyecto.ORM.repository.UsuarioRepository;
import orm.proyecto.ORM.services.UsuarioServices;

@Service
public class UsuarioServicesImp implements UsuarioServices{
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public boolean addUsuario(UsuarioDto usuarioDto) throws IOException {
		Scanner input = new Scanner(new File("password.dat"));
		String p = input.next();
		Usuario usuario = UsuarioConverter.dtoToEntity(usuarioDto);
		Usuario user = usuarioRepository.save(usuario);
		
		if (user != null)
			return true;
		return false;
	}

	@Override
	public UsuarioDto updateUsuario(String usuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteUsuario(String id) {
		
		//No tiene que borrar solo cambiar el estado.
		
		return null;
	}

}
