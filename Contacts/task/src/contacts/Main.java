package contacts;

import java.io.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        boolean exit = false;
        Contacts contacts;
        if (args.length == 1){
             contacts = new Contacts(args[0]);
        } else{
            contacts = new Contacts();
        }
        Scanner scanner = new Scanner(System.in);
        String currentAction;

        while (!exit) {
            currentAction = "[menu]";
            System.out.printf("%s Enter action (add, list, search, count, exit):", currentAction);
            switch (scanner.nextLine().trim()) {
                case "exit":
                    exit = true;
                    break;
                case "add":
                    contacts.add(scanner);
                    break;
                case "count":
                    contacts.count();
                    break;
                case "list":
                    contacts.list(scanner);
                    break;
                case "search":
                    contacts.search(scanner);
                    break;
            }
            if (!exit) System.out.println();
        }
        scanner.close();
    }

}

class Contacts implements Serializable {
    ArrayList<Contact> contacts = new ArrayList<>();
    String filename = null;

    public Contacts(String filename) {
        this.filename = filename;
        readObject();
    }

    public Contacts() {}

    private void writeObject () {
        if (filename != null) {
            try {
                FileOutputStream fos = new FileOutputStream(filename);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(contacts);
                fos.close();
                oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void readObject () {
        try{
            FileInputStream fis = new FileInputStream(filename);
            ObjectInputStream ois = new ObjectInputStream(fis);
            contacts = (ArrayList<Contact>) ois.readObject();
            fis.close();
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void add(Scanner scanner) {
        System.out.print("Enter the type (person, organization):");
        String type = scanner.nextLine().trim();
        if ("organization".equals(type)) {
            Organization organization = new Organization();
            organization.add(scanner);
            contacts.add(organization);
            System.out.println("The record added.");
        } else if ("person".equals(type)) {
            Person person = new Person();
            person.add(scanner);
            contacts.add(person);
            System.out.println("The record added.");
        }
        writeObject();
    }

    public void count() {
        System.out.println("The Phone Book has " + contacts.size() + " records.");
    }

    public void list(Scanner scanner) {
        Pattern numberPattern = Pattern.compile("[1-9][0-9]*");
        if (contacts.size() == 0) {
            System.out.println("No records to list!");
        } else {
            String currentAction = "[list]";
            for (int i = 0; i < contacts.size(); i++) {
                System.out.printf("%d. %s %n", i+1, contacts.get(i).getName());
            }
            System.out.printf("%n%s Enter action ([number], back):", currentAction);
            String action = scanner.nextLine().trim();
            Matcher numberMatcher = numberPattern.matcher(action);
            if (numberMatcher.matches()) {
                record(scanner, action);
            }
        }
    }

    public void remove(int userSelect) {
        contacts.remove(userSelect - 1);
        System.out.println("The record removed!");
    }

    public void edit(Scanner scanner, int userSelect) {
        contacts.get(userSelect- 1).edit(scanner);
    }

    public void search(Scanner scanner) {

        ArrayList<Contact> searchList = new ArrayList<>();
        String currentAction = "[search]";
        boolean search = true;
        while (search) {
            System.out.print("Enter search query:");
            String searchedContact = scanner.nextLine().trim();

            for (int i = 0; i < contacts.size(); i++) {
                if (contacts.get(i).containsQuery(searchedContact)) {
                    searchList.add(contacts.get(i));
                    System.out.printf("%d. %s", i + 1, contacts.get(i).getName());
                }
            }

            System.out.printf("%n%s Enter action ([number], back, again):", currentAction);
            String action = scanner.nextLine().trim();

            switch (action) {
                case "back":
                    search = false;
                    break;
                case "again":
                    System.out.println();
                    break;
                default:
                    boolean menu = false;
                    currentAction = "[record]";
                    int userSelect = Integer.parseInt(action);
                    searchList.get(Integer.parseInt(action) - 1).info();
                    while (!menu) {
                        System.out.printf("%n%s Enter action (edit, delete, menu):", currentAction);
                        action = scanner.nextLine().trim();
                        switch (action) {
                            case "edit":
                                edit(scanner, userSelect);
                                break;
                            case "delete":
                                remove(userSelect);
                                break;
                            case "menu":
                                menu = true;
                                search = false;
                                break;
                        }
                        writeObject();
                    }
                    break;
            }
        }
    }

    public void record(Scanner scanner, String action) {
        boolean menu = false;
        String currentAction = "[record]";
        int userSelect = Integer.parseInt(action);
        contacts.get(Integer.parseInt(action) - 1).info();
        while (!menu) {
            System.out.printf("%n%s Enter action (edit, delete, menu):", currentAction);
            action = scanner.nextLine().trim();
            switch (action) {
                case "edit":
                    edit(scanner, userSelect);
                    break;
                case "delete":
                    remove(userSelect);
                    break;
                case "menu":
                    menu = true;
                    break;
            }
            writeObject();
        }
    }
}



abstract class Contact implements Serializable {
    static Pattern pattern = Pattern.compile("(\\+?(\\([a-z0-9]+\\))([- ][a-z0-9]{2,}[- ]?)*)|(\\+?([a-z0-9]+)([- ]\\([a-z0-9]{2,}\\))([- ][a-z0-9]{2,}[- ]?)*)|(\\+?([a-z0-9]+)([- ][a-z0-9]{2,}[- ]?)*)", Pattern.CASE_INSENSITIVE);

    public static boolean isValidNumber(String number) {
        Matcher matcher = pattern.matcher(number);
        return matcher.matches();
    }

    public abstract void add(Scanner scanner);

    public abstract void edit(Scanner scanner);

    public abstract void info();

    public abstract boolean containsQuery(String query);

    public abstract String getName();
}

class Organization extends Contact {
    String name;
    String address;
    String number;
    LocalDateTime created;
    LocalDateTime lastEdit;

    @Override
    public void add(Scanner scanner) {
        System.out.print("Enter the name:");
        name = scanner.nextLine();
        System.out.print("Enter the address:");
        address = scanner.nextLine().trim();
        System.out.print("Enter the number:");
            number = scanner.nextLine();
        if (!Contact.isValidNumber(number)) {
            System.out.print("Wrong number format!");
            number = "[no number]";
        }
        created = LocalDateTime.now().withNano(0).withSecond(0);
        lastEdit = LocalDateTime.now().withNano(0).withSecond(0);
    }

    @Override
    public void edit(Scanner scanner) {
        System.out.print("Select a field (name, address, number):");
        String userSelectionEdit = scanner.nextLine().trim();
        switch (userSelectionEdit) {
            case "name":
                System.out.print("Enter the name:");
                name = scanner.nextLine();
                break;
            case "address":
                System.out.print("Enter the address:");
                address = scanner.nextLine().trim();
                break;
            case "number":
                System.out.print("Enter the number:");
                    number = scanner.nextLine();
                if (!Contact.isValidNumber(number)) {
                    System.out.println("Wrong number format!");
                    number = "[no number]";
                }
                break;
        }
        lastEdit = LocalDateTime.now().withNano(0).withSecond(0);
        System.out.println("Saved");
        info();
    }

    @Override
    public void info() {
        System.out.println("Organization name: " + name);
        System.out.println("Address: " + address);
        System.out.println("Number: " + number);
        System.out.println("Time created: " + created);
        System.out.println("Time last edit: " + lastEdit);
    }

    @Override
    public boolean containsQuery(String query) {
        if (name.toLowerCase().contains(query.toLowerCase())){
            return true;
        } else if (address.toLowerCase().contains(query.toLowerCase())){
            return true;
        } else if (number.toLowerCase().contains(query.toLowerCase())){
            return true;
        }
        return false;
    }

    @Override
    public String getName() {
        return name;
    }
}

class Person extends Contact {
    String name;
    String surname;
    String birthDate;
    String gender;
    String number;
    LocalDateTime created;
    LocalDateTime lastEdit;

    Pattern datePattern = Pattern.compile("[0-9]+");

    public boolean isValidDate(String date){
        String[] birth = date.split("-");
        for (String s : birth) {
            Matcher ifDate = datePattern.matcher(s);
            if (!ifDate.matches()) {
                return false;
            }
        }
        if (birth.length == 3) {
            boolean year = Integer.parseInt(birth[0]) > 0;
            boolean month = Integer.parseInt(birth[1]) > 0 && Integer.parseInt(birth[1]) < 13;
            boolean day = Integer.parseInt(birth[2]) > 0 && Integer.parseInt(birth[2]) < 32;
            return year && month && day;
        }
        return false;
    }

    @Override
    public void add(Scanner scanner) {
        System.out.print("Enter the name:");
        name = scanner.nextLine().trim();
        System.out.print("Enter the surname:");
        surname = scanner.nextLine().trim();
        System.out.print("Enter the birth date:");
        String newDate = scanner.nextLine().trim();
        if (isValidDate(newDate)){
            birthDate = newDate;
        } else{
            System.out.println("Bad birth date!");
            birthDate = "[no data]";
        }
        System.out.print("Enter the gender (M, F):");
        gender = scanner.nextLine().trim();
        if (!("M".equals(gender) || "F".equals(gender))) {
            System.out.println("Bad gender!");
            gender = "[no data]";
        }
        System.out.print("Enter the number:");
            number = scanner.nextLine();
        if (!Contact.isValidNumber(number)) {
            System.out.println("Wrong number format!");
            number = "[no number]";
        }
        created = LocalDateTime.now().withNano(0).withSecond(0);
        lastEdit = LocalDateTime.now().withNano(0).withSecond(0);
    }

    @Override
    public void edit(Scanner scanner) {
        System.out.print("Select a field (name, surname, birth, gender, number):");
        String userSelectionEdit = scanner.nextLine().trim();
        switch (userSelectionEdit) {
            case "name":
                System.out.print("Enter name:");
                name = scanner.nextLine().trim();
                break;
            case "surname":
                System.out.print("Enter surname:");
                surname = scanner.nextLine().trim();
                break;
            case "birth":
                System.out.print("Enter birth date:");
                String newDate = scanner.nextLine().trim();
                if (isValidDate(newDate)){
                    birthDate = newDate;
                } else {
                    System.out.println("Bad birth date!");
                    birthDate = "[no data]";
                }
                break;
            case "gender":
                System.out.print("Enter the gender (M, F):");
                gender = scanner.nextLine().trim();
                if (!("M".equals(gender) || "F".equals(gender))) {
                    System.out.println("Bad gender!");
                    gender = "[no data]";
                }
                break;
            case "number":
                System.out.print("Enter the number:");
                    number = scanner.nextLine();
                if (!isValidNumber(number)) {
                    System.out.println("Wrong number format!");
                    number = "[no number]";
                }
                break;
        }
        lastEdit = LocalDateTime.now().withNano(0).withSecond(0);
        System.out.println("Saved");
        info();
    }

    @Override
    public void info() {
        System.out.println("Name: " + name);
        System.out.println("Surname: " + surname);
        System.out.println("Birth date: " + birthDate);
        System.out.println("Gender: " + gender);
        System.out.println("Number: " + number);
        System.out.println("Time created: " + created);
        System.out.println("Time last edit: " + lastEdit);
    }

    @Override
    public boolean containsQuery(String query) {
        if (name.toLowerCase().contains(query.toLowerCase())){
            return true;
        } else if (surname.toLowerCase().contains(query.toLowerCase())){
            return true;
        } else if (birthDate.toLowerCase().contains(query.toLowerCase())){
            return true;
        } else if (gender.toLowerCase().contains(query.toLowerCase())){
            return true;
        } else if (number.toLowerCase().contains(query.toLowerCase())){
            return true;
        }
        return false;
    }

    @Override
    public String getName() {
        return String.format("%s %s", name, surname);
    }
}

