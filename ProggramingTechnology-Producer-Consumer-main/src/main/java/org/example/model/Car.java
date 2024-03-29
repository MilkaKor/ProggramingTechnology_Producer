package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Arrays;
// Генерация get'еров и set'еров
@Data
@AllArgsConstructor
public class Car {
    private int id;
    private double speed;
    private String color;
    private int number;

    @Override
    public String toString(){
        return "Объект id: " + id + " Скорость: " + speed +
                " Цвет: " + color + " Номер: " + number;
    }
}
