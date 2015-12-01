package com.github.kingready.library.model.embedded;

import com.github.kingready.library.model.validator.ZipCode;

import javax.persistence.Embeddable;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Embeddable
public class Address {
    @ZipCode
    private String zipCode;
    @Size(min = 3)
    private String city;
    @Min(1)
    private Integer number;

    public Address() {
    }

    public Address(String zipCode, String city, Integer number) {
        this.setZipCode(zipCode);
        this.setCity(city);
        this.setNumber(number);
    }

    @Override
    public String toString() {
        return "Address{" +
                "zipCode='" + getZipCode() + '\'' +
                ", city='" + getCity() + '\'' +
                ", number=" + getNumber() +
                '}';
    }


    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
