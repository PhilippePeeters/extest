package be.abis.exa3.ut;


import be.abis.exa3.model.Address;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestAddress {

    @Test
    public void belgianZipCodeShouldBeNumeric() {

        //Arrange
        Address a = new Address("Diestsevest", "32 bus 4B", "3000", "Leuven", "Belgique", "BE");

        //Act
        boolean resultCheckBelgianZipCode = a.checkBelgianZipCode();

        //Assert
        assertTrue(resultCheckBelgianZipCode);
    }

}
