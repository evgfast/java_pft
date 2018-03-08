package ru.stqa.pft.addressbook.test.contacts;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.test.TestBase;

public class ContactModificationTest extends TestBase {
    @Test
    public void testContactModification() {
        app.getNavigationHelper().gotoContactPage();
        if (!app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData("ole",
                    null,
                    null,
                    null,
                    null,
                    null), true);
        }
        app.getContactHelper().initContactModification();
        app.getContactHelper().fillContactForm(
                new ContactData("boris_modify",
                        "britva_modify",
                        "Moscow street modify",
                        "80000008",
                        "000000", null), false);
        app.getContactHelper().submitContactModification();
        app.getContactHelper().returnToContactPage();
    }
}
