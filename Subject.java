import java.util.ArrayList;
import java.util.List;

public class Subject {
    private List<Observer> observers = new ArrayList<>();
    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        notifyObservers();
    }

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void detach(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}

public abstract class Observer {
    protected Subject subject;

    public Observer(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    public abstract void update();
}

public class BinaryObserver extends Observer {
    public BinaryObserver(Subject subject) {
        super(subject);
    }

    public void update() {
        System.out.println("Binary string: " + Integer.toBinaryString(subject.getState()));
    }
}

public class OctalObserver extends Observer {
    public OctalObserver(Subject subject) {
        super(subject);
    }

    public void update() {
        System.out.println("Octal string: " + Integer.toOctalString(subject.getState()));
    }
}

public class HexObserver extends Observer {
    public HexObserver(Subject subject) {
        super(subject);
    }

    public void update() {
        System.out.println("Hex string: " + Integer.toHexString(subject.getState()));
    }
}
