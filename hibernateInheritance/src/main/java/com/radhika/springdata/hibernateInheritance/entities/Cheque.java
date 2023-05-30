package com.radhika.springdata.hibernateInheritance.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "cheque")
@PrimaryKeyJoinColumn(name = "id")
//@DiscriminatorValue("ch")
public class Cheque extends Payment{
    private String chequenumber;

    public String getChequeNumber() {
        return chequenumber;
    }

    public void setChequeNumber(String chequenumber) {
        this.chequenumber = chequenumber;
    }
}
