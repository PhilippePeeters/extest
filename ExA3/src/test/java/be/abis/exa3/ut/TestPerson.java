package be.abis.exa3.ut;


import be.abis.exa3.model.Person;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

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
