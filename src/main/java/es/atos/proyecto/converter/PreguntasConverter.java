package es.atos.proyecto.converter;

import es.atos.proyecto.dto.TemaDto;
import es.atos.proyecto.dto.TestDto;
import es.atos.proyecto.entity.Temas;
import es.atos.proyecto.entity.Test;

public class PreguntasConverter {
	
	public static Test dtoToEntity(TestDto testDto) {
		
		Test test = new Test();
		test.setId(testDto.getId());
		test.setPregunta(testDto.getPregunta());
		test.setRespFalsa1(testDto.getRespFalsa1());
		test.setRespFalsa2(testDto.getRespFalsa2());
		test.setRespFalsa3(testDto.getRespFalsa3());

		return test;
	}
	
	public static TestDto entityToDto(Test test) {
		
		TestDto testDto = new TestDto();
		testDto.setId(test.getId());
		testDto.setIdTema(test.getTemas().getId());
		testDto.setPregunta(test.getPregunta());
		testDto.setRespFalsa1(test.getRespFalsa1());
		testDto.setRespFalsa2(test.getRespFalsa2());
		testDto.setRespFalsa3(test.getRespFalsa3());
		
		return testDto;
	}
}
