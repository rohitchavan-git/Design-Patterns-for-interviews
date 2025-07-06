package singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

class Singleton1 {

    private Singleton1(){}

    private final static Singleton1 instance=new Singleton1();

    public static Singleton1 getInstance() {
        return instance;
    }
}

class Singleton2{

    private static Singleton2 instance;

    private Singleton2(){}

    public static Singleton2 getInstance() {
        if(instance == null){
            instance = new Singleton2();
        }
        return instance;
    }
}

class Singleton3{

    private static Singleton3 instance;

    private Singleton3(){}
    public synchronized static Singleton3 getInstance() {
        if(instance == null){
            instance = new Singleton3();
        }
        return instance;
    }
}

class Singleton4{

    private volatile static Singleton4 instance;

    private Singleton4(){}

    public static Singleton4 getInstance() {

        if(instance == null){
            synchronized (Singleton4.class){
                if(instance == null){
                    instance = new Singleton4();
                }
            }
        }
        return instance;
    }
}


class Singleton5{

    private static  boolean instanceCreated=false;

     static class  SingletonHolder {
        private static final Singleton5 singleton5 = new Singleton5();
    }
    private Singleton5(){
         if (instanceCreated){
             throw new RuntimeException("instance is already created .");
         }
         instanceCreated=true;
    }

    public static Singleton5 getInstance() {
        return SingletonHolder.singleton5;
    }
}



public class Simple {

    public static void main(String[] args) throws InterruptedException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        Runnable task = ()->{
            Singleton1 instance = Singleton1.getInstance();
            System.out.println("singleton1 instance" + instance);
        };
        Thread thread= new Thread(task);
        Thread thread1=new Thread(task);
        thread.start();
        thread1.start();

        Runnable task1 = ()->{
            Singleton2 instance = Singleton2.getInstance();
            System.out.println("singleton2 instance" + instance);
        };
        Thread thread2= new Thread(task1);
        Thread thread3=new Thread(task1);
        thread2.start();
        thread3.start();

        Runnable task2 = ()->{
            Singleton3 instance = Singleton3.getInstance();
            System.out.println("singleton3 instance" + instance);
        };
        Thread thread4= new Thread(task2);
        Thread thread5=new Thread(task2);
        thread4.start();
        thread5.start();

        Runnable task3 = ()->{
            Singleton4 instance = Singleton4.getInstance();
            System.out.println("singleton4 instance" + instance);
        };
        Thread thread6= new Thread(task3);
        Thread thread7=new Thread(task3);
        thread6.start();
        thread7.start();

        Runnable task4 = ()->{
            Singleton5 instance = Singleton5.getInstance();
            System.out.println("singleton5 instance" + instance);
        };
        Thread thread8= new Thread(task4);
        Thread thread9=new Thread(task4);
        thread8.start();
        thread9.start();


        Singleton5 in= Singleton5.getInstance();

        Constructor<Singleton5> declaredConstructor = Singleton5.class.getDeclaredConstructor();

        declaredConstructor.setAccessible(true);
        Singleton5 singleton5 = declaredConstructor.newInstance();

        System.out.println("reflection break singleton instance 1 " + in + " instance 2 " + singleton5);

        thread.join();
        thread1.join();
        thread2.join();
        thread3.join();
        thread4.join();
        thread5.join();
        thread6.join();
        thread7.join();
        thread8.join();
        thread9.join();





    }
}
