package org.example.Pattern;
//Реализация получателя
public class Consumer implements Runnable {
    private final DataQueue dataQueue;
    private final String name;
    public Consumer(DataQueue dataQueue, String name) {
        this.dataQueue = dataQueue; this.name = name;
    }

    @Override
    public void run() {
        consume();
    }
    private void consume(){
        try{
            while(true){
                var value = dataQueue.get();
                System.out.println("Проехала машина: " + "|" + name + "| " + value.toString());
                Thread.sleep(2000);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
