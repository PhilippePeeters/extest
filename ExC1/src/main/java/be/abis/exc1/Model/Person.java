package be.abis.exc1.Model;

import be.abis.exc1.exception.PersonShouldBeAdultException;

import java.time.LocalDate;
import java.time.Period;

public class Person {

    private int personNumber;
    private String firstName;
    private String lastName;
    private LocalDate birthDay;
    private Company company;
    private double grossSalary;

    public Person(int personNumber, String firstName, String lastName, LocalDate birthDay) {
        this.personNumber = personNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDay = birthDay;
    }

    public Person(int personNumber, String firstName, String lastName, LocalDate birthDay, Company company) {
        this(personNumber, firstName, lastName, birthDay);
        this.company = company;
    }

    public int getPersonNumber() {
        return personNumber;
    }

    public void setPersonNumber(int personNumber) {
        this.personNumber = personNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public double getGrossSalary() {
        return grossSalary;
    }

    public void setGrossSalary(double grossSalary) {
        this.grossSalary = grossSalary;
    }

    @Override
    public String toString() {
        String text = null;
        try {
            text = "Person " + this.personNumber + ": " + this.firstName + " " + this.lastName + " (" + this.calculateAge() + " years old)";
        } catch (PersonShouldBeAdultException e) {
            e.printStackTrace();
        }
        if (this.company != null) {
            text += " works for " + this.company.getName() + " in " + this.company.getAddress().getTown() + ".";
        } else {
            text += " is not employed for the moment.";
        }
        return text;
    }


    public int calculateAge() throws PersonShouldBeAdultException {
        int age = Period.between(birthDay, LocalDate.now()).getYears();
        System.out.println("Age : " + age);
        if (age < 18) {
            throw new PersonShouldBeAdultException();
        }
        return age;
    }

    public double calculateNetSalary() {
        if (!company.equals(null)) {
            return  grossSalary*(1-company.calculateTaxToPay()/100.0);
        } else {
            return 0.0;
        }
    }
}





