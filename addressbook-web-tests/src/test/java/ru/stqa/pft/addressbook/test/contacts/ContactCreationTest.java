package ru.stqa.pft.addressbook.test.contacts;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.test.TestBase;

import java.util.HashSet;
import java.util.List;

public class ContactCreationTest extends TestBase {
    @Test
    public void testContactCreation() {
        app.goTo().contactPage();
        List<ContactData> before = app.contact().list();
        ContactData contact = new ContactData().withFirstName("boris").withLastName("britva")
                .withAddress("Moscow street 0")
                .withTelephoneMobile("89602671788")
                .withTelephoneWork("555666")
                .withGroup("test1");
        app.contact().createContact(contact, true);
        List<ContactData> after = app.contact().list();
        Assert.assertEquals(after.size(), before.size() + 1);
        before.add(contact);
        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
    }
}
