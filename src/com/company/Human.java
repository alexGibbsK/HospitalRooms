package com.company;

/**
 * Created by Alex on 3/5/2017.
 */
abstract class Human extends Thread {

    private int time;

    public Human(int time){
        this.time = time;
    }

    @Override
    public void run() {
        try{
            enter();
            Thread.sleep(time);
            exit();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    abstract void enter() throws InterruptedException;
    abstract void exit() throws InterruptedException;
}
