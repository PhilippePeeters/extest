package be.abis.exa6.ut;

import be.abis.exa6.model.Person;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.time.Instant;
import java.time.LocalDate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.StringStartsWith.startsWith;

public class TestPersonWithHamcrest {

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
        assertThat(52, is(equalTo(checkAge)));
    }

    @Test
    public void toStringSentenceStartsWithPerson() {

        //Act
        String resultCheck = person.toString();

        //Assert
        assertThat(resultCheck, startsWith("Person"));
    }
}
