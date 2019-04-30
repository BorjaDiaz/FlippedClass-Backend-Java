package orm.proyecto.ORM.converter;

import orm.proyecto.ORM.dto.TemaDto;
import orm.proyecto.ORM.entity.Temas;
import orm.proyecto.ORM.entity.Usuario;

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
