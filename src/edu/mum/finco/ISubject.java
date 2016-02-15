package edu.mum.finco;

public interface ISubject<T> {

	void attach(IObserver<T> observer);
    
    public void notifyObservers();

}