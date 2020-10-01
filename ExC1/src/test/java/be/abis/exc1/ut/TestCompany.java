package be.abis.exc1.ut;


import be.abis.exc1.Model.Address;
import be.abis.exc1.Model.Company;
import org.junit.Before;
import org.junit.Test;

import java.time.Instant;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class TestCompany {

    private Company company;
    private double checkTaxForBelgian = 0.0;

    @Before
    public void setUp() {
        // Recreate the person before each test
        Address adr1 = new Address("Rue des Mineurs",
                "51",
                "6001",
                "Marcinelle",
                "Belgique",
                "BE");
        company = new Company("Test1", adr1);
        System.out.println("Before Test:" + Instant.now());

    }

    @Test
    public void taxForBelgianCompanyShouldBe51()  {

        //Act
        checkTaxForBelgian = company.calculateTaxToPay();

        //Asset
        assertThat(51.0, equalTo(checkTaxForBelgian));
    }

}
