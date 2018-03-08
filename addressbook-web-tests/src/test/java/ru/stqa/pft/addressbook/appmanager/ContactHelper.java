package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
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
    
    public void fillContactForm(ContactData contactData, boolean creation){
        type(By.name("firstname"), contactData.getFirstName());
        type(By.name("lastname"), contactData.getLastName());
        type(By.name("address"), contactData.getAddress());
        type(By.name("mobile"), contactData.getTelephoneMobile());
        type(By.name("work"), contactData.getTelephoneWork());

        if(creation){
            WebElement selectElement = wd.findElement(By.name("new_group"));
            Select listBox = new Select(selectElement);
            int size_listbox = listBox.getOptions().size();
            System.out.println("size listbox: " + size_listbox);
            if(size_listbox > 1) {
                listBox.selectByVisibleText(contactData.getGroup());
            }
        } else{
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }
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

    public void createContact(ContactData contactData, boolean creation) {
        initContactCreation();
        fillContactForm(contactData, creation);
        submitContactCreation();
        returnToContactPage();
    }

    public boolean isThereAContact() {
        return isElementPresent(By.cssSelector("img[title=\"Edit\"]"));
    }
}
