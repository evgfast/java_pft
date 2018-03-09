package ru.stqa.pft.addressbook.test.contacts;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.test.TestBase;

import java.util.HashSet;
import java.util.List;

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
        ContactData contact = new ContactData()
                .withFirstName("Boris_mod")
                .withLastName("Britva_mod")
                .withAddress("Moscow street mod")
                .withTelephoneMobile("8000008")
                .withTelephoneWork("555-000")
                .withGroup("test1");
        List<ContactData> before = app.contact().list();
        int index = before.size() - 1;
        app.contact().modify(contact, index);
        List<ContactData> after = app.contact().list();
        Assert.assertEquals(after.size(), before.size());
        before.remove(index);
        before.add(contact);
        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
    }
}
