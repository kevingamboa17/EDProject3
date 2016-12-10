package model;


public class Tweet {
    long id;
    String text;
    User user;

    public Tweet(String text, String user) {
        this.text = text;
        this.user = new User(user);
    }

    public String getText() {
        return text;
    }

    public User getUser() {
        return user;
    }

    @Override
    public String toString() {
        return text + " - " + "@"  + user.screen_name;
}
}
