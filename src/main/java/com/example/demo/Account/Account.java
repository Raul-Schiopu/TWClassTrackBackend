package com.example.demo.Account;

public abstract class Account {

    private String firstName;
    private String lastName;

    private String password;

    private String memberCode;

    public Account(){

    }

    public Account(String firstName, String lastName, String password, String memberCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.memberCode = memberCode;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMemberCode() {
        return memberCode;
    }

    public void setMemberCode(String memberCode) {
        this.memberCode = memberCode;
    }

    @Override
    public String toString() {
        String returnString = "Account{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                ", memberCode='" + memberCode + '\'';
        return returnString;
    }
}
