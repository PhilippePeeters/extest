package be.abis.exb1.ut;


import be.abis.exb1.model.Address;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;

public class TestAddress {

    private Address address;
    private final String addressesFileName = "addresses.txt";

    @BeforeEach
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
