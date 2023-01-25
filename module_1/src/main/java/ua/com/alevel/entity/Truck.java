package ua.com.alevel.entity;

import java.util.Arrays;

public class Truck extends BaseEntity {

    private static Truck[] trucksArray = new Truck[10];
    private String truckNumber;
    private String truckModel;
    private String[] clientIdList = new String[10];

    public String getTruckNumber() {
        return truckNumber;
    }

    public void setTruckNumber(String truckNumber) {
        this.truckNumber = truckNumber;
    }

    public String getTruckModel() {
        return truckModel;
    }

    public void setTruckModel(String truckModel) {
        this.truckModel = truckModel;
    }

    public String[] getClientIdList() {
        return clientIdList;
    }

    public void setClientIdList(String[] clientIdList) {
        this.clientIdList = clientIdList;
    }

    @Override
    public String toString() {
        return "Truck{" +
                "truckNumber='" + truckNumber + '\'' +
                ", truckModel='" + truckModel + '\'' +
                ", clientIdList=" + Arrays.toString(clientIdList) +
                '}';
    }
}