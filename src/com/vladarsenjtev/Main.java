package com.vladarsenjtev;

public class Main {

    public static void main(String[] args) throws Exception {
        ValueCalculator valueCalculator = new ValueCalculator();

        System.out.println("Время затраченное на выполнение программы: " + valueCalculator.doCalc() / 1000.00 + " сек");
    }
}
