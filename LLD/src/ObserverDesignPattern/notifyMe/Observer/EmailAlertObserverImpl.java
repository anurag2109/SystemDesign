package ObserverDesignPattern.notifyMe.Observer;

import ObserverDesignPattern.notifyMe.Observerable.StockObservable;

public class EmailAlertObserverImpl implements NotificationAlertObserver {

	String email;
	StockObservable observable;
	
	public EmailAlertObserverImpl(String email, StockObservable observable) {
		// TODO Auto-generated constructor stub
		this.email = email;
		this.observable = observable;
	}
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		sendEmail(email, "Product is in stock hurry up !!");
	}
	
	public void sendEmail(String email, String msg) {
		System.out.println("Mail sent to: "+ email);
	}

}
