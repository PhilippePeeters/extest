package be.abis.exc2.ut;


import be.abis.exc2.exception.PersonShouldBeAdultException;
import be.abis.exc2.exception.SalaryTooLowException;
import be.abis.exc2.model.Company;
import be.abis.exc2.model.Person;
import be.abis.exc2.services.AbisPaymentServices;
import be.abis.exc2.services.PaymentService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.time.Instant;
import java.time.LocalDate;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class TestPaymentService {
    private PaymentService paymentService;

    @Mock
    private Company company;

    @Mock
    public Person person;

    @Before
    public void setup() {
        // Recreate the person before each test
//        person = new Person(1,"Philippe","Peeters", LocalDate.of(1967, 6, 23), company);
        System.out.println("Before Test:" + Instant.now());
        paymentService = new AbisPaymentServices();

    }

    @Test
    public void salaryToLowUnder1500()  {

        //Arrange
        String expectedMessage = "Net Salary under 1500";

        //Act
        Exception exception = assertThrows(SalaryTooLowException.class, () -> {
            person = new Person(1,"Philippe","Peeters", LocalDate.of(1967, 6, 23), company);
            Mockito.when(company.calculateTaxToPay()).thenReturn(35.0);
            person.setCompany(company);
            person.setGrossSalary(2000);
            double taxToPay = person.calculateNetSalary();
            verify(company).calculateTaxToPay();
        });

        //Assert
        assertTrue(exception.getMessage().contains(expectedMessage));
    }

    @Test
    public void salaryOfPersonShouldThrowException() throws SalaryTooLowException {
        Mockito.when(person.calculateNetSalary()).thenThrow(new SalaryTooLowException());
        paymentService.paySalary(person);
    }

}
