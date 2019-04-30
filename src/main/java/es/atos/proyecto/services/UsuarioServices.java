package es.atos.proyecto.services;

import java.io.IOException;

import es.atos.proyecto.dto.UsuarioDto;

public interface UsuarioServices {
	
	public boolean addUsuario(UsuarioDto usuarioDto) throws IOException;
	
	public UsuarioDto updateUsuario(UsuarioDto usuarioDto);
	
	public String deleteUsuario(String id);
}
