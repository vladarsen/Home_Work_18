package com.vladarsenjtev;

public class ValueCalculator {

    private final double[] arr = new double[1000000];
    private final double count = arr.length;
    private final int middleСount = arr.length / 2;

    public long doCalc() throws Exception {
        long start = System.currentTimeMillis();
        long finish;
        double[] arrOne = new double[middleСount];
        double[] arrTwo = new double[middleСount];


        for (int i = 0; i < arr.length; i++) {
            this.arr[i] = 1;
        }
        System.arraycopy(arr, 0, arrOne, 0, arrOne.length);
        System.arraycopy(arr, middleСount, arrTwo, 0, arrTwo.length);

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < arrOne.length; i++) {
                    arrOne[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < arrTwo.length; i++) {
                    arrTwo[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
            }
        });
        t1.start();
        t2.start();

        t1.join();
        t1.join();

        System.arraycopy(arrOne, 0, arr, 0, arrOne.length);
        System.arraycopy(arrTwo, 0, arr, arrOne.length, arrTwo.length);

        finish = System.currentTimeMillis() - start;
        return finish;
    }
}