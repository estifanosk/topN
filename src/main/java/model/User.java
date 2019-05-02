package model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User implements Comparable<User> {

    private String id;
    private String name;
    private int age;
    private String number;
    private String photo;

    Pattern pattern = Pattern.compile("^\\(?([0-9]{3})\\)?[-. ]?([0-9]{3})[-. ]?([0-9]{4})");

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public boolean isNumberValid() {
        Matcher matcher = pattern.matcher(this.number);
        if (matcher.matches()) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("Id:%s Name:%s Age:%s Number:%s Photo:%s", this.id, this.name, this.age, this.number, this.photo);
    }

    @Override
    public int compareTo(User that) {
        return this.getName().compareTo(that.getName());
    }
}
