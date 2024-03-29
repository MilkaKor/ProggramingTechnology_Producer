package org.example;

import org.example.Pattern.Consumer;
import org.example.Pattern.DataQueue;
import org.example.Pattern.Producer;

public class Main {
    public static void main(String[] args) {
        int size = 10;
        DataQueue dataQueue = new DataQueue(size);

        Producer producer = new Producer(dataQueue);
        Thread producerThread = new Thread(producer);
        producerThread.start();

        for (int i = 1; i < 6; i++){
            Consumer consumer = new Consumer(dataQueue,"Машина: " + i);
            Thread consumerThread = new Thread(consumer);
            consumerThread.start();
        }

    }
}