package com.company;

/**
 * Created by Alex on 3/5/2017.
 */
public class Visitor extends Human {
    private Room room;

    public Visitor(Room room) {
        super(3000);
        this.room = room;
    }

    @Override
    public void enter() throws InterruptedException {
        synchronized (room) {
            while (room.getDoctors() > 0 || room.getVisitors() >= 4) {
                room.wait();
            }
            room.visitorsCount(1);
            room.notifyDisplay();
        }
    }

    @Override
    public void exit() {
        synchronized (room) {
            room.visitorsCount(-1);
            room.notify();
            room.notifyDisplay();
        }
    }
}
