package com.github.kingready.library.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "LIB_LOAN")
public class Loan implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private LocalDate loanDate;
    private LocalDate returnDate;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Book book;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Customer customer;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Employee employee;

    public Loan() {
    }

    public Loan(LocalDate loanDate, LocalDate returnDate, Book book, Customer customer, Employee employee) {
        this.setLoanDate(loanDate);
        this.setReturnDate(returnDate);
        this.setBook(book);
        this.setCustomer(customer);
        this.setEmployee(employee);
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(LocalDate loanDate) {
        this.loanDate = loanDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
        this.customer.addLoan(this);
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
