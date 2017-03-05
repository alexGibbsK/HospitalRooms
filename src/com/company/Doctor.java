package com.company;

/**
 * Created by Alex on 3/5/2017.
 */
public class Doctor extends Human {
    private Room room;

    public Doctor(Room room) {
        super(3000);
        this.room = room;
    }

    @Override
    void enter() throws InterruptedException {
        synchronized (room){
            while (room.getDoctors() > 0 || room.getVisitors() > 0){
                room.wait();
            }
            room.doctorCount(1);
            room.notifyDisplay();
        }
    }

    @Override
    void exit() {
        synchronized (room) {
            room.doctorCount(-1);
            room.notify();
            room.notifyDisplay();
        }
    }
}
