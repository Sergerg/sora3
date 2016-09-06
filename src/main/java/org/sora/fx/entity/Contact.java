package org.sora.fx.entity;

import javafx.beans.property.SimpleStringProperty;

/**
 * Created with IntelliJ IDEA.
 * User: Serger
 * Date: 08.09.2015
 * Time: 7:41
 */
public class Contact {
    private final SimpleStringProperty nick;
    private final SimpleStringProperty name;
    private final SimpleStringProperty email;
    private final SimpleStringProperty phone;

    public Contact(String nick, String name, String email, String phone) {
        this.nick = new SimpleStringProperty(nick);
        this.name = new SimpleStringProperty(name);
        this.email = new SimpleStringProperty(email);
        this.phone = new SimpleStringProperty(phone);
    }

    public String getNick() {
        return nick.get();
    }
    public void setNick(String nick) {
        this.nick.set(nick);
    }

    public String getName() {
        return name.get();
    }
    public void setName(String name) {
        this.name.set(name);
    }

    public String getEmail() {
        return email.get();
    }
    public void setEmail(String email) {
        this.email.set(email);
    }

    public String getPhone() {
        return phone.get();
    }
    public void setPhone(String phone) {
        this.phone.set(phone);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Contact contact = (Contact) o;

        return nick.getName().equals(contact.nick.getName());
    }

    @Override
    public int hashCode() {
        return nick.hashCode();
    }

    @Override
    public String toString() {
        return "Contact{" +
                "nick='" + nick + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

}
