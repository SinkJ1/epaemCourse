package by.task4.practics.services;

import org.springframework.stereotype.Service;
import by.task4.practics.entity.Number;

@Service
public class NumberService extends AbstractService<Number> implements GenericService<Number>{

	@Override
	protected Class<Number> getTClass() {
		return Number.class;
	}

}
