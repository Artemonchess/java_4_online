package ua.com.alevel;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class СlientInterface {
    public void start() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Choose your option");
        String line;
        menu();
        while ((line = reader.readLine()) != null) {
            crud(reader, line);
        }
    }

    private void crud(BufferedReader reader, String line) throws Exception {
        switch (line) {
            case "1": createСlient(reader);
                break;
            case "2": findСlient(reader);
                break;
            case "3": findAll();
                break;
            case "4": updateСlient(reader);
                break;
            case "5": deleteСlient(reader);
                break;
            case "6": stop();
        }
        menu();
    }

    private void updateСlient(BufferedReader reader) throws Exception {
        System.out.println("Please enter the сlient,s phone number");
        String number = reader.readLine();
        Сlient сlient = СlientStorage.getByPhoneNUmber(number);
        if (сlient == null) {
            System.out.println("Number is invalid");
            return;
        }

        System.out.println("If you want to update the name, enter 1");
        System.out.println("If you want to update the surname, enter 2");
        System.out.println("If you want to update the age, enter 3");
        System.out.println("If you want to update the phone number, enter 4");
        System.out.println("If you want to update the salary, enter 5");

        String line = reader.readLine();
        switch (line) {
            case "1":
                System.out.println("Please enter new name");
                сlient.setFirstName(reader.readLine());
                break;
            case "2":
                System.out.println("Please enter new surname");
                сlient.setSurName(reader.readLine());
                break;
            case "3":
                System.out.println("Please enter new age");
                try {
                    сlient.setAge(Integer.parseInt(reader.readLine()));
                } catch (NumberFormatException e) {
                    System.out.println("Is not a number");
                }
                break;
            case "4":
                System.out.println("Please enter new phone number");
                сlient.setPhoneNumber(reader.readLine());
                break;
            case "5":
                System.out.println("Please enter new salary");
                try {
                    сlient.setSalary(Integer.parseInt(reader.readLine()));
                } catch (NumberFormatException e) {
                    System.out.println("Is not a number");
                }
        }
    }

    private void menu() {
        System.out.println();
        System.out.println("If you want to create an subscription, please enter 1");
        System.out.println("If you want to find the subscription, please enter 2");
        System.out.println("If you want to find all subscriptions, please enter 3");
        System.out.println("If you want to update the subscription, please enter 4");
        System.out.println("If you want to remove the subscription, please enter 5");
        System.out.println("If you want to close the application, please enter 6");
        System.out.println();
    }

    private void deleteСlient(BufferedReader reader) throws Exception {
        System.out.println("Please enter the phone number");
        СlientStorage.removeСlient(reader.readLine());
    }

    private void findСlient(BufferedReader reader) throws Exception {
        System.out.println("Please enter the phone number below");
        String number = reader.readLine();
        Сlient сlient = СlientStorage.getByPhoneNUmber(number);
        if (сlient == null) {
            System.out.println("There is no such number in the database");
        } else {
            System.out.println(сlient);
        }
    }

    private void findAll() {
        System.out.println("All сlient:");
        Сlient[] array = СlientStorage.getСlient();
        for (int i = 0; i < СlientStorage.getNotes(); i++) {
            System.out.println(array[i]);
        }
    }

    private void createСlient(BufferedReader reader) throws Exception {
        Сlient сlient = new Сlient();

        System.out.println("Please enter the first name");
        String name = reader.readLine();
        сlient.setFirstName(name);

        System.out.println("Please enter the surname");
        String surname = reader.readLine();
        сlient.setSurName(surname);

        System.out.println("Please enter the age");
        int age = 0;
        try {
            age = Integer.parseInt(reader.readLine());
        } catch (NumberFormatException e) {
            System.out.println("Is not a number");
        }
        сlient.setAge(age);

        System.out.println("Please enter the phone number");
        String number = reader.readLine();
        сlient.setPhoneNumber(number);

        System.out.println("Please enter the subscription ");
        int subscription  = 0;
        try {
            subscription  = Integer.parseInt(reader.readLine());
        } catch (NumberFormatException e) {
            System.out.println("Is not a number");
        }
        сlient.setSubscription (subscription );

        СlientStorage.addСlient(сlient);
    }

    private void stop() {
        System.exit(0);
    }
}