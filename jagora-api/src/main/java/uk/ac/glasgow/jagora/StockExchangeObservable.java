package uk.ac.glasgow.jagora;

public interface StockExchangeObservable {
	public void registerObserver(TraderObserver o);
	public void removeObserver(TraderObserver o);
	public void notifyObservers();
	

}
