package ru.stqa.pft.addressbook.test.group;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.test.TestBase;

public class GroupDeletionTest extends TestBase {
    @Test
    public void testGroupDeletion(){
        app.getNavigationHelper().gotoGroupPage();
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().deleteSelectedGroups();
        app.getGroupHelper().returnToGroupPage();
    }

}
