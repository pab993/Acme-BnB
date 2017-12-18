
package converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import domain.AttributeName;

@Component
@Transactional
public class AttributeNameToStringConverter implements Converter<AttributeName, String> {

	@Override
	public String convert(AttributeName attributeName) {
		String result;

		if (attributeName == null) {
			result = null;
		} else {
			result = String.valueOf(attributeName.getId());
		}

		return result;
	}

}
