package ObserverDesignPattern.notifyMe.Observer;

import ObserverDesignPattern.notifyMe.Observerable.StockObservable;

public class PhoneAlertObserver implements NotificationAlertObserver {

	StockObservable stockObservable;
	String phoneNumber;
	public PhoneAlertObserver(String phoneNumber,StockObservable stockObservable) {
		// TODO Auto-generated constructor stub
		this.phoneNumber = phoneNumber;
		this.stockObservable = stockObservable;
	}
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		notifyOnPhone(phoneNumber, "Product is in stock hurry up !!");
	}
	
	public void notifyOnPhone(String phone, String msg) {
		System.out.println("Notified on phone: "+phone);
	}

}
