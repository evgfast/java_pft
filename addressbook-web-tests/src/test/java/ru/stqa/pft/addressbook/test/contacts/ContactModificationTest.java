package ru.stqa.pft.addressbook.test.contacts;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.test.TestBase;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ContactModificationTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().contactPage();
        if (!app.contact().isThereAContact()) {
            app.contact().createContact(
                    new ContactData()
                            .withFirstName("oleg")
                            .withLastName("frans")
                            .withGroup("test1"), true);
        }
    }

    @Test
    public void testContactModification() {
        Set<ContactData> before = app.contact().all();
        ContactData modifyContact = before.iterator().next();
        ContactData contact = new ContactData()
                .withId(modifyContact.getId())
                .withFirstName("Boris_mod")
                .withLastName("Britva_mod")
                .withAddress("Moscow street mod")
                .withTelephoneMobile("8000008")
                .withTelephoneWork("555-000")
                .withGroup("test1");
        app.contact().modify(contact);
        Set<ContactData> after = app.contact().all();
        Assert.assertEquals(after.size(), before.size());
        before.remove(modifyContact);
        before.add(contact);
        Assert.assertEquals(before, after);
    }
}
