package be.abis.exc2.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

public class Address {

    private String street;
    private String nr;
    private String zipCode;
    private String town;
    private String country;
    private String countryCode;

    public Address(String street, String nr, String zipCode, String town, String country, String countryCode) {
        this.street = street;
        this.nr = nr;
        this.zipCode = zipCode;
        this.town = town;
        this.country = country;
        this.countryCode = countryCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNr() {
        return nr;
    }

    public void setNr(String nr) {
        this.nr = nr;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public boolean checkBelgianZipCode() {
        return (zipCode.matches("[0-9]+"));
    }

    public  void addressToBeWriteToFile(String fileName) throws IOException {
        Path pathToFile= Paths.get(fileName);
        String line = this.street + " " + this.nr + " " + this.zipCode + " " + this.town + " " + this.country + System.lineSeparator();
        try (BufferedWriter writer = Files.newBufferedWriter(pathToFile, StandardOpenOption.CREATE, StandardOpenOption.APPEND)) {
            writer.write(line);
        } catch (IOException e) {
            System.out.println("Could not write file to " + pathToFile);
            e.printStackTrace();
        }
    }

    public  ArrayList<String> addressToBeReadFromFile(String fileName) {
        ArrayList<String> addressesContentInTheFile = new ArrayList<String>();
        Path pathToFile= Paths.get(fileName);
        try (BufferedReader reader = Files.newBufferedReader(pathToFile)){
            String nextLine = null;
            while ((nextLine = reader.readLine()) != null) {
                addressesContentInTheFile.add(nextLine.trim());
            }
            reader.close();
            System.out.println("Number of adresses : " + addressesContentInTheFile.size());
        } catch (IOException e) {
            System.out.println("Could not write file to " + pathToFile);
            e.printStackTrace();
        }
        return addressesContentInTheFile;
    }
}
