package org.example.Pattern;

import org.example.model.Car;

import java.util.LinkedList;
import java.util.Queue;
public class DataQueue {
    private final Queue<Car> list;
    private final int maxSize;

    public DataQueue(int maxSize)
    {
        list = new LinkedList<>();
        this.maxSize = maxSize;
    }

    public void add(Car model) throws InterruptedException {
        synchronized (this){
            while (list.size() >= maxSize){
                System.out.println("Кольцо заполнено");
                wait();
            }
            list.add(model);
            notify();
        }
    }

    public Car get() throws InterruptedException{
        synchronized (this){
            while(list.isEmpty()){
                System.out.println("Кольцо свободно");
                wait();
            }
            var result = list.poll();
            notify();
            return result;
        }
    }

}
