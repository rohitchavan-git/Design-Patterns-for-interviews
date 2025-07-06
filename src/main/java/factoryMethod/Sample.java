package factoryMethod;

enum BuggerType{
    CHESS, VEGAN, DELUXE_CHESS,DELUXE_VEGAN;
}

abstract  class Bugger{
    abstract void doSomething();
}
class ChessBugger extends Bugger{
    @Override
    void doSomething() {
        System.out.println("Do something chess");
    }
}

class VeganBugger extends Bugger{
    @Override
    void doSomething() {
        System.out.println("Do something vegan");
    }
}

class DeluxeBugger extends Bugger{
    @Override
    void doSomething() {
        System.out.println("Do something deluxe Chess");
    }
}
class DeluxeVegan extends Bugger{
    @Override
    void doSomething() {
        System.out.println("Do something deluxe vegan");
    }
}


@FunctionalInterface
interface BuggerStore {

    Bugger createBugger(BuggerType type);

    default  Bugger orderBugger(BuggerType type){
        Bugger bugger = createBugger(type);
        if (bugger != null) {
            bugger.doSomething();
        }else{
            System.out.println("sorry we dont serve " + type.name() + " buggers");
        }
        return bugger;
    }
}

class ChessStore implements BuggerStore {

    @Override
    public Bugger createBugger(BuggerType type) {
        if (type == BuggerType.CHESS) {
            return new ChessBugger();
        }else if (type == BuggerType.DELUXE_CHESS){
            return new DeluxeBugger();
        }
        return null;
    }
}

class VeganStore implements BuggerStore{

    @Override
    public Bugger createBugger(BuggerType type) {
        if (type == BuggerType.VEGAN){
            return new VeganBugger();
        }else if (type == BuggerType.DELUXE_VEGAN){
            return new DeluxeVegan();
        }
        return null;
    }
}

public class Simple {

    public static void orderBuggerFrom(BuggerStore buggerStore,BuggerType type){
        buggerStore.orderBugger(type);
    }

    public static void main(String[] args) {

        orderBuggerFrom(new ChessStore(),BuggerType.CHESS);
        orderBuggerFrom(new ChessStore(),BuggerType.VEGAN);

        //
    }
}
