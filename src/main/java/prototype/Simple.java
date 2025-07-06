package prototype;

public class Simple {
    public static void main(String[] args) {
        User user = new User("Rohit","Chavan");
        User clone = (User) user.clone();

        System.out.println("original Obj :"+user);
        System.out.println("prototype Obj :"+clone);
    }
}
