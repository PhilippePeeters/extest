package be.abis.exb1.ut;


import be.abis.exb1.exception.PersonShouldBeAdultException;
import be.abis.exb1.model.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.time.Instant;
import java.time.LocalDate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringStartsWith.startsWith;
import static org.junit.jupiter.api.Assertions.*;

public class TestPerson {

    private Person person;
    private int checkAge = 0;


    @BeforeEach
    public void setUp() {
        // Recreate the person before each test
        person = new Person(1,"Philippe","Peeters", LocalDate.of(1967, 6, 23));
        System.out.println("Before Test:" + Instant.now());
    }

    @Test
    public void ageOfPersonShouldBe52() throws PersonShouldBeAdultException {

        //Act
            checkAge = person.calculateAge();

        //Asset
        assertEquals(52, checkAge);
    }

    @Test
    public void toStringSentenceStartsWithPerson() throws PersonShouldBeAdultException {

        //Act
        String resultCheck = person.toString();

        //Assert
        assertThat(resultCheck, startsWith("Person"));
    }

    @Test
    public void mustBeAdult() throws PersonShouldBeAdultException {

        //Arrange
        String expectedMessage = "Must be Adult";
//        String actualMessage = exception.getMessage();

        //Act
        Exception exception = assertThrows(PersonShouldBeAdultException.class, () -> {
            person.setBirthDay(LocalDate.of(1967, 6, 23));
            checkAge = person.calculateAge();
        });

        //Assert
        assertTrue(exception.getMessage().contains(expectedMessage));
    }

}
