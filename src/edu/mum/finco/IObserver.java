package edu.mum.finco;

public interface IObserver<T> {

    public void update(T obj);

}