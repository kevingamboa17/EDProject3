package model;


public class Tweet {
    long id;
    String text;
    User user;
    int priority;

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    
    
    @Override
    public String toString() {
        return text + " - " + "@"  + user.screen_name;
    }
    
}
