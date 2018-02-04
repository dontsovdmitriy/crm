package com.dontsov.model.entity.util;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class TurnoverStringToLong implements Converter<Object, Long>{

	@Override
	public Long convert(Object element) {
		long turnover = Long.parseLong(((String) element).replaceAll("[,.]+", ""));
		return turnover;
	}

}
