package ro.dezertatie.domain.user;


import ro.dezertatie.common.domain.BusinessException;

public class UserException extends BusinessException {

	protected UserException(String messageKey) {
		super(messageKey);
	}

	protected UserException(String messageKey, Throwable cause) {
		super(messageKey, cause);
	}
}
