package be.abis.exa7.exception;

public class PersonShouldBeAdultException extends Exception {

    public PersonShouldBeAdultException() {
        super();
    }

    public PersonShouldBeAdultException(String message) {
        super(message);
    }
}
