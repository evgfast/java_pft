package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    public void selectContactById(int id) {
        wd.findElement(By.cssSelector("input[id='" + id + "']")).click();
    }


    public void deleteSelectContact() {
        click(By.cssSelector("input[value=\"Delete\"]"));
        wd.switchTo().alert().accept();
    }

    public void initContactModification(int id) {
        wd.findElement(By.xpath("//td/input[@id='" + id + "']/following::td[7]//a")).click();
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

    public void delete(ContactData contact) {
        selectContactById(contact.getId());
        deleteSelectContact();
        returnToContactPage();
    }

    public void modify(ContactData contact, int index) {
        initContactModification(index);
        fillContactForm(contact, false);
        submitContactModification();
        returnToContactPage();
    }

    public void modify(ContactData contact) {
        initContactModification(contact.getId());
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
            int id = Integer.parseInt(element.findElement(By.xpath("td[1]/input[@name=\"selected[]\"]")).getAttribute("id"));
            String lastname = element.findElement(By.xpath("td[2]")).getText();
            String firstname = element.findElement(By.xpath("td[3]")).getText();
            String address = element.findElement(By.xpath("td[4]")).getText();
            String allEmail = element.findElement(By.xpath("td[5]")).getText();
            String allPhone = element.findElement(By.xpath("td[6]")).getText();
            ContactData contact = new ContactData().withId(id).withFirstName(firstname)
                    .withLastName(lastname)
                    .withAddress(address);

            contacts.add(contact);
        }
        return contacts;
    }

    public Set<ContactData> allSet() {
        Set<ContactData> contacts = new HashSet<>();
        List<WebElement> elements = wd.findElements(By.xpath("//tr[@name=\"entry\"]"));
        for (WebElement element : elements) {
            int id = Integer.parseInt(element.findElement(By.xpath("td[1]/input[@name=\"selected[]\"]")).getAttribute("id"));
            String lastname = element.findElement(By.xpath("td[2]")).getText();
            String firstname = element.findElement(By.xpath("td[3]")).getText();
            String address = element.findElement(By.xpath("td[4]")).getText();
            String allEmail = element.findElement(By.xpath("td[5]")).getText();
            String allPhone = element.findElement(By.xpath("td[6]")).getText();


            contacts.add(new ContactData().withId(id).
                    withFirstName(firstname)
                    .withLastName(lastname)
                    .withAddress(address));
        }
        return contacts;
    }


    public Contacts all() {
        Contacts contacts = new Contacts();
        List<WebElement> elements = wd.findElements(By.xpath("//tr[@name=\"entry\"]"));
        for (WebElement element : elements) {
            int id = Integer.parseInt(element.findElement(By.xpath("td[1]/input[@name=\"selected[]\"]")).getAttribute("id"));
            String lastname = element.findElement(By.xpath("td[2]")).getText();
            String firstname = element.findElement(By.xpath("td[3]")).getText();
            String address = element.findElement(By.xpath("td[4]")).getText();
            String allEmail = element.findElement(By.xpath("td[5]")).getText();
            String allPhone = element.findElement(By.xpath("td[6]")).getText();

            contacts.add(new ContactData().withId(id).
                    withFirstName(firstname)
                    .withLastName(lastname)
                    .withAddress(address));
        }
        return contacts;
    }

}
