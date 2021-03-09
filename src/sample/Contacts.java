package sample;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Contacts implements Serializable {
    ArrayList<Contact> contactsList = new ArrayList<>();
    String filename = "test_file";
    static Contacts contactsStatic;

    public static Contacts get(){
        if (contactsStatic == null)
            contactsStatic = new Contacts();
        return contactsStatic;
    }

    private Contacts() {
//        readObject();

        Organization org1 = new Organization("Org1name", "Org1number");
        Organization org2 = new Organization("Org2name", "Org2number");
        Organization org3 = new Organization("Org3name", "Org3number");
        contactsList.add(org1);
        contactsList.add(org2);
        contactsList.add(org3);
    }

    public List<Contact> getList(){
        return Collections.unmodifiableList(contactsList);
    }

    public void addContact(Contact contact){
        contactsList.add(contact);
        writeObject();
    }

    public void editContact(Contact contact, int index){
        contactsList.set(index, contact);
        writeObject();
    }

    public void removeContact(int index){
        contactsList.remove(index);
        writeObject();
    }

    private void writeObject () {
        if (filename != null) {
            try {
                FileOutputStream fos = new FileOutputStream(filename);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(contactsList);
                fos.close();
                oos.close();
                System.out.println("Written");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void readObject () {
        try {
            new File(filename).createNewFile();
            FileInputStream fis = new FileInputStream(filename);
            ObjectInputStream ois = new ObjectInputStream(fis);
            contactsList = (ArrayList<Contact>) ois.readObject();
            fis.close();
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

//    public void add(Scanner scanner) {
//        System.out.print("Enter the type (person, organization):");
//        String type = scanner.nextLine().trim();
//        if ("organization".equals(type)) {
//            Organization organization = new Organization();
//            organization.add(scanner);
//            contactsList.add(organization);
//            System.out.println("The record added.");
//        } else if ("person".equals(type)) {
//            Person person = new Person();
//            person.add(scanner);
//            contactsList.add(person);
//            System.out.println("The record added.");
//        }
//        writeObject();
//    }
//
//    public void count() {
//        readObject();
//        System.out.println("The Phone Book has " + contactsList.size() + " records.");
//    }
//
//    public ArrayList<String> list(Scanner scanner) {
//        readObject();
//        ArrayList<String> names = new ArrayList<>();
//        for (Contact contact : contactsList) {
//            names.add(contact.getName());
//        }
//        Pattern numberPattern = Pattern.compile("[1-9][0-9]*");
//        if (contactsList.size() == 0) {
//            System.out.println("No records to list!");
//        } else {
//            String currentAction = "[list]";
//            for (int i = 0; i < contactsList.size(); i++) {
//                System.out.printf("%d. %s %n", i+1, contactsList.get(i).getName());
//            }
//            System.out.printf("%n%s Enter action ([number], back):", currentAction);
//            String action = scanner.nextLine().trim();
//            Matcher numberMatcher = numberPattern.matcher(action);
//            if (numberMatcher.matches()) {
//                record(scanner, action);
//            }
//        }
//        if (names.isEmpty()) {
//            names.add("No records to list!");
//        }
//        return names;
//    }
//
//    public void remove(int userSelect) {
//        contactsList.remove(userSelect - 1);
//        System.out.println("The record removed!");
//    }
//
//    public void edit(Scanner scanner, int userSelect) {
//        contactsList.get(userSelect- 1).edit(scanner);
//    }
//
//    public void search(Scanner scanner) {
//        ArrayList<Contact> searchList = new ArrayList<>();
//        String currentAction = "[search]";
//        boolean search = true;
//        while (search) {
//            System.out.print("Enter search query:");
//            String searchedContact = scanner.nextLine().trim();
//
//            for (int i = 0; i < contactsList.size(); i++) {
//                if (contactsList.get(i).containsQuery(searchedContact)) {
//                    searchList.add(contactsList.get(i));
//                    System.out.printf("%d. %s", i + 1, contactsList.get(i).getName());
//                }
//            }
//
//            System.out.printf("%n%s Enter action ([number], back, again):", currentAction);
//            String action = scanner.nextLine().trim();
//
//            switch (action) {
//                case "back":
//                    search = false;
//                    break;
//                case "again":
//                    System.out.println();
//                    break;
//                default:
//                    boolean menu = false;
//                    currentAction = "[record]";
//                    int userSelect = Integer.parseInt(action);
//                    searchList.get(Integer.parseInt(action) - 1).info();
//                    while (!menu) {
//                        System.out.printf("%n%s Enter action (edit, delete, menu):", currentAction);
//                        action = scanner.nextLine().trim();
//                        switch (action) {
//                            case "edit" -> edit(scanner, userSelect);
//                            case "delete" -> remove(userSelect);
//                            case "menu" -> {
//                                menu = true;
//                                search = false;
//                            }
//                        }
//                        writeObject();
//                    }
//                    break;
//            }
//        }
//    }
//
//    public void record(Scanner scanner, String action) {
//        boolean menu = false;
//        String currentAction = "[record]";
//        int userSelect = Integer.parseInt(action);
//        contactsList.get(Integer.parseInt(action) - 1).info();
//        while (!menu) {
//            System.out.printf("%n%s Enter action (edit, delete, menu):", currentAction);
//            action = scanner.nextLine().trim();
//            switch (action) {
//                case "edit" -> edit(scanner, userSelect);
//                case "delete" -> remove(userSelect);
//                case "menu" -> menu = true;
//            }
//            writeObject();
//        }
//    }
}