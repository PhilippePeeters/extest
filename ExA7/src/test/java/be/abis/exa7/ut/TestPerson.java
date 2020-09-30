package be.abis.exa7.ut;


import be.abis.exa7.exception.PersonShouldBeAdultException;
import be.abis.exa7.model.Person;
import org.junit.Before;
import org.junit.Test;

import java.time.Instant;
import java.time.LocalDate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.StringStartsWith.startsWith;
import static org.junit.Assert.assertEquals;

public class TestPerson {

    private Person person;
    private int checkAge = 0;


    @Before
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

    @Test(expected = PersonShouldBeAdultException.class)
    public void mustBeAdult() throws PersonShouldBeAdultException {

        //Arrange
        person.setBirthDay(LocalDate.of(2010, 6, 23));

        //Act
        checkAge = person.calculateAge();

        //Assert

    }

}
