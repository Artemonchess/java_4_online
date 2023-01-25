package ua.com.alevel.db;

import ua.com.alevel.entity.Truck;
import ua.com.alevel.entity.Client;

import java.util.Arrays;
import java.util.UUID;

public class DbStorage {

    private static int capacity = 10;
    private static Client[] clients = new Client[capacity];
    private static Truck[] trucks = new Truck[capacity];
    private static int index = 0;

    private DbStorage() {
    }

    private static String generateClientId() {
        String id = UUID.randomUUID().toString();
        for (Client client : clients) {
            if (client != null) {
                if (client.getId().equals(id)) {
                    return generateClientId();
                }
            }
        }
        return id;
    }

    public static void addClient(Client client) {
        client.setId(generateClientId());
        if (index == clients.length) {
            clients = Arrays.copyOf(clients, clients.length + capacity);
        }
        clients[index] = client;
        index++;
    }

    private static String generateTruckId() {
        String id = UUID.randomUUID().toString();
        for (Truck truck : trucks) {
            if (truck != null) {
                if (truck.getId().equals(id)) {
                    return generateClientId();
                }
            }
        }
        return id;
    }

    public static void addTruck(Truck truck) {
        truck.setId(generateTruckId());
        if (index == trucks.length) {
            trucks = Arrays.copyOf(trucks, trucks.length + capacity);
        }
        trucks[index] = truck;
        index++;
    }

    public static Client[] findAllClients() {
        return clients;
    }

    public static Truck[] findAllTrucks() {
        return trucks;
    }

    public static Client getClient(String id) {
        for (Client client : clients) {
            if (client != null) {
                if (client.getId().equals(id)) {
                    return client;
                }
            }
        }
        return null;
    }

    public static void attach(String clientId, String truckId) {
        attachClientToTruck(clientId, truckId);
        attachTruckToClient(clientId, truckId);
    }

    private static void attachClientToTruck(String clientId, String truckId) {
        Truck truck = getTruck(truckId);
        String[] clients = truck.getClientIdList();
        clients = addUniqueElementToArray(clients, clientId);
        truck.setClientIdList(clients);
    }

    private static void attachTruckToClient(String clientId, String truckId) {
        Client client = getClient(clientId);
        String[] trucks = client.getTruckIdList();
        trucks = addUniqueElementToArray(trucks, truckId);
        client.setTruckIdList(trucks);
    }

    private static String[] addUniqueElementToArray(String[] array, String element) {
        int emptyIndex = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                if (array[i].equals(element)) {
                    return array;
                }
            } else if (emptyIndex == -1) {
                emptyIndex = i;
            }
        }

        if (emptyIndex == -1) {
            String[] temp = Arrays.copyOf(array, array.length + capacity);
            array = temp;
        }
        array[emptyIndex] = element;
        return array;
    }

    public static Truck getTruck(String id) {
        for (Truck truck : trucks) {
            if (truck != null) {
                if (truck.getId().equals(id)) {
                    return truck;
                }
            }
        }
        return null;
    }

    public static void deleteClient(String id) {
        for (int i = 0; i < clients.length; i++) {
            if (clients[i] != null) {
                if (clients[i].getId().equals(id)) {
                    clients[i] = null;
                }
            }
        }
    }

    public static void deleteClientFromTruckList(String id) {
        Client client = getClient(id);
        if (client == null) {
            System.out.println("Client " + id + " was not found");
            return;
        }
        String[] deleteList = client.getTruckIdList();
        for (int i = 0; i < deleteList.length; i++) {
            if (deleteList[i] != null) {
                if (deleteList[i].equals(id)) {
                    deleteList[i] = null;
                }
            }
        }
    }

    public static void deleteTruck(String id) {
        for (int i = 0; i < trucks.length; i++) {
            if (trucks[i] != null) {
                if (trucks[i].getId().equals(id)) {
                    trucks[i] = null;
                }
            }
        }
    }

    public static void deleteTruckFromClientList(String id) {
        Truck truck = getTruck(id);
        if (truck == null) {
            System.out.println("Truck " + id + " was not found");
            return;
        }
        String[] deleteList = truck.getClientIdList();
        for (int i = 0; i < deleteList.length; i++) {
            if (deleteList[i] != null) {
                if (deleteList[i].equals(id)) {
                    deleteList[i] = null;
                }
            }
        }
    }
}