package ru.stqa.pft.addressbook.test.contacts;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.test.TestBase;

public class ContactDeletionTest extends TestBase {
    @Test
    public void testGroupDeletion() {
        app.getNavigationHelper().gotoContactPage();
        if (!app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData("ole",
                    null,
                    null,
                    null,
                    null,
                    null), true);
        }
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteSelectContact();
        app.getContactHelper().returnToContactPage();
    }
}
