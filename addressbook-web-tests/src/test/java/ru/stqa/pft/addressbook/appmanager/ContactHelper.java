package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactHelper extends HelperBase{
    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void returnToContactPage(){
        click(By.linkText("home"));
    }
    
    public void submitContactCreation(){
        click(By.name("submit"));
    }
    
    public void fillContactForm(ContactData contactData){
        type(By.name("firstname"), contactData.getFirstName());
        type(By.name("lastname"), contactData.getLastName());
        type(By.name("address"), contactData.getAddress());
        type(By.name("mobile"), contactData.getTelephoneMobile());
        type(By.name("work"), contactData.getTelephoneWork());
    }

    public void initContactCreation() {
        click(By.linkText("add new"));
    }

    public void selectContact(){
        click(By.name("selected[]"));
    }

    public void deleteSelectContact(){
        click(By.cssSelector("input[value=\"Delete\"]"));
        wd.switchTo().alert().accept();
    }

    public void initContactModification() {
        click(By.cssSelector("img[title=\"Edit\"]"));
    }

    public void submitContactModification() {
        click(By.name("update"));
    }
}
