package es.atos.proyecto.converter;



import es.atos.proyecto.dto.UsuarioDto;
import es.atos.proyecto.entity.Usuario;

public class UsuarioConverter {
	
	public static Usuario dtoToEntity(UsuarioDto usuarioDto) {
		
		Usuario usuario = new Usuario();
		usuario.setDas(usuarioDto.getDas());
		usuario.setNombre(usuarioDto.getNombre());
		usuario.setApellidos(usuarioDto.getApellidos());
		usuario.setEmal(usuarioDto.getEmail());
		usuario.setPassword(usuarioDto.getPassword());
		usuario.setEstado(usuarioDto.isEstado());
		usuario.setRol(usuarioDto.getRol());
		
		return usuario;
	}
	
	public static UsuarioDto entityToDto(Usuario usuario) {
		
		UsuarioDto usuarioDto = new UsuarioDto();
		usuarioDto.setDas(usuario.getDas());
		usuarioDto.setNombre(usuario.getNombre());
		usuarioDto.setApellidos(usuario.getApellidos());
		usuarioDto.setEmail(usuario.getEmal());
		usuarioDto.setPassword(usuario.getPassword());
		usuarioDto.setEstado(usuario.isEstado());
		usuarioDto.setRol(usuario.getRol());
		
		return usuarioDto;
	}
	
}
