package es.atos.proyecto.converter;

import es.atos.proyecto.dto.TemaDto;
import es.atos.proyecto.entity.Temas;
import es.atos.proyecto.entity.Usuario;

public class TemasConverter {
	
	public static Temas dtoToEntity(TemaDto temaDto) {
		
		Temas temas = new Temas();
		temas.setId(temaDto.getId());
		temas.setTema(temaDto.getTema());

		return temas;
	}
	
	public static TemaDto entityToDto(Temas temas) {
		
		TemaDto temaDto = new TemaDto();
		temaDto.setId(temas.getId());
		temaDto.setTema(temas.getTema());
		
		return temaDto;
	}
}
