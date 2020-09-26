package patterns.behavioural;

import java.util.ArrayList;
import java.util.List;

/*
 * Observer.
 * Define a one-to-many dependency between objects
 * so that when one object changes state,
 * all its dependents are notified and updated automatically.
 */

// Observer - - - - - - - - - - - - - - -
abstract class Observer {
	public abstract void Update();
}

class ConcreteObserver extends Observer {
	public int state;
	private ConcreteSubject subject;

	ConcreteObserver(ConcreteSubject s) {
		subject = s;
		subject.Attach(this);
	}

	@Override
	public void Update() {
		this.state = subject.GetState();
	}
}

// Subject - - - - - - - - - - - - - -
abstract class Subject {
	private List<Observer> observers = new ArrayList<Observer>();

	public void Attach(Observer obs) {
		observers.add(obs);
	}

	public void Detach(Observer obs) {
		observers.remove(obs);
	}

	public void Notify() {// tells observers a package has arrived
		for (Observer observer : observers) {
			observer.Update();// observers fetch the package
		}
	}
}

class ConcreteSubject extends Subject {
	private int state;

	public int GetState() {
		return state;
	}

	public void SetState(int s) {
		this.state = s;
		Notify();
	}
}

// MAIN - - - - - - - -
public class ObserverDemo {
	public static void main(String[] args) {
		ConcreteSubject sub = new ConcreteSubject();
		ConcreteObserver obs = new ConcreteObserver(sub);
		System.out.println(obs.state);
		sub.SetState(5);
		System.out.println(obs.state);
	}
}
