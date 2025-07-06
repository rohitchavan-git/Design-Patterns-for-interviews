package prototype;

public class Sample {
    public static void main(String[] args) {
        User user = new User("Rohit","Chavan");
        User clone = (User) user.clone();

        System.out.println("original Obj :"+user);
        System.out.println("prototype Obj :"+clone);
    }
}
