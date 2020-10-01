package be.abis.exc1.Model;

public class Company {

    private String name;
    private Address address;

    public Company(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public double calculateTaxToPay() {
        double returnTax = 0.0;
        switch (this.address.getCountryCode()) {
            case "BE":
                returnTax = 51.0;
                break;
            case "NL":
                returnTax = 47.0;
                break;
            default:
                returnTax = 35.0;
            break;
        }
        return returnTax;
    }
}
