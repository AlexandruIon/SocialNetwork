package ro.dezertatie.person;

import ro.dezertatie.common.domain.BusinessException;

/**
 * Created by dev7 on 5/29/2015.
 */
public class PersonException extends BusinessException{

	public PersonException(String messageKey) {
		super(messageKey);
	}

	public PersonException(String messageKey, Throwable cause) {
		super(messageKey, cause);
	}
}
