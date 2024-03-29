package org.example.infrastructure;

import org.example.model.Car;

public interface IDataQueue {
    public void add(Car model) throws InterruptedException;
    public Car get() throws InterruptedException;
}
