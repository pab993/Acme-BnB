
package converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import repositories.AttributeNameRepository;
import domain.AttributeName;

@Component
@Transactional
public class StringToAttributeNameConverter implements Converter<String, AttributeName> {

	@Autowired
	private AttributeNameRepository	attributeNameRepository;


	@Override
	public AttributeName convert(String text) {
		AttributeName result;
		int id;

		try {
			if (StringUtils.isEmpty(text)) {
				result = null;
			} else {
				id = Integer.valueOf(text);
				result = attributeNameRepository.findOne(id);
			}
		} catch (Throwable oops) {
			throw new IllegalArgumentException(oops);
		}
		return result;
	}

}
