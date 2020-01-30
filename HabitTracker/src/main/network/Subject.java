//package network;
//
//
//import model.habit.Habit;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class Subject {
//    protected List<Observer> observers;
//
//    public Subject() {
//        observers = new ArrayList<>();
//    }
//
//    public void addObserver(Observer observer) {
//        if (!observers.contains(observer)) {
//            observers.add(observer);
//        }
//    }
//
//    public void notifyObservers(Habit h) {
//        for (Observer o : observers) {
//            o.update(h);
//        }
//    }
//}
