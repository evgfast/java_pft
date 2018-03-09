package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase {
    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void returnToContactPage() {
        click(By.linkText("home"));
    }

    public void submitContactCreation() {
        click(By.name("submit"));
    }

    public void fillContactForm(ContactData contactData, boolean creation) {
        type(By.name("firstname"), contactData.getFirstName());
        type(By.name("lastname"), contactData.getLastName());
        type(By.name("address"), contactData.getAddress());
        type(By.name("mobile"), contactData.getTelephoneMobile());
        type(By.name("work"), contactData.getTelephoneWork());

        if (creation) {
            WebElement selectElement = wd.findElement(By.name("new_group"));
            Select listBox = new Select(selectElement);
            int size_listbox = listBox.getOptions().size();
            if (size_listbox > 1) {
                click(By.name("new_group"));
                System.out.println("contactData.getGroup(): " + contactData.getGroup());
                listBox.selectByVisibleText(contactData.getGroup());
            }
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }
    }

    public void initContactCreation() {
        click(By.linkText("add new"));
    }

    public void selectContact(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();
    }


    public void deleteSelectContact() {
        click(By.cssSelector("input[value=\"Delete\"]"));
        wd.switchTo().alert().accept();
    }

    public void initContactModification(int index) {
        wd.findElements(By.cssSelector("img[title=\"Edit\"]")).get(index).click();
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

    public void delete(int index) {
        selectContact(index);
        deleteSelectContact();
        returnToContactPage();
    }

    public void modify(ContactData contact, int index) {
        initContactModification(index);
        fillContactForm(contact, false);
        submitContactModification();
        returnToContactPage();
    }

    public boolean isThereAContact() {
        return isElementPresent(By.cssSelector("img[title=\"Edit\"]"));
    }

    public List<ContactData> list() {
        List<ContactData> contacts = new ArrayList<ContactData>();
        List<WebElement> elements = wd.findElements(By.xpath("//tr[@name=\"entry\"]"));
        for (WebElement element : elements) {
            String lastname = element.findElement(By.xpath("td[2]")).getText();
            String firstname = element.findElement(By.xpath("td[3]")).getText();
            String address = element.findElement(By.xpath("td[4]")).getText();
            String allEmail = element.findElement(By.xpath("td[5]")).getText();
            String allPhone = element.findElement(By.xpath("td[6]")).getText();
            ContactData contact = new ContactData().withFirstName(firstname)
                    .withLastName(lastname)
                    .withAddress(address);

            contacts.add(contact);
        }
        return contacts;
    }
}
