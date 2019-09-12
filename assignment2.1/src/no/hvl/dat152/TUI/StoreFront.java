package no.hvl.dat152.TUI;

import java.util.Objects;
import java.util.ResourceBundle;
import java.util.Scanner;

public class StoreFront {
    private static boolean runStore = true;
    private static ResourceBundle resBoundle;

    public static void interfaceLoop(ResourceBundle res){
        Scanner sc = new Scanner(System.in);
        resBoundle = res;
        while (runStore){
            printMainMenuChoices();
            String userChoice = sc.nextLine();
            if (checkForValidChoice(userChoice)) {
                findAndRunChoice(userChoice);
            } else {
                System.out.println(resBoundle.getString("invalidChoice"));
            }
        }
    }

    public static void printMainMenuChoices() {
        System.out.println("\n\n" + resBoundle.getString("welcomeMessage") + "\n");
        System.out.println(resBoundle.getString("choiceOne"));
        System.out.println(resBoundle.getString("choiceTwo"));
        System.out.println(resBoundle.getString("choiceExit"));
    }

    public static boolean checkForValidChoice(String userChoice) {
        return userChoice.matches("\\b[129]\\b");
    }

    public static void findAndRunChoice(String userChoice){
        int choice = Integer.parseInt(userChoice);
        switch (choice) {
            case 1:
                displayStoreItems();
                break;
            case 2:
                displayCart();
                break;
            case 9:
                exitStore();
                break;
        }
    }

    private static void displayCart() {
    }

    private static void displayStoreItems(){

    }

    private static void exitStore() {
        runStore = false;
        System.out.println(resBoundle.getString("exitingStore"));
    }
}
