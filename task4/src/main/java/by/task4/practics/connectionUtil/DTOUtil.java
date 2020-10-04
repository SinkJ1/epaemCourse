package by.task4.practics.connectionUtil;

import org.modelmapper.ModelMapper;

import by.task4.practics.entity.DTOEntity;


public class DTOUtil {

	public static DTOEntity convertToDto(Object obj, DTOEntity mapper) {
		return new ModelMapper().map(obj, mapper.getClass());
	}

	public static Object convertToEntity(Object obj, DTOEntity mapper) {
		return new ModelMapper().map(mapper, obj.getClass());
	}
}
