package model;

public class User {
    long id;
    String screen_name; 

    public User(String screen_name) {
        this.screen_name = screen_name;
    }

    public String getScreen_name() {
        return screen_name;
    }
    
    
}
