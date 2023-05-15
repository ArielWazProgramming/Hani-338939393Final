class Singleton {
    private static Singleton instance;

    private Singleton() {
        // private constructor to prevent instantiation from outside the class
    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    public void showMessage() {
        System.out.println("Hello World!");
    }
}

public class Main {
    public static void main(String[] args) {
        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();

        if (instance1 == instance2) {
            System.out.println("Both instances are the same.");
        }

        instance1.showMessage();
    }
}
