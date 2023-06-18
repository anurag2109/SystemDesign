package ObserverDesignPattern.notifyMe.Observerable;

import ObserverDesignPattern.notifyMe.Observer.NotificationAlertObserver;

public interface StockObservable {

	public void add(NotificationAlertObserver observer);
	public void remove(NotificationAlertObserver observer);
	public void notifySubscriber();
	public void setStockCount(int newStock);
	public int getStockCount();
}
