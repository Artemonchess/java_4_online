package ua.com.alevel;

public class СlientStorage {
    private static int notes;
    private static final int DEFAULT_CAPACITY = 10;
    private static int size = DEFAULT_CAPACITY;
    private static Сlient[] data = new Сlient[DEFAULT_CAPACITY];

    private СlientStorage() {}

    public static Сlient[] getСlient() {
        return data;
    }

    private static void increaseSize() {
        Сlient[] newData = new Сlient[data.length * 2];
        for (int i = 0; i < data.length; i++) {
            newData[i] = data[i];
        }
        size = newData.length;
        data = newData;
    }

    public static void addСlient(Сlient сlient) {
        data[notes] = сlient;
        notes++;
        if (notes == size) {
            increaseSize();
        }
    }

    public static Сlient getByPhoneNUmber(String phoneNumber) {
        for (int i = 0; i < notes; i++) {
            if (data[i].getPhoneNumber().equals(phoneNumber)) {
                return data[i];
            }
        }
        return null;
    }

    public static void removeСlient(String phoneNumber) {
        int index = -1;
        for (int i = 0; i < notes; i++) {
            if (data[i].getPhoneNumber().equals(phoneNumber)) {
                index = i;
            }
        }
        if (index == -1) {
            System.out.println("There is no such number in the database");
            return;
        }
        for (int i = index; i < data.length - 1; i++) {
            data[i] = data[i + 1];
            data[i + 1] = null;
        }
        notes--;
    }

    public static int getNotes() {
        return notes;
    }
}