package com.company;

import java.util.Observable;
import java.util.Random;

/**
 * Created by Alex on 3/5/2017.
 */
public class Room extends Observable implements Runnable{
    private int id;
    private int doctors;
    private int visitors;
    private Random r = new Random();

    private static final double PROBABILITY_DOCTOR = 0.2;
    private static final double PROBABILITY_VISITOR = 0.5;

    public Room(int id) {
        this.id = id;
    }

    public synchronized void notifyDisplay(){
        setChanged();
        notifyObservers();
    }

    public int getId() {
        return id;
    }

    public int getDoctors() {
        return doctors;
    }

    public int getVisitors() {
        return visitors;
    }

    public void doctorCount(int counter){
        this.doctors += counter;
    }

    public void visitorsCount(int counter){
        this.visitors += counter;
    }



    @Override
    public void run() {
        while(true){
            if(r.nextDouble()<PROBABILITY_VISITOR){
                new Visitor(this).start();
            }
            if(r.nextDouble()<PROBABILITY_DOCTOR){
                new Doctor(this).start();
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
