package ru.stqa.pft.addressbook.test.contacts;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.test.TestBase;

import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.testng.Assert.assertEquals;

public class ContactDeletionTest extends TestBase {
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
    public void testGroupDeletion() {
        Contacts before = app.contact().all();
        ContactData delContact = before.iterator().next();
        app.contact().delete(delContact);
        Contacts after = app.contact().all();
        assertEquals(after.size(), before.size() - 1);
        assertThat(after, equalTo(before.without(delContact)));
    }
}
