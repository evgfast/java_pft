package ru.stqa.pft.addressbook.test.contacts;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.test.TestBase;

public class ContactCreationTest extends TestBase {
    @Test
    public void testContactCreation() {
        app.getNavigationHelper().gotoContactPage();
        app.getContactHelper().initContactCreation();
        app.getContactHelper().fillContactForm(
                new ContactData("boris",
                        "britva",
                        "Moscow street 0",
                        "89602671788",
                        "555666"));
        app.getContactHelper().submitContactCreation();
        app.getContactHelper().returnToContactPage();
    }
}
