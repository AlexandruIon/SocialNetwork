package ro.dezertatie.domain.contact;


import ro.dezertatie.common.domain.BusinessException;

public class ContactException extends BusinessException {

    public ContactException(String messageKey) {
        super(messageKey);
    }

    public ContactException(String messageKey, Throwable cause) {
        super(messageKey, cause);
    }
}
