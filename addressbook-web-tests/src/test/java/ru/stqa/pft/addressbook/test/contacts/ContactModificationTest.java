package ru.stqa.pft.addressbook.test.contacts;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
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
        Contacts before = app.contact().all();
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
        Contacts after = app.contact().all();
        Assert.assertEquals(before.size(), after.size());
        MatcherAssert.assertThat(after, CoreMatchers.equalTo(before.without(modifyContact).withAdded(contact)));
    }
}
