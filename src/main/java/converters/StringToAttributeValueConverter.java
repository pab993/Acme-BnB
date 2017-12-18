
package converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import repositories.AttributeValueRepository;
import domain.AttributeValue;

@Component
@Transactional
public class StringToAttributeValueConverter implements Converter<String, AttributeValue> {

	@Autowired
	private AttributeValueRepository	attributeValueRepository;


	@Override
	public AttributeValue convert(String text) {
		AttributeValue result;
		int id;

		try {
			if (StringUtils.isEmpty(text)) {
				result = null;
			} else {
				id = Integer.valueOf(text);
				result = attributeValueRepository.findOne(id);
			}
		} catch (Throwable oops) {
			throw new IllegalArgumentException(oops);
		}
		return result;
	}

}
