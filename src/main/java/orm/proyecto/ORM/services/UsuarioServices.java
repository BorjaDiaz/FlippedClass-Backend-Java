package orm.proyecto.ORM.services;

import java.io.IOException;

import orm.proyecto.ORM.dto.UsuarioDto;

public interface UsuarioServices {
	
	public boolean addUsuario(UsuarioDto usuarioDto) throws IOException;
	
	public UsuarioDto updateUsuario(String usuario);
	
	public String deleteUsuario(String id);
}
