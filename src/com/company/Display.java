package com.company;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Alex on 3/5/2017.
 */
public class Display implements Observer {

    private Room room;

    public Display(Room room){
        this.room = room;
        room.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        synchronized (room){
            System.out.println("Room #" + room.getId() + " Doctors: " + room.getDoctors() + " | " + "Visitors: " + room.getVisitors());
        }
    }
}
