package ua.com.alevel.entity;


import java.util.Arrays;

public class Client extends BaseEntity {

    private String firstName;
    private String lastName;
    private String[] truckIdList = new String[10];

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName.matches(".*\\d.*")) {
            System.out.println("Incorrect information. First name can't contain numbers.");
        } else {
            this.firstName = firstName;
        }
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName.matches(".*\\d.*")) {
            System.out.println("Incorrect information. Last name can't contain numbers.");
        } else {
            this.lastName = lastName;
        }
    }

    public String[] getTruckIdList() {
        return truckIdList;
    }

    public void setTruckIdList(String[] truckIdList) {
        this.truckIdList = truckIdList;
    }

    @Override
    public String toString() {
        return "Client{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", truckIdList=" + Arrays.toString(truckIdList) +
                '}';
    }
}