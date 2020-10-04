package by.task4.practics.services;

import org.springframework.stereotype.Service;
import by.task4.practics.entity.Number;

@Service
public class NumberServiceImpl extends AbstractService<Number> implements GenericService<Number>{

	@Override
	protected Class<Number> getTClass() {
		return Number.class;
	}

}
