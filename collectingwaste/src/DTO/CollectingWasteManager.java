/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.lang.reflect.Array;

/**
 *
 * @author xuant
 */
public class CollectingWasteManager {

    private GarbageStation[] stations;
    private static final int TIME_TO_lOAD = 8;
    private static final int TIME_TO_GO = 30;
    private static final int COST_TRUCK = 57000;
    private static final int COST_LABEL = 120000;
    private double Total = 0;
    private double time = 0;
    private double totalCost = 0;
    private int numberOfTruck = 0;

    public CollectingWasteManager() {
        stations = new GarbageStation[13];
        stations[0] = new GarbageStation("station1", 1765);
        stations[1] = new GarbageStation("station2", 2808);
        stations[2] = new GarbageStation("station3", 952);
        stations[3] = new GarbageStation("station4", 4206);
        stations[4] = new GarbageStation("station5", 3102);
        stations[5] = new GarbageStation("station6", 3902);
        stations[6] = new GarbageStation("station7", 1292);
        stations[7] = new GarbageStation("station8", 3985);
        stations[8] = new GarbageStation("station9", 8324);
        stations[9] = new GarbageStation("station10", 1928);
        stations[10] = new GarbageStation("station11", 4426);
        stations[11] = new GarbageStation("station12", 397);
        stations[12] = new GarbageStation("station13", 3277);
    }

    public void CollectingGarbage() {
        System.out.println("Collecting");
        for (int i = 0; i < stations.length;) {
            System.out.println("time: " + time);
            System.out.println(stations[i]);
            if (Total + stations[i].getNumberOfGarbage() > 10000) {
                Total = 0;
                numberOfTruck++;
                time += TIME_TO_GO;
                System.out.println("Total: " + Total);
            } else {
                Total += stations[i].getNumberOfGarbage();
                stations[i].setNumberOfGarbage(0);
                time += TIME_TO_lOAD;
                System.out.println("Total: " + Total);
                i++;
            }

        }
        if(Total>0){
        numberOfTruck++;
        time += 30;
        }
        totalCost = time / 60 * COST_LABEL + numberOfTruck * COST_TRUCK;
        System.out.println("time " + time);
        System.out.println("number of truck " + numberOfTruck);
        System.out.println("The total cost for the clollecting garbage trip today is " + totalCost);
    }
}
