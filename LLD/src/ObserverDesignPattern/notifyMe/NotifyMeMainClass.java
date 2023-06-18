package ObserverDesignPattern.notifyMe;

import ObserverDesignPattern.notifyMe.Observer.EmailAlertObserverImpl;
import ObserverDesignPattern.notifyMe.Observer.NotificationAlertObserver;
import ObserverDesignPattern.notifyMe.Observer.PhoneAlertObserver;
import ObserverDesignPattern.notifyMe.Observerable.IphoneObservableImpl;
import ObserverDesignPattern.notifyMe.Observerable.StockObservable;

public class NotifyMeMainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StockObservable iphoneObservable = new IphoneObservableImpl();
		NotificationAlertObserver observer1 = new EmailAlertObserverImpl("anurag.kam@zee.com", iphoneObservable);
		NotificationAlertObserver observer2 = new EmailAlertObserverImpl("xyz@gmail.com", iphoneObservable);
		NotificationAlertObserver observer3 = new PhoneAlertObserver("9627727878", iphoneObservable);
		
		iphoneObservable.add(observer1);
		iphoneObservable.add(observer2);
		iphoneObservable.add(observer3);
		
		iphoneObservable.setStockCount(100);
	}

}
