/*Luca Danilo Melis 65468*/

package com.example.esercitazione00;

import java.io.Serializable;

public class Person implements Serializable {

    private String name, password, citta, birthDate;

    public Person(){
        this.setName("");
        this.setCitta("");
        this.setPassword("");
        this.setBirthDate("");
    }

    public Person(String name, String password, String citta, String bithDate){
        this.name = name;
        this.password = password;
        this.citta = citta;
        this.birthDate = bithDate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }
}
