package com.github.kingready.library.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "LIB_EMPLOYEE", uniqueConstraints = {
        @UniqueConstraint(name = "unique_employeeId", columnNames = {"employeeId"})
})
public class Employee extends Person {

    private String employeeId;

    public Employee() {
    }

    public Employee(String firstName, String lastName, String employeeId) {
        super(firstName, lastName);
        this.setEmployeeId(employeeId);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId='" + getEmployeeId() + '\'' +
                "} " + super.toString();
    }


    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }
}
