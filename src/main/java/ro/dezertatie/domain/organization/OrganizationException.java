package ro.dezertatie.domain.organization;


import ro.dezertatie.common.domain.BusinessException;

public class OrganizationException extends BusinessException {

    public OrganizationException(String messageKey) {
        super(messageKey);
    }

    public OrganizationException(String messageKey, Throwable cause) {
        super(messageKey, cause);
    }
}
