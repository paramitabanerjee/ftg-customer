package food.togo.customer.exceptions;

public enum ErrorMessages {

    CUSTOMER_NOT_FOUND("The customer with email %s not found"),
    AUTHENTICATION_FAILED("Password for user %s did not match");

    ErrorMessages(String s) {
    }
}
