package com.github.kingready.library.model;

import com.github.kingready.library.model.embedded.Address;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.Valid;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "LIB_CUSTOMER")
public class Customer extends Person {

    @Valid
    @Embedded
    private Address address;

    @OneToMany(mappedBy = "customer", orphanRemoval = true)
    private List<Loan> loans;

    public Customer() {
        init();
    }

    public Customer(String firstName, String lastName, Address address) {
        super(firstName, lastName);
        init();
        this.setAddress(address);
    }

    public void init() {
        loans = new LinkedList<>();
    }

    public Iterable<Loan> getLoans() {
        return loans;
    }

    public void addLoan(Loan loan) {
        if (loan != null) {
            loans.add(loan);
        }
    }

    @Override
    public String toString() {
        return "Customer{" +
                "address=" + getAddress() +
                "} " + super.toString();
    }


    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
