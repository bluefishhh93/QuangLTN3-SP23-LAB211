/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author xuant
 */
public class GarbageStation {
    private String stationName;
    private int numberOfGarbage;

    public GarbageStation() {
    }

    public GarbageStation(String stationName, int numberOfGarbage) {
        this.stationName = stationName;
        this.numberOfGarbage = numberOfGarbage;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public int getNumberOfGarbage() {
        return numberOfGarbage;
    }

    public void setNumberOfGarbage(int numberOfGarbage) {
        this.numberOfGarbage = numberOfGarbage;
    }

    
    
    @Override
    public String toString() {
        return "GarbageStation{" + "stationName=" + stationName + ", numberOfGarbage=" + numberOfGarbage + '}';
    }
    
    
}
