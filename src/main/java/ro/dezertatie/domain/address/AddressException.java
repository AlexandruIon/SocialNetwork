package ro.dezertatie.domain.address;

import ro.dezertatie.common.domain.BusinessException;


public class AddressException extends BusinessException {

    public AddressException(String messageKey) {
        super(messageKey);
    }

    public AddressException(String messageKey, Throwable cause) {
        super(messageKey, cause);
    }
}
