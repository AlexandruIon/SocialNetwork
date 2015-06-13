package ro.dezertatie.domain.product;


import ro.dezertatie.common.domain.BusinessException;

public class ProductException extends BusinessException {

    public ProductException(String messageKey) {
        super(messageKey);
    }

    public ProductException(String messageKey, Throwable cause) {
        super(messageKey, cause);
    }
}
