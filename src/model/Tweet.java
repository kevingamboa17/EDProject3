package model;

<<<<<<< HEAD

=======
>>>>>>> 82e59dd7b09e22078d3dec8184843f0b2ce7c008
public class Tweet {
    long id;
    String text;
    User user;
<<<<<<< HEAD
    int priority;

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
=======
>>>>>>> 82e59dd7b09e22078d3dec8184843f0b2ce7c008

    
    
    @Override
    public String toString() {
<<<<<<< HEAD
        return text + " - " + "@"  + user.screen_name;
    }
=======
        return  text + " - " +  "@" + user.screen_name;
    }

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

    
>>>>>>> 82e59dd7b09e22078d3dec8184843f0b2ce7c008
    
}
