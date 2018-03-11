package ru.stqa.pft.addressbook.test.contacts;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.test.TestBase;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class ContactCreationTest extends TestBase {
    @Test
    public void testContactCreation() {
        app.goTo().contactPage();
        Contacts before = app.contact().all();
        ContactData contact = new ContactData().withFirstName("boris")
                .withLastName("britva")
                .withAddress("Moscow street 0")
                .withTelephoneMobile("89602671788")
                .withTelephoneWork("555666")
                .withGroup("test1");
        app.contact().createContact(contact, true);
        Contacts after = app.contact().all();
        Assert.assertEquals(after.size(), before.size() + 1);
        assertThat(after, equalTo(
                before.withAdded(contact.withId(
                        after.stream().mapToInt( (c) -> c.getId() ).max().getAsInt()))));
        assertThat(after.size(), equalTo(before.size() + 1));
    }
}
