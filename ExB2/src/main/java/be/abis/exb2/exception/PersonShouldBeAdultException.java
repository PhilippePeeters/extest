package be.abis.exb2.exception;

public class PersonShouldBeAdultException extends Exception {

    public PersonShouldBeAdultException() {
        super();
    }

    public PersonShouldBeAdultException(String message) {
        super(message);
    }
}
