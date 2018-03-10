package ru.stqa.pft.addressbook.test.contacts;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.test.TestBase;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ContactCreationTest extends TestBase {
    @Test
    public void testContactCreation() {
        app.goTo().contactPage();
        Set<ContactData> before = app.contact().all();
        ContactData contact = new ContactData().withFirstName("boris")
                .withLastName("britva")
                .withAddress("Moscow street 0")
                .withTelephoneMobile("89602671788")
                .withTelephoneWork("555666")
                .withGroup("test1");
        app.contact().createContact(contact, true);
        Set<ContactData> after = app.contact().all();
        Assert.assertEquals(after.size(), before.size() + 1);
        contact.withId(after.stream().mapToInt( (c) -> c.getId()).max().getAsInt());
        before.add(contact);
        Assert.assertEquals(before, after);
    }
}
