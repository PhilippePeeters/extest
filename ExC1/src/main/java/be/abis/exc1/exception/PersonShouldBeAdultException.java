package be.abis.exc1.exception;

public class PersonShouldBeAdultException extends Exception {

    public PersonShouldBeAdultException() {
        super();
    }

    public PersonShouldBeAdultException(String message) {
        super(message);
    }
}
