package be.abis.exc2.exception;

public class SalaryTooLowException extends Exception {

    public SalaryTooLowException() {
        super();
    }

    public SalaryTooLowException(String message) {
        super(message);
    }
}
