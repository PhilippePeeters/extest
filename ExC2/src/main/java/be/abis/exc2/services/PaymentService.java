package be.abis.exc2.services;

import be.abis.exc2.exception.SalaryTooLowException;
import be.abis.exc2.model.Person;

public interface PaymentService {

    public void paySalary(Person person) throws SalaryTooLowException;

}
