package ru.stqa.pft.addressbook.test.contacts;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.test.TestBase;

import java.util.List;
import java.util.Set;

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
        Set<ContactData> before = app.contact().all();
        ContactData delContact = before.iterator().next();
        app.contact().delete(delContact);
        Set<ContactData> after = app.contact().all();
        Assert.assertEquals(after.size(), before.size() -1);
        before.remove(delContact);
        Assert.assertEquals(before, after);
    }
}
