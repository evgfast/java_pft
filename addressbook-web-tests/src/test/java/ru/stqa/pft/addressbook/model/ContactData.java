package ru.stqa.pft.addressbook.model;

/**
 * Класс содержит информацию о контакте
 *
 * @author Evgeniy
 * @version 1.0.0
 */
public class ContactData {
    private String firstName;
    private String lastName;
    private String address;

    private String telephoneMobile;
    private String telephoneWork;
    private String group;

    public ContactData(String firstName, String lastName, String address,
                       String telephoneMobile, String telephoneWork, String group) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.telephoneMobile = telephoneMobile;
        this.telephoneWork = telephoneWork;
        this.group = group;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephoneMobile() {
        return telephoneMobile;
    }

    public void setTelephoneMobile(String telephoneMobile) {
        this.telephoneMobile = telephoneMobile;
    }

    public String getTelephoneWork() {
        return telephoneWork;
    }

    public void setTelephoneWork(String telephoneWork) {
        this.telephoneWork = telephoneWork;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }
}
