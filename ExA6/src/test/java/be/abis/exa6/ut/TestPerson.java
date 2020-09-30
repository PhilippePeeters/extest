package be.abis.exa6.ut;


import be.abis.exa6.model.Person;
import org.junit.Before;
import org.junit.Test;

import java.time.Instant;
import java.time.LocalDate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringStartsWith.startsWith;
import static org.junit.Assert.assertEquals;

public class TestPerson {

    private Person person;

    @Before
    public void setUp() {
        // Recreate the person before each test
        Person person = new Person(1,"Philippe","Peeters", LocalDate.of(1967, 6, 23));
        System.out.println("Before Test:" + Instant.now());
    }

    @Test
    public void ageOfPersonShouldBe52() {

        //Act
        int checkAge = person.calculateAge();

        //Asset
        assertEquals(52, checkAge);
    }

    @Test
    public void toStringSentenceStartsWithPerson() {

        //Act
        String resultCheck = person.toString();

        //Assert
        assertThat(resultCheck, startsWith("Person"));
    }

}
