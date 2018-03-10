package ru.stqa.pft.addressbook.model;

import java.util.Objects;

/**
 * Класс содержит информацию о контакте
 *
 * @author Evgeniy
 * @version 1.0.0
 */
public class ContactData {
    private int id = Integer.MAX_VALUE;
    private String firstName;
    private String lastName;
    private String address;

    private String telephoneMobile;
    private String telephoneWork;
    private String group;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getTelephoneMobile() {
        return telephoneMobile;
    }

    public String getTelephoneWork() {
        return telephoneWork;
    }

    public String getGroup() {
        return group;
    }

    public int getId() {
        return id;
    }

    //
    public ContactData withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public ContactData withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public ContactData withAddress(String address) {
        this.address = address;
        return this;
    }

    public ContactData withTelephoneMobile(String telephoneMobile) {
        this.telephoneMobile = telephoneMobile;
        return this;
    }

    public ContactData withTelephoneWork(String telephoneWork) {
        this.telephoneWork = telephoneWork;
        return this;
    }

    public ContactData withGroup(String group) {
        this.group = group;
        return this;
    }

    public ContactData withId(int id) {
        this.id = id;
        return this;
    }

    @Override
    public String toString() {
        return "ContactData{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", telephoneMobile='" + telephoneMobile + '\'' +
                ", telephoneWork='" + telephoneWork + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactData that = (ContactData) o;
        return id == that.id &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(address, that.address);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, firstName, lastName, address);
    }
}
