package ru.stqa.pft.addressbook.model;

/**
 * Класс содержит информацию о группе
 * @author Evgeniy
 * @version 1.0.0
 */
public class GroupData {
    private final String name;
    private final String header;
    private final String footer;

    public GroupData(String name, String header, String footer) {
        this.name = name;
        this.header = header;
        this.footer = footer;
    }

    public String getName() {
        return name;
    }

    public String getHeader() {
        return header;
    }

    public String getFooter() {
        return footer;
    }
}
