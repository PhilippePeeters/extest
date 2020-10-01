package be.abis.exc2.services;

import be.abis.exc2.exception.SalaryTooLowException;
import be.abis.exc2.model.Person;

public class AbisPaymentServices implements PaymentService {

    public void paySalary(Person person) throws SalaryTooLowException {
        double netSalaryAmount = person.calculateNetSalary();
        System.out.println("Paying " + netSalaryAmount + " to " + person.getFirstName() + " " + person.getLastName());
    }
}
