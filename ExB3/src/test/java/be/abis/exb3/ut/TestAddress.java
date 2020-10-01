package be.abis.exb3.ut;


import be.abis.exb3.model.Address;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestAddress {

    private Address address;
    private final String addressesFileName = "addresses.txt";

    @Before
    public void setup(){
        address = new Address("street","nr","3000","leuven","belgium","BE");
        System.out.println("Before Test:" + Instant.now());
    }

    @Test
    public void belgianZipCodeShouldBeNumeric() {

        //Act
        boolean resultCheckBelgianZipCode = address.checkBelgianZipCode();

        //Assert
        assertTrue(resultCheckBelgianZipCode);
    }

    @Test
    public void NewAddressesInFile() throws IOException {

        //Act
        address.addressToBeWriteToFile(addressesFileName);
        ArrayList<String> addressesContentInTheFile = address.addressToBeReadFromFile(addressesFileName);
        int countAdresses = addressesContentInTheFile.size();

        //Assert
        assertEquals(1, countAdresses);
    }
}
