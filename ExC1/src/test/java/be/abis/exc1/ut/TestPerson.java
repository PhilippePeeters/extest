package be.abis.exc1.ut;


import be.abis.exc1.Model.Company;
import be.abis.exc1.exception.PersonShouldBeAdultException;
import be.abis.exc1.Model.Person;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.time.Instant;
import java.time.LocalDate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringStartsWith.startsWith;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;


@RunWith(MockitoJUnitRunner.class)
public class TestPerson {

    private Person person;
    private int checkAge = 0;

    @Mock
    public Company company;

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

    @Test
    @Ignore
    public void noIdeaYetWhatWeAreGoingToTest() throws PersonShouldBeAdultException {

    }

    @Test
    public void calculateNetSalaryOfBelgianPersonUsingMockCompany() {
        Mockito.when(company.calculateTaxToPay()).thenReturn(35.0);
        double taxToPay = person.calculateNetSalary();
        verify(company).calculateTaxToPay();
    }
}
