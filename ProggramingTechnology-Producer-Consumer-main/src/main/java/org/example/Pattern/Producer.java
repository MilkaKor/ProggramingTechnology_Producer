package org.example.Pattern;

import org.example.model.Car;

import java.util.List;
import java.util.Random;

public class Producer implements Runnable {
    private final DataQueue dataQueue;
    private int counter = 0;
    private final Random random;

    private final List<String> names = List.of("Желтый","Голубой","Розовый");

    public Producer(DataQueue dataQueue) {this.dataQueue = dataQueue; random = new Random();}
    @Override
    public void run() {
        produce();
    }

    private void produce(){
        try{
            while(true){
                counter++;
                dataQueue.add(generateCar());
                System.out.println("Машина поехала, ее id: " + counter);
                Thread.sleep(200);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private Car generateCar() {
        return new Car(counter,
                random.nextInt(300) + 1, // Генерация случайной скорости от 1 до 300 км/ч
                names.get(random.nextInt(0, 2)),
                random.nextInt(10, 30)  // Генерация номера от 10 до 30 кг
        );
    }
}
