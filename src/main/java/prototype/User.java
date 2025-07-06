package prototype;


interface Prototype {
    Prototype clone();
}

public class User implements Prototype{
    private final String fname;
    private final String lname;

    public User(String fname , String lname) {
        this.fname = fname;
        this.lname = lname;
    }
    private User(User user){
        this.fname=user.fname;
        this.lname= user.lname;
    }


    @Override
    public Prototype clone() {
        return new User(this);
    }

    @Override
    public String toString() {
        return fname+" "+lname;
    }
}
