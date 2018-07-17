package ua.kpi.tef2.model;

public class User {

    private String name;

    private String lastName;

    private String email;

    private String phoneNumber;

    private String comment;

    public User() {
    }

    public User(String name, String lastName, String email, String phoneNumber) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }

        User user = (User) obj;

        return user.getName().equals(getName()) && user.getLastName().equals(getLastName()) &&
                user.getEmail().equals(getEmail()) &&
                user.getPhoneNumber().equals(getPhoneNumber());

    }

    @Override
    public int hashCode() {
        return (((name.hashCode() * 31) + lastName.hashCode()) * 31 + email.hashCode())
                * 31 + phoneNumber.hashCode();
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
