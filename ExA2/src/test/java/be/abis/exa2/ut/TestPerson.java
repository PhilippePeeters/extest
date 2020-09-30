package be.abis.exa2.ut;


import be.abis.exa2.model.Person;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class TestPerson {

    @Test
    public void ageOfPersonShouldBe52() {

        //Arrange
        Person person = new Person(1,"Philippe","Peeters", LocalDate.of(1967, 6, 23));

        //Act
        int checkAge = person.calculateAge();

        //Assert
        assertEquals(52, checkAge);
    }

}
