package be.abis.exa4.ut;

import be.abis.exa4.model.Person;
import org.junit.Test;

import java.time.LocalDate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertEquals;

public class TestPersonWithHamcrest {

    @Test
    public void ageOfPersonShouldBe52() {

        //Arrange
        Person person = new Person(1,"Philippe","Peeters", LocalDate.of(1967, 6, 23));

        //Act
        int checkAge = person.calculateAge();

        //Asset
        assertThat(52, is(equalTo(checkAge)));
    }

}
