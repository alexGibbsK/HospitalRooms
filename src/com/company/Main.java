package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Start");
        int roomsCount = 2;
        int roomId = 0;

        List<Room> roomsList = new ArrayList<>();
        ExecutorService executorService = Executors.newFixedThreadPool(roomsCount);


        for (int i = 0; i < roomsCount; i++) {
            roomsList.add(new Room(++roomId));
            new Display(roomsList.get(i));
        }

        for (Room room :
                roomsList) {
            executorService.submit(room);
        }



    }
}
