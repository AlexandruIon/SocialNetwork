package ro.dezertatie.common.domain;

import javax.ejb.ApplicationException;

@ApplicationException(rollback = true)
public class BusinessException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	protected BusinessException(String messageKey) {
		super(messageKey);
	}

	protected BusinessException(String messageKey, Throwable cause) {
		super(messageKey);
	}

}
