package ua.com.alevel;

import ua.com.alevel.db.DbStorage;
import ua.com.alevel.entity.Truck;
import ua.com.alevel.entity.Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class TruckInterface {

    public static void start() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Welcome to truck rent service!");
        System.out.println("Please select your option:");
        String input;
        menu();
        while ((input = reader.readLine()) != null) {
            crud(reader, input);
        }
    }

    private static void menu() {
        System.out.println("If You want to create a new client, please enter 1");
        System.out.println("If You want to create a new truck, please enter 2");
        System.out.println("If You want to find a client, please enter 3");
        System.out.println("If You want to find a truck, please enter 4");
        System.out.println("If You want to find all clients, please enter 5");
        System.out.println("If You want to find all trucks, please enter 6");
        System.out.println("If You want to update a client, please enter 7");
        System.out.println("If You want to update a trucks, please enter 8");
        System.out.println("If You want to attach a client to the car, please enter 9");
        System.out.println("If You want to attach a truck to the client, please enter 10");
        System.out.println("If You want to delete a client, please enter 11");
        System.out.println("If You want to delete a truck, please enter 12");
        System.out.println("If You want to close application, please enter 13");
    }

    private static void crud(BufferedReader reader, String input) throws IOException {
        switch (input) {
            case "1":
                createClient(reader);
                break;
            case "2":
                createTruck(reader);
                break;
            case "3":
                findClient(reader);
                break;
            case "4":
                findTruck(reader);
                break;
            case "5":
                findAllClients();
                break;
            case "6":
                findAllTrucks();
                break;
            case "7":
                updateClient(reader);
                break;
            case "8":
                updateTruck(reader);
                break;
            case "9":
                attachClientToTruck(reader);
                break;
            case "10":
                attachTruckToClient(reader);
                break;
            case "11":
                deleteClient(reader);
                break;
            case "12":
                deleteTruck(reader);
                break;
            case "13":
                stop();
                break;
            case "":
                break;
            default:
                System.out.println("Something went wrong... Try again please");
        }
        menu();
    }

    private static void createClient(BufferedReader reader) throws IOException {
        System.out.println("Let's create a new client.");
        System.out.println("Please enter client's first name:");
        String firstName = reader.readLine();
        System.out.println("Please enter client's last name:");
        String lastName = reader.readLine();
        Client client = new Client();
        client.setFirstName(firstName);
        client.setLastName(lastName);
        DbStorage.addClient(client);
        System.out.println("New client is created. His/her ID is " + client.getId());
    }

    private static void createTruck(BufferedReader reader) throws IOException {
        System.out.println("Let's create a new truck.");
        System.out.println("Please enter truck's model:");
        String truckModel = reader.readLine();
        System.out.println("Please enter truck's number:");
        String truckNumber = reader.readLine();
        Truck truck = new Truck();
        truck.setTruckModel(truckModel);
        truck.setTruckNumber(truckNumber);
        DbStorage.addTruck(truck);
        System.out.println("New truck is created. It's ID is " + truck.getId());
    }

    private static void findClient(BufferedReader reader) throws IOException {
        System.out.println("To find the client please enter client's ID:");
        String clientId = reader.readLine();
        Client client = DbStorage.getClient(clientId);
        if (client == null) {
            System.out.println("This client does not exist.");
        } else {
            System.out.println(client);
        }
    }

    private static void findTruck(BufferedReader reader) throws IOException {
        System.out.println("To find the truck please enter truck's ID:");
        String truckId = reader.readLine();
        Truck truck = DbStorage.getTruck(truckId);
        if (truck == null) {
            System.out.println("This truck does not exist.");
        } else {
            System.out.println(truck);
        }
    }

    private static void findAllClients() {
        System.out.println("Clients list:");
        Client[] clients = DbStorage.findAllClients();
        for (Client client : clients) {
            if (client != null) {
                System.out.println(client);
            }
        }
    }

    private static void findAllTrucks() {
        System.out.println("trucks list:");
        Truck[] trucks = DbStorage.findAllTrucks();
        for (Truck truck : trucks) {
            if (truck != null) {
                System.out.println(truck);
            }
        }
    }

    private static void updateClient(BufferedReader reader) throws IOException {
        System.out.println("Let's update client's information. To start, please enter client's ID:");
        String clientId = reader.readLine();
        Client client = DbStorage.getClient(clientId);
        if (client == null) {
            System.out.println("This client does not exist.");
        } else {
            System.out.println("Please enter client's first name:");
            String firstName = reader.readLine();
            client.setFirstName(firstName);
            System.out.println("Please enter client's last name:");
            String lastName = reader.readLine();
            client.setLastName(lastName);
            System.out.println("Thank you, the client's information is updated.");
        }
    }

    private static void updateTruck(BufferedReader reader) throws IOException {
        System.out.println("Let's update truck's information. To start, please enter truck's ID:");
        String truckId = reader.readLine();
        Truck truck = DbStorage.getTruck(truckId);
        if (truck == null) {
            System.out.println("This truck does not exist.");
        } else {
            System.out.println("Please enter truck's number:");
            String truckNumber = reader.readLine();
            truck.setTruckNumber(truckNumber);
            System.out.println("Please enter truck's model:");
            String truckModel = reader.readLine();
            truck.setTruckModel(truckModel);
            System.out.println("Thank you, the truck's information is updated.");
        }
    }

    private static void attachClientToTruck(BufferedReader reader) throws IOException {
        System.out.println("Let's attach the client to truck. To start, please enter client's ID:");
        String clientId = reader.readLine();
        System.out.println("Then please enter truck's ID:");
        String truckId = reader.readLine();
        if (clientId == null || truckId == null) {
            System.out.println("This ID does not exist.");
        } else {
            DbStorage.attach(clientId, truckId);
            System.out.println("Attachment is successful.");
        }
    }

    private static void attachTruckToClient(BufferedReader reader) throws IOException {
        System.out.println("Let's attach the truck to client. To start, please enter truck's ID:");
        String truckId = reader.readLine();
        System.out.println("Then please enter client's ID:");
        String clientId = reader.readLine();
        if (clientId == null || truckId == null) {
            System.out.println("This ID does not exist.");
        } else {
            DbStorage.attach(clientId, truckId);
            System.out.println("Attachment is successful.");
        }
    }

    private static void deleteClient(BufferedReader reader) throws IOException {
        System.out.println("To delete the client please enter his ID:");
        String clientId = reader.readLine();
        DbStorage.deleteClient(clientId);
        DbStorage.deleteClientFromTruckList(clientId);
        System.out.println("The client is deleted.");
    }

    private static void deleteTruck(BufferedReader reader) throws IOException {
        System.out.println("To delete the truck please enter it's ID:");
        String truckId = reader.readLine();
        DbStorage.deleteTruck(truckId);
        DbStorage.deleteTruckFromClientList(truckId);
        System.out.println("The truck is deleted.");
    }

    private static void stop() {
        System.exit(0);
    }
}